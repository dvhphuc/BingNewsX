package org.example;

import configuration.MapperConfig;
import configuration.NewsConfig;
import configuration.TrendingConfig;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import service.BingNewsService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        BingNewsService.readBingNewsConfig(newsCfg);
        String mapperCfg = "src/main/resources/mapperconfig.json";
        BingNewsService.readMapperConfig(mapperCfg);
        String trendingCfg = "src/main/resources/trendingconfig.json";
        BingNewsService.readTrendingConfig(new TrendingConfig(trendingCfg));

        var articles = BingNewsService.getAllArticles();
        var adTopics = BingNewsService.getAllAdTopic();
        var topNews = BingNewsService.getTopNews();
        var trendingNews = BingNewsService.getTrendingNews();
        var feed365 = BingNewsService.getFeed365();
        var weatherInfo = BingNewsService.getWeatherInfo();
        var financeInfo = BingNewsService.getFinanceInfo();
        var sportsInfo = BingNewsService.getSportsInfo();

    }

}
