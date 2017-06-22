package com.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.Article;
import com.web.mapper.ArticleMapper;
import com.web.service.ArticleService;

@Service
public class ArticleServiceImpl extends CommonServiceImpl<Article> implements ArticleService {

	private ArticleMapper articleMapper;

	@Resource(name="articleMapper")
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
		super.setCommonMapper(articleMapper);
	}

	@Override
	public List<Article> findByCategoryId(int id) {
		return articleMapper.findByCategoryId(id);
	}
}
