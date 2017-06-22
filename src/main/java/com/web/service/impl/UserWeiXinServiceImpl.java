package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.UserWeiXin;
import com.web.mapper.UserWeiXinMapper;
import com.web.service.UserWeiXinService;

@Service
public class UserWeiXinServiceImpl extends CommonServiceImpl<UserWeiXin> implements UserWeiXinService {

	private UserWeiXinMapper userWeiXinMapper;

	@Resource(name="userWeiXinMapper")
	public void setUserWeiXinMapper(UserWeiXinMapper userWeiXinMapper) {
		this.userWeiXinMapper = userWeiXinMapper;
		super.setCommonMapper(userWeiXinMapper);
	}

}
