package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.ReplyNews;
import com.web.mapper.ReplyNewsMapper;
import com.web.service.ReplyNewsService;

@Service
public class ReplyNewsServiceImpl extends CommonServiceImpl<ReplyNews> implements ReplyNewsService {

	private ReplyNewsMapper replyNewsMapper;

	@Resource(name="replyNewsMapper")
	public void setReplyNewsMapper(ReplyNewsMapper replyNewsMapper) {
		this.replyNewsMapper = replyNewsMapper;
		super.setCommonMapper(replyNewsMapper);
	}
}
