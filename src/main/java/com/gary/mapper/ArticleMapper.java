package com.gary.mapper;

import org.apache.ibatis.annotations.Param;

import com.gary.entity.Article;

public interface ArticleMapper {
	Article getArticles(@Param("pageName") String pageName, @Param("sort") int sort);

	int updateArticles(Article article);
}
