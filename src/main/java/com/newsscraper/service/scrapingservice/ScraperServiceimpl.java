package com.newsscraper.service.scrapingservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsscraper.common.util.ScraperConstants;
import com.newsscraper.dao.ScraperDao;
import com.newsscraper.dao.ScraperRepo;
import com.newsscraper.service.bean.Article;

@Service
public class ScraperServiceimpl implements ScraperService {

	@Autowired
	private ScraperRepo conObj;

	private ScraperDao daoObj;

	public ScraperServiceimpl() {
	}

	@Override
	public void initApp(LocalDate date) {
		daoObj = new ScraperDao(conObj);
		LocalDate currDate = (LocalDate.now());
		while ((date = addOneDay(date)).isBefore(currDate)) {
			try {
				getDataForLocalRepo(date);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getDataForLocalRepo(LocalDate date) throws IOException {
		String title = "";
		String author = "";
		String description = "";
		String category = "";
		String navDate = date.getYear() + ScraperConstants.SLASH + date.getMonthValue() + ScraperConstants.SLASH
				+ date.getDayOfMonth() + ScraperConstants.SLASH;
		Document doc = Jsoup.connect(ScraperConstants.BASE_URL + navDate).get();
		Element pgElement = doc.getElementById("subnav-tpbar-latest");
		int catSize = pgElement.getElementsByTag("a").size();
		for (int i = 1; i < catSize; i++) {
			Element e = doc.getElementById("section_" + i);
			Elements links = e.select("a[href]");
			for (int j = 1; j < links.size(); j++) {
				Element subLink = links.get(j);
				description = subLink.attr("abs:href");
				Document newsPage = Jsoup.connect(description).get();
				title = newsPage.getElementsByTag("h1").get(0).text();
				author = newsPage.getElementsByClass("auth-nm lnk").text();
				category = newsPage.getElementsByClass("section-name").get(0).text();
				Article article = new Article(title, category, date, author, description);
				this.addData(article);
			}
		}
	}

	public LocalDate addOneDay(LocalDate date) {
		return date.plusDays(1);
	}

	@Override
	public List<Article> getArticleByAuthor(String author) {
		return daoObj.getByAuthor(author);
	}

	@Override
	public List<Article> getArticleByTitle(String title) {
		return daoObj.getByTitle(title);
	}

	@Override
	public boolean addData(Article article) {
		try {
			// System.out.println("is it null: "+ (conObj==null));
			daoObj.add(article);
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Article> getAllData() {
		try {
			return daoObj.getAll();
		} catch (Exception e) {
			return null;
		}
	}

}
