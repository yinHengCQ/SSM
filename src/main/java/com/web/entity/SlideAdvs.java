package com.web.entity;

import java.io.Serializable;

public class SlideAdvs implements Serializable {

	private int slideAdvsId;	//幻灯片广告主键
	private String advsName;	//幻灯片描述
	private String advsImage;	//图片地址
	private String advsUrl;		//链接地址
	private int userWeiXinId;//外键，关联微信用户记录表
	private UserWeiXin userWeiXin;
	public int getSlideAdvsId() {
		return slideAdvsId;
	}
	public void setSlideAdvsId(int slideAdvsId) {
		this.slideAdvsId = slideAdvsId;
	}
	public String getAdvsName() {
		return advsName;
	}
	public void setAdvsName(String advsName) {
		this.advsName = advsName;
	}
	public String getAdvsImage() {
		return advsImage;
	}
	public void setAdvsImage(String advsImage) {
		this.advsImage = advsImage;
	}
	public String getAdvsUrl() {
		return advsUrl;
	}
	public void setAdvsUrl(String advsUrl) {
		this.advsUrl = advsUrl;
	}
	public int getUserWeiXinId() {
		return userWeiXinId;
	}
	public void setUserWeiXinId(int userWeiXinId) {
		this.userWeiXinId = userWeiXinId;
	}
	public UserWeiXin getUserWeiXin() {
		return userWeiXin;
	}
	public void setUserWeiXin(UserWeiXin userWeiXin) {
		this.userWeiXin = userWeiXin;
	}
	
}
