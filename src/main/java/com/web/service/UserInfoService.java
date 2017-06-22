package com.web.service;

import com.web.entity.UserInfo;

public interface UserInfoService extends CommonService<UserInfo> {

	//更新密码
	public boolean loginPwd( int userId,String loginPwd);
	
	/**
	 * 登录操作
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public UserInfo  login(String loginName,String loginPwd);
}
