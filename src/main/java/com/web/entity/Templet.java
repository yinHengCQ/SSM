package com.web.entity;

import java.io.Serializable;

public class Templet implements Serializable {

	private Integer templetId;//主键
	private String templetName;//模板名称
	private String listSlideAdvs;//选定的幻灯片主键集合Json格式
	private String listCategory;//选定的分类主键集合Json格式
	private Integer userWeiXinId;//外键，关联微信用户记录表
	private UserWeiXin userWeiXin;
	
	public Integer getTempletId() {
		return templetId;
	}
	public void setTempletId(Integer templetId) {
		this.templetId = templetId;
	}
	public String getTempletName() {
		return templetName;
	}
	public void setTempletName(String templetName) {
		this.templetName = templetName;
	}
	public String getListSlideAdvs() {
		return listSlideAdvs;
	}
	public void setListSlideAdvs(String listSlideAdvs) {
		this.listSlideAdvs = listSlideAdvs;
	}
	public String getListCategory() {
		return listCategory;
	}
	public void setListCategory(String listCategory) {
		this.listCategory = listCategory;
	}
	public Integer getUserWeiXinId() {
		return userWeiXinId;
	}
	public void setUserWeiXinId(Integer userWeiXinId) {
		this.userWeiXinId = userWeiXinId;
	}
	public UserWeiXin getUserWeiXin() {
		return userWeiXin;
	}
	public void setUserWeiXin(UserWeiXin userWeiXin) {
		this.userWeiXin = userWeiXin;
	}

}
