package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.*;
import model.AdTopic;
import model.Article;
import service.mapper.IMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//nhieu service con
public class BingNewsService {
    private static IMapper mapperService;
    public BingNewsService(IMapper _mapperService) {
        this.mapperService = _mapperService;
    }
    static NewsConfig newsConfig;
    static MapperConfig mapperConfig;
    static EndpointConfig endpointConfig;
    static SportAPIsConfig sportConfig;

    public static <T> T readConfig(String configPath, Class<T> configClass) throws Exception { //Refactor
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(configPath), configClass);
    }

    public static NewsConfig getNewsConfig() {
        return newsConfig;
    }

    public static List<Article> getAllArticles() throws Exception {
        var articles = new ArrayList<Article>();
        var categories = newsConfig.getCategories();

        for (var category : categories) {
            for (var RssInfo : category.getRSSInfos()) {
                var channelId = RssInfo.getChannelID();
                var rssUrl = RssInfo.getURL();
                var items = ReaderService.getRssItems(rssUrl);
                var mapper = mapperConfig.getChannelById(channelId).getMapperConfig();
                var mappedItems = mapperService.mapItemsToArticles(items, mapper);
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

    public static SportInfo getSportsInfo() throws Exception {
        return null;
    }

    public static Feed getFeed365() {
        return null;
    }

    public static List<Article> getTopNews() throws Exception {
        var topNews = new ArrayList<Article>();
        var endpoints = endpointConfig.getEndpoints();
        for (var endpoint : endpoints){
            var uri = endpoint.getURI();
            var mapper = endpoint.getMapper();
            var items = ReaderService.getNewsJsonFromAPI(uri, endpoint.getResponseKey());
            var mappedItems = mapperService.mapItemsToArticles(items, mapper);
            topNews.addAll(mappedItems);
        }

        return topNews;
    }
}

