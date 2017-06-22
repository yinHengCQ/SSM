package com.web.mapper;

import com.web.entity.UserInfo;

public interface UserInfoMapper extends CommonMapper<UserInfo>{

	/**
	 * 更改密码
	 * @param userId
	 * @param loginPwd
	 * @return
	 */
	public int loginPwd(int userId,String loginPwd);
}
