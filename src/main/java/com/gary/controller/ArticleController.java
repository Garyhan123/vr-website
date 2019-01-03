package com.gary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.gary.entity.Article;
import com.gary.service.ArticleService;

@RequestMapping("article")
@RestController
public class ArticleController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;

	@GetMapping("getArticles")
	public Article getArticles(String pageName, Integer sort) {
		LOGGER.info("请求参数:pageName:{},sort:{}", pageName, sort);
		return articleService.getArticles(pageName, sort);
	}

	@PostMapping("updateArticle")
	public String updateArticle( Article article) {
		LOGGER.info("修改文章请求参数：article:{}", JSONArray.toJSONString(article));
		return articleService.updateArticle(article);
	}
}
