package org.example;

import configuration.Configuration;
import configuration.article.MapperConfig;
import configuration.topnews.EndpointConfig;
import service.*;
import service.mapper.ArticleMapperService;

public class Main {
    public static void main(String[] args) throws Exception {

//        BingNewsService.newsConfig = ReaderService.getConfig("src/main/resources/bingnewsconfig.json",
//                configuration.NewsConfig.class);
//        BingNewsService.mapperConfig = ReaderService.getConfig("src/main/resources/rssmapperconfig.json",
//                MapperConfig.class);
//        BingNewsService.endpointConfig = ReaderService.getConfig("src/main/resources/endpointTopNewsConfig.json",
//                EndpointConfig.class);

//
//        var articles = BingNewsService.getAllArticles();
////        var adTopics = BingNewsService.getAllAdTopic();
//        var topNews = BingNewsService.getTopNews();
////        var trendingNews = BingNewsService.getTrendingNews();
//        var feed365 = BingNewsService.getFeed365();
//        var weatherInfo = BingNewsService.getWeatherInfo();
//        var financeInfo = BingNewsService.getFinanceInfo();
//        var sportsInfo = BingNewsService.getSportsInfo();

        var config = new Configuration();

        //Get all configurations
        var newsConfig = config.getNewsConfig();
        var mapperConfig = config.getMapperConfig();
        var endpointConfig = config.getEndpointConfig();
        var weatherConfig = config.getWeatherConfig();

        //Create mapper service
        var articleMapperService = new ArticleMapperService();

        //Create services
        var articleService = new ArticleService(newsConfig, mapperConfig, articleMapperService);
        var topNewsService = new TopNewsService(endpointConfig);
        var weatherService = new WeatherService(weatherConfig);


        var bns = new BingNewsService(config, articleService, topNewsService, weatherService);
        System.out.println(bns.getWeatherInfo().get(0).getLocation());

//        var bns = new BingNewsService(config);
//
//        var articleService = new ArticleService();
//        var articles = articleService.getAll();
//
//        System.out.println(bns.config.getNewsConfig().getCategories().get(0).getCategoryName());

    }

}
