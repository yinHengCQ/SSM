package com.web.controller.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.UserInfo;
import com.web.entity.UserWeiXin;
import com.web.service.UserWeiXinService;
import com.web.util.PageUtil;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class UserWeiXinController {
	
	@Resource(name="userWeiXinServiceImpl")
	private UserWeiXinService userWeiXinService;

	@RequestMapping(value="/showUserWeiXin")
	public String showUserWeiXin(Integer page,HttpSession session,Model model){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		int userInfoId=userInfo.getUserId();
		PageUtil<UserWeiXin> paging=new PageUtil<>();
		
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userId", userInfoId);
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		userWeiXinService.searchPaging(builder, paging);		

		model.addAttribute("paging", paging);

		return "/showUserWeiXin";
	}
	
	@RequestMapping(value="/addUserWeiXin")
	public String addUserWeiXin(UserWeiXin userWeiXin){
		
		userWeiXinService.insert(userWeiXin);
		
		return "redirect:/manager/showUserWeiXin.action";
	}
	
	@RequestMapping(value="/deleteUserWeiXin")
	public String deleteUserWeiXin(int id,Model model){		

			userWeiXinService.delete(id);	
			
			return "redirect:/manager/showUserWeiXin.action";		
	}
	
	@RequestMapping(value="/updatePreUserWeiXin")
	public String updatePreUserWeiXin(int id,Model model){
		UserWeiXin userWeiXin = userWeiXinService.findById(id);
		
		model.addAttribute("userWeiXin", userWeiXin);
		
		return "/updateUserWeiXin";
	}
	
	@RequestMapping(value="/updateUserWeiXin")
	public String updateUserWeiXin(UserWeiXin userWeiXin){	
		
		userWeiXinService.update(userWeiXin);
		
		return "redirect:/manager/showUserWeiXin.action";
	}	
	
	@RequestMapping(value="/functionManager")
	public String functionManager(int id,HttpSession session){
		session.setAttribute("userWeiXinId", id);
		return "redirect:/manager/showUserWeiXin.action";
	}
	
	@RequestMapping(value="/backToShowUserWeiXin")
	public String backToShowUserWeiXin(HttpSession session){
		if (null!=session.getAttribute("userWeiXinId")) {
			session.setAttribute("userWeiXinId", null);
		}
		return "redirect:/manager/showUserWeiXin.action";
	}
	
	@RequestMapping(value="/help")
	public String help(int id,HttpSession session){
		UserWeiXin userWeiXin=userWeiXinService.findById(id);
		session.setAttribute("userWeiXin", userWeiXin);
		return "/help";
	}
}
