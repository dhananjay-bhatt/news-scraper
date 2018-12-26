package com.newsscraper.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.newsscraper.service.bean.Article;

public interface ScraperRepo extends CrudRepository<Article, String> {
	
	public List<Article> findByAuthor(String author); 
	public List<Article> findByTitle(String author); 
	

}
