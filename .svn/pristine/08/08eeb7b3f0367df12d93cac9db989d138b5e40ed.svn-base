package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.Category;
import com.web.mapper.CategoryMapper;
import com.web.service.CategoryService;

@Service
public class CategoryServiceImpl extends CommonServiceImpl<Category> implements CategoryService {

	private CategoryMapper categoryMapper;

	@Resource(name="categoryMapper")
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
		super.setCommonMapper(categoryMapper);
	}
}
