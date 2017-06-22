package com.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.UserInfo;
import com.web.service.UserInfoService;
import com.web.util.MD5Util;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
// 加载spring核心文件(规定规定规定)(规定规定规定)(规定规定规定)
@RunWith(value = SpringJUnit4ClassRunner.class)
// 使用Spring的测试工具类(规定规定规定)(规定规定规定)(规定规定规定)(规定规定规定)
public class UserInfoServiceTest {

	@Resource(name = "userInfoServiceImpl")
	private UserInfoService userInfoService;

	@Test
	public void testMd5() {
		System.out.println(MD5Util.MD5("111"));
	}

	// 白盒测试法
	@Test
	public void testInsert() {

		for (int i = 11; i <= 20; i++) {
			UserInfo user = new UserInfo();
			user.setState(1);
			user.setLoginName("my" + i);
			user.setLoginPwd(MD5Util.MD5("22"));
			user.setRegTime(new Date());
			// 一个月有效期 30天 = 30L*24*60*60*1000
			user.setEndTime(new Date(new Date().getTime()
					+ (30L * 24 * 60 * 60 * 1000)));

			this.userInfoService.insert(user);
		}
	}

	@Test
	public void testSearch() {
		// 定义标准查询建造器
		CriteriaBuilder builder = new CriteriaBuilder();

		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andEqualTo("loginName", "test1");
		// 执行查询
		List<UserInfo> arr = this.userInfoService.search(builder);

		System.out.println(arr.size());

	}

	// 根据名称和状态
	@Test
	public void testSearchNameAndState() {
		// 定义标准查询建造器
		CriteriaBuilder builder = new CriteriaBuilder();

		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andLike("loginName", "te%");
		criteria1.andEqualTo("state", 1);

		// 执行查询
		List<UserInfo> arr = this.userInfoService.search(builder);

		System.out.println(arr.size());
	}

	@Test
	public void testSearchBeginTime() {
		// 定义标准查询建造器
		CriteriaBuilder builder = new CriteriaBuilder();

		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andBetween("regTime", "2017-4-18", "2017-4-19");

		// 执行查询
		List<UserInfo> arr = this.userInfoService.search(builder);

		System.out.println(arr.size());
	}

	//登录
	@Test
	public void testSearchLogin() {

		// 定义标准查询建造器
		CriteriaBuilder builder = new CriteriaBuilder();
		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andEqualTo("loginName", "test1");
		criteria1.andEqualTo("loginPwd", MD5Util.MD5("111"));

		// 执行查询
		List<UserInfo> arr = this.userInfoService.search(builder);
		if(arr.size()>0){
			System.out.println("登录 成功");
			
			UserInfo user=arr.get(0);
			System.out.println(user.getUserId());
			
		}else{
			System.out.println("登录失败");
		}

	}

}
