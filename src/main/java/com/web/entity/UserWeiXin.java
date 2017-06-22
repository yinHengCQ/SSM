package com.web.entity;

import java.io.Serializable;
/**
 * 微信用户记录表实体类
 * @author Administrator
 *
 */
public class UserWeiXin implements Serializable {

	private int userWeiXinId;	//微信用户记录ID
	private int userId;	//外键，用户编号
	private UserInfo userInfo;
	private int wxId;			//微信原始ID
	private String wxHead;		//微信头像
	private String qrCode;		//二维码
	private String wxName;		//微信公众号名称
	private String wxCode;		//微信号
	private int wxType;			//微信类型，1.订阅号
	private String token;		//随机生成token   
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUserWeiXinId() {
		return userWeiXinId;
	}
	public void setUserWeiXinId(int userWeiXinId) {
		this.userWeiXinId = userWeiXinId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public int getWxId() {
		return wxId;
	}
	public void setWxId(int wxId) {
		this.wxId = wxId;
	}
	public String getWxHead() {
		return wxHead;
	}
	public void setWxHead(String wxHead) {
		this.wxHead = wxHead;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String getWxName() {
		return wxName;
	}
	public void setWxName(String wxName) {
		this.wxName = wxName;
	}
	public String getWxCode() {
		return wxCode;
	}
	public void setWxCode(String wxCode) {
		this.wxCode = wxCode;
	}
	public int getWxType() {
		return wxType;
	}
	public void setWxType(int wxType) {
		this.wxType = wxType;
	}
	
	
}
