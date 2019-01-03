package com.gary.entity;

public class Article {
	private int id;
	private String pageName;
	private int sort;
	private String title;
	private String enContent;
	private String cnContent;
	private String picUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEnContent() {
		return enContent;
	}

	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}

	public String getCnContent() {
		return cnContent;
	}

	public void setCnContent(String cnContent) {
		this.cnContent = cnContent;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
