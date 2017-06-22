package com.web;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.criterion.CriteriaBuilder;
import com.web.entity.Category;
import com.web.entity.SlideAdvs;
import com.web.service.CategoryService;
import com.web.service.SlideAdvsService;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
// 加载spring核心文件(规定规定规定)(规定规定规定)(规定规定规定)
@RunWith(value = SpringJUnit4ClassRunner.class)
// 使用Spring的测试工具类(规定规定规定)(规定规定规定)(规定规定规定)(规定规定规定)
public class CategoryServiceTest {

	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;

	// 白盒测试法
	@Test
	public void testInsert() {

		for (int i = 7; i <= 16; i++) {
			Category cate=new Category();
			cate.setCateImage("cateImage");
			cate.setCateName("cateName");
			cate.setCateSort(i);
			cate.setUserWeiXinId(i);
			categoryService.insert(cate);
		}
	}

	@Test
	public void testSearch() {
		// 定义标准查询建造器
		CriteriaBuilder builder = new CriteriaBuilder();

		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andEqualTo("cateImage", "cateImage");
		// 执行查询
		List<Category> arr = this.categoryService.search(builder);

		System.out.println(arr.get(0));

	}

/*	// 根据名称和状态
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
	}*/

/*	@Test
	public void testSearchBeginTime() {
		// 定义标准查询建造器
		CriteriaBuilder builder = new CriteriaBuilder();

		CriteriaBuilder.Criteria criteria1 = builder.createCriteria();
		criteria1.andBetween("regTime", "2017-4-18", "2017-4-19");

		// 执行查询
		List<UserInfo> arr = this.userInfoService.search(builder);

		System.out.println(arr.size());
	}*/

/*	//登录
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

	}*/

}
