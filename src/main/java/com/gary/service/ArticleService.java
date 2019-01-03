package com.gary.service;

import com.gary.entity.Article;

public interface ArticleService {
	Article getArticles(String pageName, int sort);

	String updateArticle(Article article);
}
