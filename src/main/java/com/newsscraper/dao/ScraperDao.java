package com.newsscraper.dao;

import java.util.ArrayList;
import java.util.List;

import com.newsscraper.service.bean.Article;

public class ScraperDao {
	private ScraperRepo conObj;

	public ScraperDao(ScraperRepo conObj) {
		this.conObj = conObj;
	}

	public void add(Article article) throws Exception {
		Article article1 = conObj.save(article);
	}

	public List<Article> getAll() throws Exception {
		List<Article> articles = new ArrayList<>();
		conObj.findAll().forEach(articles::add);
		return articles;
	}

	public List<Article> getByAuthor(String author) {
		List<Article> articles = new ArrayList<>();
		conObj.findByAuthor(author).forEach(articles::add);
		return articles;
	}

	public List<Article> getByTitle(String title) {
		List<Article> articles = new ArrayList<>();
		conObj.findByTitle(title).forEach(articles::add);
		return articles;
	}
}
