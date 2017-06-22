package com.web.pojo;

/**
 * 回复文本消息
 * 
 * @author Administrator
 *
 */
public class TextPojo extends CommonPojo {
	
	public TextPojo(){
		super.setMsgType("text");
	}
	 
	private String content;

 
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
