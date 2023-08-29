package org.example;

import configuration.MapperConfig;
import configuration.NewsConfig;
import configuration.TrendingConfig;
import service.BingNewsService;

public class Main {
    public static void main(String[] args) throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        BingNewsService.readBingNewsConfig(new NewsConfig(newsCfg));
        String mapperCfg = "src/main/resources/mapperconfig.json";
        BingNewsService.readMapperConfig(new MapperConfig(mapperCfg));

        String trendingCfg = "src/main/resources/trendingconfig.json";
        BingNewsService.readTrendingConfig(new TrendingConfig(trendingCfg));

        var articles = BingNewsService.getAllArticles();
        var adTopics = BingNewsService.getAllAdTopic();
        var topNews = BingNewsService.getTopNews();
        var trendingNews = BingNewsService.getTrendingNews();

    }
}
