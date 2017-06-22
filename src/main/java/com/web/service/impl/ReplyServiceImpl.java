package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.Reply;
import com.web.mapper.ReplyMapper;
import com.web.service.ReplyService;

@Service
public class ReplyServiceImpl extends CommonServiceImpl<Reply> implements ReplyService {

	private ReplyMapper replyMapper;

	@Resource(name="replyMapper")
	public void setReplyMapper(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
		super.setCommonMapper(replyMapper);
	}
}
