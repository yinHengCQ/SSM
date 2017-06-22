package com.web.controller.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.Reply;
import com.web.service.ReplyService;
import com.web.util.PageUtil;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class ReplyController {
	
	@Resource(name="replyServiceImpl")
	private ReplyService replyService;

	@RequestMapping(value="/showReply")
	public String showReply(Integer page,String msg,HttpSession session,Model model){
		PageUtil<Reply> paging=new PageUtil<>();
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("userWeiXinId", session.getAttribute("userWeiXinId"));
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());
		
		replyService.searchPaging(builder, paging);
		
		model.addAttribute("paging", paging);
		
		if (null!=msg) {
			model.addAttribute("msg", "删除失败，因为关联的回复消息未清空");
		}

		return "/showReply";
	}
	
	@RequestMapping(value="/addReply")
	public String addReply(Reply reply){
		replyService.insert(reply);
		return "redirect:/manager/showReply.action";
	}
	
	@RequestMapping(value="/deleteReply")
	public String deleteReply(int id){
		//判断是否有关联的外键影响删除，如果有，则跳过抛出异常，直接提示错误信息
		try {
			replyService.delete(id);
			return "redirect:/manager/showReply.action";
		} catch (Exception e) {
			return "redirect:/manager/showReply.action?msg='error'";
		}
	}
}
