package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.*;
import model.AdTopic;
import model.Article;
import model.TopNews;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BingNewsService {
    static NewsConfig newsConfig;
    static MapperConfig mapperConfig;
    static TopNewsConfig topNewsAPIConfig;

    public static void readBingNewsConfig(String newsCfgPath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        newsConfig = objectMapper.readValue(new File(newsCfgPath), NewsConfig.class);
        return;

    }

    public static void readMapperConfig(String mapperCfgPath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mapperConfig = objectMapper.readValue(new File(mapperCfgPath), MapperConfig.class);
        return;
    }


    public static List<Article> getAllArticles() throws Exception {
        var articles = new ArrayList<Article>();
        var categories = newsConfig.getCategories();

        for (var category : categories) {
            for (var RssInfo : category.getRSSInfos()) {
                var channelId = RssInfo.getChannelID();
                var rssUrl = RssInfo.getURL();
                var items = ReaderService.getRssItems(rssUrl);
                var mappedItems = MapperService.mapItemsToArticles(items, mapperConfig, channelId);

                articles.addAll(mappedItems);
            }
        }

        return articles;
    }

    public static List<AdTopic> getAllAdTopic() {
//        Db db = new Db();
//        return db.getAllAdTopic();
        //ORM
        return null;
    }

    public static List<TopNews> getAllTopNews() {
        var mapper = topNewsAPIConfig.getMapper();
        var topNewsesFromAPI = ReaderService.getTopNewsesFromAPIConfig(topNewsAPIConfig);
        var mappedTopNews = MapperService.mapTopNews(topNewsFromAPI, mapper);
        return topNewses;
    }

    public static List<Article> getTrendingNews() {
        return null;
    }

    public static void readTrendingConfig(TrendingConfig trendingConfig) {

    }

    public static WeatherInfo getWeatherInfo() { //
        return null;
    }


    public static FinanceInfo getFinanceInfo() {
        return null;
    }

    public static SportInfo getSportsInfo() {
        return null;
    }

    public static Feed getFeed365() {
        return null;
    }

    public static void readTopNewsAPIConfig(String cfgPath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        topNewsAPIConfig = objectMapper.readValue(new File(cfgPath), TopNewsConfig.class);
        return;
    }
}

