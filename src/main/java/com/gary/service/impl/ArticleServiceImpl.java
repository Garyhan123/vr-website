package com.gary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gary.entity.Article;
import com.gary.mapper.ArticleMapper;
import com.gary.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public Article getArticles(String pageName, int sort) {
		return articleMapper.getArticles(pageName, sort);
	}

	@Override
	public String updateArticle(Article article) {
		int count = articleMapper.updateArticles(article);
		if (count == 1) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

}
