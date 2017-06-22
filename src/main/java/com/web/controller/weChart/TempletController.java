package com.web.controller.weChart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.Templet;
import com.web.pojo.TempletPojo;
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
public class TempletController {

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
	
	
	@RequestMapping(value="/showTemplet")
	public String showTemplet(Integer page,String msg,HttpSession session,Model model){
		PageUtil<Templet> paging=new PageUtil<>();
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		templetService.searchPaging(builder, paging);
		
		model.addAttribute("paging", paging);
		
		if (null!=msg) {
			model.addAttribute("msg", "删除失败，因为关联的回复消息未清空");
		}
		
		return "/showTemplet";
	}
	
	@RequestMapping(value="/addPreTemplet")
	public String moblieManager(HttpSession session,Model model){
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		
		model.addAttribute("list_article", articleService.search(builder));
		model.addAttribute("list_category", categoryService.search(builder));
		model.addAttribute("list_reply", replyService.search(builder));
		model.addAttribute("list_slideAdvs", slideAdvsService.search(builder));
		return "/addTemplet";
	}
	
	@RequestMapping(value="/addPreTempletByJson")
	public void addPreTempletByJson(HttpSession session,HttpServletResponse response){
		JSONArray json=new JSONArray();
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		
		json.add(0, articleService.search(builder));
		json.add(1, categoryService.search(builder));
		json.add(2, replyService.search(builder));
		json.add(3, slideAdvsService.search(builder));

		try {
			PrintWriter out=response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	@RequestMapping(value="/addTemplet")
	public String addTemplet(TempletPojo pojo){
		Templet templet=new Templet();
		JSONArray json=new JSONArray();
		json.add(0, pojo.getCategory1());
		json.add(1, pojo.getCategory2());
		json.add(2, pojo.getCategory3());
		json.add(3, pojo.getCategory4());
		json.add(4, pojo.getCategory5());
		json.add(5, pojo.getCategory6());
		templet.setListCategory(json.toString());
		templet.setListSlideAdvs(pojo.getList_slideAdvs());
		templet.setUserWeiXinId(pojo.getUserWeiXinId());
		templet.setTempletName(pojo.getTempletName());
		
		templetService.insert(templet);
		return "redirect:/weChart/showTemplet.do";
	}
	
	@RequestMapping(value="/deleteTemplet")
	public String deleteTemplet(int id){	
		//判断是否有关联的外键影响删除，如果有，则跳过抛出异常，直接提示错误信息
		try {
			templetService.delete(id);
			return "redirect:/weChart/showTemplet.do";
		} catch (Exception e) {
			return "redirect:/weChart/showTemplet.do?msg='error'";
		}
	}	
}
