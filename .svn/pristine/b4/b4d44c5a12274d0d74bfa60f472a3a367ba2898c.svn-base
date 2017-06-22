package com.web.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.UserInfo;
import com.web.mapper.UserInfoMapper;
import com.web.service.UserInfoService;
import com.web.util.MD5Util;

@Service
public class UserInfoServiceImpl extends CommonServiceImpl<UserInfo> implements
		UserInfoService {

	private UserInfoMapper userInfoMapper;

	@Resource(name = "userInfoMapper")
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
		super.setCommonMapper(userInfoMapper);
	}

	@Override
	public boolean loginPwd(int userId, String loginPwd) {

		return this.userInfoMapper.loginPwd(userId, loginPwd) > 0;
	}

	@Override
	public UserInfo login(String loginName, String loginPwd) {
		CriteriaBuilder builder = new CriteriaBuilder();

		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andEqualTo("loginName", loginName);
		criteria1.andEqualTo("loginPwd", MD5Util.MD5(loginPwd));

		// 查询
		List<UserInfo> arr = this.userInfoMapper.search(builder);
		if (arr.size() > 0) {
			return arr.get(0);
		}
		return null;
	}

}
