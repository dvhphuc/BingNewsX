package org.example;

import configuration.article.MapperConfig;
import configuration.topnews.EndpointConfig;
import service.BingNewsService;
import service.ReaderService;

public class Main {
    public static void main(String[] args) throws Exception {

        BingNewsService.newsConfig = ReaderService.getConfig("src/main/resources/bingnewsconfig.json",
                configuration.NewsConfig.class);
        BingNewsService.mapperConfig = ReaderService.getConfig("src/main/resources/rssmapperconfig.json",
                MapperConfig.class);
        BingNewsService.endpointConfig = ReaderService.getConfig("src/main/resources/endpointTopNewsConfig.json",
                EndpointConfig.class);


        var articles = BingNewsService.getAllArticles();
//        var adTopics = BingNewsService.getAllAdTopic();
        var topNews = BingNewsService.getTopNews();
//        var trendingNews = BingNewsService.getTrendingNews();
//        var feed365 = BingNewsService.getFeed365();
//        var weatherInfo = BingNewsService.getWeatherInfo();
//        var financeInfo = BingNewsService.getFinanceInfo();
//        var sportsInfo = BingNewsService.getSportsInfo();

    }

}
