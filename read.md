#Readme
#####Initial hit will take time to load, as it loads all the news.
####to change starting date: go to "ScraperConstants" inside "com.newsscraper.common.util" package, and change "public static final String START_DATE" variable

1. download as normal java project.
2. Import to IDE, or simply generate jar and run as jar.
3. Its a spring boot application, so no need to add any dependencies.
4. base URL: http://localhost:8080/
5. to get all news:  http://localhost:8080/ns
5. to get all news by author :  http://localhost:8080/ns/author/{authorname}
6. to get news by title:   http://localhost:8080/ns/title/{title}

7. code is fully extendible.
8. initial scraping logic can be put at startup, and a timer thread can be dedicated, which awakes in every 24hr to fetch the scraping details.
