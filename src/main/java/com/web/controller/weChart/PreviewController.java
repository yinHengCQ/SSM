package com.web.controller.weChart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.Article;
import com.web.entity.Category;
import com.web.entity.SlideAdvs;
import com.web.entity.Templet;
import com.web.service.ArticleService;
import com.web.service.CategoryService;
import com.web.service.ReplyNewsService;
import com.web.service.ReplyService;
import com.web.service.SlideAdvsService;
import com.web.service.TempletService;
import com.web.util.PageUtil;

import net.sf.json.JSONArray;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/weChart")
public class PreviewController {
	
	@Resource(name="articleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name="categoryServiceImpl")
	private CategoryService categoryService;
	
	@Resource(name="replyServiceImpl")
	private ReplyService replyService;
	
	@Resource(name="replyNewsServiceImpl")
	private ReplyNewsService replyNewsService;
	
	@Resource(name="slideAdvsServiceImpl")
	private SlideAdvsService slideAdvsService;
	
	@Resource(name="templetServiceImpl")
	private TempletService templetService;
	
	
	@RequestMapping(value="/preview")
	public String preview(Integer id,Model model){
		Templet templet=templetService.findById(id);
		//由于存入数据库中的是字符串，所以需要先将字符串转化成集合或数组，再转化成对象集合List
		
		//处理幻灯片
		String[] list_slideAdvs=templet.getListSlideAdvs().split(",");
		List<SlideAdvs> list_s=new ArrayList<>();
		for (String s : list_slideAdvs) {
			list_s.add(slideAdvsService.findById(Integer.parseInt(s)));
		}
		model.addAttribute("list_slideAdvs", list_s);
		
		//处理分类Json
		String old_list_category=templet.getListCategory();
		//去掉[],并按照"，"进行元素分割
		String[] list_category=old_list_category.substring(1, old_list_category.length()-1).split(",");
		List<Category> list_c=new ArrayList<>();
		for (String s : list_category) {			
			Category cate=categoryService.findById(Integer.parseInt(s));
			//判断分类的外部链接是否是http开头的，否则就读取该分类Id的文章信息
			if (null==cate.getCateUrl()||!cate.getCateUrl().startsWith("http")) {
				cate.setCateUrl("/WeChart/weChart/showArtticleByCategoryPre.do?id="+cate.getCateId());
			}
			list_c.add(cate);
		}
		model.addAttribute("list_category", list_c);

		return "/preview";
	}	

	//添加cateId到Session中，并跳转到showArtticleByCategory.do
	@RequestMapping(value="/showArtticleByCategoryPre")
	public String showArtticleByCategoryPre(int id,HttpSession session){
		session.setAttribute("cateId", id);
		return "redirect:/weChart/showArtticleByCategory.do";
	}
	
	@RequestMapping(value="/showArtticleByCategory")
	public String showArtticleByCategory(Integer page,HttpSession session,Model model){
		PageUtil<Article> paging=new PageUtil<>();
		if (null!=page) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("cateId", session.getAttribute("cateId"));
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		articleService.searchPaging(builder, paging);
		
		model.addAttribute("paging", paging);
		return "/showArtticleByCategory";
	}
	
	@RequestMapping(value="/showArticleContext")
	public String showArticleContext(int id,Model model){
		model.addAttribute("articleContext", articleService.findById(id).getArticleContext());
		return "/showArticleContext";
	}
	
	@RequestMapping(value="/previewByJson")
	public void previewByJson(Integer id,HttpServletResponse response){
		JSONArray json=new JSONArray();

		Templet templet=templetService.findById(id);
		//由于存入数据库中的是字符串，所以需要先将字符串转化成集合或数组，再转化成对象集合List
		
		//处理幻灯片
		String[] list_slideAdvs=templet.getListSlideAdvs().split(",");
		List<SlideAdvs> list_s=new ArrayList<>();
		for (String s : list_slideAdvs) {
			list_s.add(slideAdvsService.findById(Integer.parseInt(s)));
		}
		json.add(0, list_s);
		
		//处理分类Json
		String old_list_category=templet.getListCategory();
		//去掉[],并按照"，"进行元素分割
		String[] list_category=old_list_category.substring(1, old_list_category.length()-1).split(",");
		List<Category> list_c=new ArrayList<>();
		for (String s : list_category) {			
			Category cate=categoryService.findById(Integer.parseInt(s));
			//判断分类的外部链接是否是http开头的，否则就读取该分类Id的文章信息
			if (null==cate.getCateUrl()||!cate.getCateUrl().startsWith("http")) {
				cate.setCateUrl("/WeChart/weChart/showArtticleByCategoryPre.do?id="+cate.getCateId());
			}
			list_c.add(cate);
		}
		json.add(1, list_c);
		
		try {
			PrintWriter out=response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
