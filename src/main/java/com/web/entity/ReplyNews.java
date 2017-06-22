package com.web.entity;

import java.io.Serializable;
/**
 * 回复消息实体类
 * @author Administrator
 *
 */
public class ReplyNews implements Serializable {

	private Integer replyNewsId;	//回复消息ID
	private String replyNewsTitle;//消息标题
	private String replyDecription;//消息备注
	private String replyImageUrl;//消息图片
	private String replyUrl;	//消息连接地址
	private Integer replyId;		//外键，关联消息回复设定编号
	private Reply reply;
	
	public Integer getReplyNewsId() {
		return replyNewsId;
	}
	public void setReplyNewsId(Integer replyNewsId) {
		this.replyNewsId = replyNewsId;
	}
	public String getReplyNewsTitle() {
		return replyNewsTitle;
	}
	public void setReplyNewsTitle(String replyNewsTitle) {
		this.replyNewsTitle = replyNewsTitle;
	}
	public String getReplyDecription() {
		return replyDecription;
	}
	public void setReplyDecription(String replyDecription) {
		this.replyDecription = replyDecription;
	}
	public String getReplyImageUrl() {
		return replyImageUrl;
	}
	public void setReplyImageUrl(String replyImageUrl) {
		this.replyImageUrl = replyImageUrl;
	}
	public String getReplyUrl() {
		return replyUrl;
	}
	public void setReplyUrl(String replyUrl) {
		this.replyUrl = replyUrl;
	}
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
}
