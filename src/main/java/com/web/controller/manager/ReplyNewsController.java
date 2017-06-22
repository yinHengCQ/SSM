package com.web.controller.manager;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.ReplyNews;
import com.web.service.ReplyNewsService;
import com.web.util.PageUtil;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class ReplyNewsController {
	
	@Resource(name="replyNewsServiceImpl")
	private ReplyNewsService replyNewsService;
	
	@RequestMapping(value="/showReplyNews")
	public String showReplyNews(Integer page,Integer id,Model model){
		PageUtil<ReplyNews> paging=new PageUtil<>();
		if (page!=null) {
			paging.setPage(page);
		}
		
		CriteriaBuilder builder=new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1=builder.createCriteria();
		criteria1.andEqualTo("replyId", id);
		builder.setOffset(paging.getBegin());
		builder.setLimit(paging.getEnd());	
		
		replyNewsService.searchPaging(builder, paging);
		
		model.addAttribute("replyId", id);
		model.addAttribute("paging",paging);
		
		return "/showReplyNews";
	}
	
	@RequestMapping(value="/addReplyNews")
	public String addReplyNews(ReplyNews replyNews){		
		replyNewsService.insert(replyNews);
		return "redirect:/manager/showReplyNews.action?id="+replyNews.getReplyId();
	}
	
	@RequestMapping(value="/deleteReplyNews")
	public String deleteReplyNews(int id){	
		int replyId=replyNewsService.findById(id).getReplyId();
		replyNewsService.delete(id);
		return "redirect:/manager/showReplyNews.action?id="+replyId;	
	}
	
	@RequestMapping(value="/updatePreReplyNews")
	public String updatePreReplyNews(int id,Model model){	
		ReplyNews replyNews = replyNewsService.findById(id);
		model.addAttribute("replyNews", replyNews);
		return "/updateReplyNews";	
	}
	
	@RequestMapping(value="/updateReplyNews")
	public String updateReplyNews(ReplyNews replyNews){
		replyNewsService.update(replyNews);
		return "redirect:/manager/showReplyNews.action?id="+replyNews.getReplyId();
	}
}
