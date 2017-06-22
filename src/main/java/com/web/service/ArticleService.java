package com.web.service;

import java.util.List;

import com.web.entity.Article;

public interface ArticleService extends CommonService<Article> {

	public List<Article> findByCategoryId(int id);

}
