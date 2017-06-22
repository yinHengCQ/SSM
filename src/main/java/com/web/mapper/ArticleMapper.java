package com.web.mapper;

import java.util.List;

import com.web.entity.Article;

public interface ArticleMapper extends CommonMapper<Article> {

	public List<Article> findByCategoryId(int id);
}
