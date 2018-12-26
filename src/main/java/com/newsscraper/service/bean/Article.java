package com.newsscraper.service.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {
	@Id
	private String id;
	private String title;
	private String category;
	private LocalDate date;
	private String author;
	private String description;

	public Article(String title, String category, LocalDate date, String author, String description) {
		super();
		this.title = title;
		this.category = category;
		this.date = date;
		this.author = author;
		this.description = description;
		this.id = date.toString() + this.title;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", category=" + category + ", date=" + date + ", author=" + author
				+ ", description=" + description + "]";
	}

}
