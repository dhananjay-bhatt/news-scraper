package com.newsscraper.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsscraper.service.bean.Article;
import com.newsscraper.service.scrapingservice.ScraperService;
import com.newsscraper.service.scrapingservice.ScraperServiceimpl;

@RestController
public class ScraplerController {

	@Autowired
	private ScraperService service;

	@RequestMapping("/")
	public String hh() {
		service.initApp(LocalDate.parse("2018-12-24"));
		return "app started";
	}
	
	@RequestMapping("/ns")
	public List<Article> getArticles() {
		return service.getAllData();
	}

	@RequestMapping("/ns/author/{author}")
	public List<Article> getArticlesByAuthor(@PathVariable String author) {
		return service.getArticleByAuthor(author);
	}

	@RequestMapping("/ns/title/{title}")
	public List<Article> getArticlesByTitle(@PathVariable String title) {
		return service.getArticleByTitle(title);
	}

}
