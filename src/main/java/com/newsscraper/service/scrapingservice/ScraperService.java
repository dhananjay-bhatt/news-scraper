package com.newsscraper.service.scrapingservice;

import java.time.LocalDate;
import java.util.List;

import com.newsscraper.service.bean.Article;

public interface ScraperService {

	public boolean addData(Article article);

	public List<Article> getAllData();

	public List<Article> getArticleByAuthor(String author);

	public List<Article> getArticleByTitle(String title);
	
	public void initApp(LocalDate date);
}
