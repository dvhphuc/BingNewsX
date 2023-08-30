package service;

import configuration.*;
import model.AdTopic;
import model.Article;
import java.util.ArrayList;
import java.util.List;

public class BingNewsService {
    static NewsConfig newsConfig;
    static MapperConfig mapperConfig;

    public static void readBingNewsConfig(NewsConfig _newsConfig) {
        newsConfig = _newsConfig;
    }

    public static void readMapperConfig(MapperConfig _mapperConfig) {
        mapperConfig = _mapperConfig;
    }

    public static List<Article> getAllArticles() throws Exception {
        //TODO: Get RssUrl for each category in config
        //TODO: Get RssItems for each RssUrl
        //TODO: Map RssItems to Articles
        var articles = new ArrayList<Article>();
        var categories = newsConfig.getCategories();

        for (var category : categories) {
            for (var RssInfo : category.getRssInfo()) {
                var channelId = RssInfo.getChannelID();
                var rssUrl = RssInfo.getURL();
                var items = ReaderRSSService.getRssItems(rssUrl);
                var mappedItem = MapperService.mapToArticles(items, mapperConfig, channelId);

                articles.addAll(mappedItem);
            }
        }

        return articles;
    }

    public static List<AdTopic> getAllAdTopic() {
        //Db db = new Db();
        //return db.getAllAdTopic();
        return null;
    }

    public static List<Article> getTopNews() {
        return null;
    }

    public static List<Article> getTrendingNews() {
        return null;
    }

    public static void readTrendingConfig(TrendingConfig trendingConfig) {

    }

    public static WeatherInfo getWeatherInfo() {
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

}

