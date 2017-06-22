package com.web.controller.manager;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.Article;
import com.web.entity.Category;
import com.web.service.ArticleService;
import com.web.service.CategoryService;
import com.web.util.PageUtil;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class ArticleController {

	@Resource(name="articleServiceImpl")
	private ArticleService articleService;
	@Resource(name="categoryServiceImpl")
	private CategoryService categoryService;
	
	@RequestMapping(value="/showArticle")
	public String showArticle(Integer page,String msg,HttpSession session,Model model){
		PageUtil<Article> paging=new PageUtil<>();
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		articleService.searchPaging(builder, paging);
		
		model.addAttribute("paging", paging);
		if (null!=msg) {
			model.addAttribute("msg", "删除失败，因为关联的回复消息未清空");
		}		
		
		return "/showArticle";
	}
	
	@RequestMapping(value="/addPreArticle")
	public String addPreArticle(HttpSession session,Model model){
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));

		List<Category> list=categoryService.search(builder);

		model.addAttribute("list", list);
		
		return "/addArticle";
	}
	
	@RequestMapping(value="/addArticle")
	public String addArticle(Article article){
		articleService.insert(article);
		return "redirect:/manager/showArticle.action";
	}
	
	@RequestMapping(value="/deleteArticle")
	public String deleteArticle(int id){
		//判断是否有关联的外键影响删除，如果有，则跳过抛出异常，直接提示错误信息
		try {
			articleService.delete(id);
			return "redirect:/manager/showArticle.action";
		} catch (Exception e) {
			return "redirect:/manager/showArticle.action?msg='error'";
		}	
	}
	
	@RequestMapping(value="/updatePreArticle")
	public String updatePreArticle(int id,Model model){
		Article article=articleService.findById(id);
		model.addAttribute("article", article);
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", article.getUserWeiXinId());

		List<Category> list=categoryService.search(builder);
		
		model.addAttribute("list", list);
		
		return "/updateArticle";
	}
	
	@RequestMapping(value="/updateArticle")
	public String updateArticle(Article article){
		articleService.update(article);
		return "redirect:/manager/showArticle.action";
	}	
}
