package com.web.controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.SlideAdvs;
import com.web.service.SlideAdvsService;
import com.web.util.PageUtil;

import net.sf.json.JSONArray;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class SlideAdvsController {

	@Resource(name="slideAdvsServiceImpl")
	private SlideAdvsService slideAdvsService;
	
	@RequestMapping(value="/showSlideAdvs")
	public String showSlideAdvs(Integer page,String msg,HttpSession session,Model model){
		PageUtil<SlideAdvs> paging=new PageUtil<>();
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		slideAdvsService.searchPaging(builder, paging);

		model.addAttribute("paging", paging);
		if (null!=msg) {
			model.addAttribute("msg", "删除失败，因为关联的回复消息未清空");
		}
		
		return "/showSlideAdvs";
	}
	
	@RequestMapping(value="/addSlideAdvs")
	public String addSlideAdvs(SlideAdvs slideAdvs){		
		slideAdvsService.insert(slideAdvs);
		return "redirect:/manager/showSlideAdvs.action";
	}
	
	@RequestMapping(value="/deleteSlideAdvs")
	public String deleteSlideAdvs(int id){
		//判断是否有关联的外键影响删除，如果有，则跳过抛出异常，直接提示错误信息
		try {
			slideAdvsService.delete(id);
			return "redirect:/manager/showSlideAdvs.action";
		} catch (Exception e) {
			return "redirect:/manager/showSlideAdvs.action?msg='error'";
		}		
	}	
	
	@RequestMapping(value="/updatePreSlideAdvs")
	public String updatePreSlideAdvs(int id,Model model){
		SlideAdvs slideAdvs=slideAdvsService.findById(id);
		model.addAttribute("slideAdvs", slideAdvs);
		return "/updateSlideAdvs";
	}
	
	@RequestMapping(value="/updateSlideAdvs")
	public String updateSlideAdvs(SlideAdvs slideAdvs){
		slideAdvsService.update(slideAdvs);
		return "redirect:/manager/showSlideAdvs.action";
	}	
	
	
	
	
	//下面的方法和上面差不多，但是使用EasyUI，所以需要引入json
	
	
	@RequestMapping(value="/showSlideAdvsUI")
	public void showSlideAdvsUI(HttpSession session,HttpServletResponse response){
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		
		List<SlideAdvs> list=slideAdvsService.search(builder);
		
		JSONArray json=JSONArray.fromObject(list);
		
		try {
			PrintWriter pw=response.getWriter();
			pw.println(json.toString());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value="/addSlideAdvsUI")
	public void addSlideAdvsUI(SlideAdvs slideAdvs,HttpSession session,HttpServletResponse response){
		slideAdvs.setUserWeiXinId(Integer.parseInt(session.getAttribute("userWeiXinId").toString()));		
		Map result=new HashMap<>();
		if (!slideAdvsService.insert(slideAdvs)) {
			result.put("errorMsg", "添加失败");
		}
		JSONArray json=JSONArray.fromObject(result);
		try {
			PrintWriter out=response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteSlideAdvsUI")
	public void deleteSlideAdvsUI(int id,HttpServletResponse response){
		//判断是否有关联的外键影响删除，如果有，则跳过抛出异常，直接提示错误信息
		Map result=new HashMap<>();
		try {
			slideAdvsService.delete(id);
			result.put("success", "删除成功");
		} catch (Exception e) {
		}
		JSONArray json=JSONArray.fromObject(result);
		try {
			PrintWriter out=response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	@RequestMapping(value="/updatePreSlideAdvsUI")
	public void updatePreSlideAdvsUI(int id,HttpServletResponse response){
		SlideAdvs slideAdvs=slideAdvsService.findById(id);
		JSONArray json=JSONArray.fromObject(slideAdvs);
		try {
			PrintWriter out=response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/updateSlideAdvsUI")
	public void updateSlideAdvsUI(SlideAdvs slideAdvs,int id,HttpServletResponse response,HttpSession session){
		slideAdvs.setSlideAdvsId(id);
		slideAdvs.setUserWeiXinId(Integer.valueOf(session.getAttribute("userWeiXinId").toString()));
		Map result=new HashMap<>();
		if (!slideAdvsService.update(slideAdvs)) {
			result.put("errorMsg", "修改失败");
		}
		JSONArray json=JSONArray.fromObject(result);
		try {
			PrintWriter out=response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
