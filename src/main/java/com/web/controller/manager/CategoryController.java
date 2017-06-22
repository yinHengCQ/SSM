package com.web.controller.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.Category;
import com.web.service.CategoryService;
import com.web.util.PageUtil;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class CategoryController {

	@Resource(name="categoryServiceImpl")
	private CategoryService categoryService;
	
	@RequestMapping(value="/showCategory")
	public String showCategory(Integer page,String msg,HttpSession session,Model model){
		PageUtil<Category> paging=new PageUtil<>();
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		categoryService.searchPaging(builder, paging);
		
		model.addAttribute("paging", paging);
		if (null!=msg) {
			model.addAttribute("msg", "删除失败，因为关联的回复消息未清空");
		}
		
		return "/showCategory";
	}
	
	@RequestMapping(value="/addCategory")
	public String addCategory(Category category){		
		categoryService.insert(category);
		return "redirect:/manager/showCategory.action";
	}
	
	@RequestMapping(value="/deleteCategory")
	public String deleteCategory(int id){
		//判断是否有关联的外键影响删除，如果有，则跳过抛出异常，直接提示错误信息
		try {
			categoryService.delete(id);
			return "redirect:/manager/showCategory.action";
		} catch (Exception e) {
			return "redirect:/manager/showCategory.action?msg='error'";
		}	
	}
	
	@RequestMapping(value="/updatePreCategory")
	public String updatePreCategory(int id,Model model){
		Category category=categoryService.findById(id);
		model.addAttribute("category", category);
		return "/updateCategory";
	}
	
	@RequestMapping(value="/updateCategory")
	public String updateCategory(Category category){
		categoryService.update(category);	
		return "redirect:/manager/showCategory.action";
	}

}
