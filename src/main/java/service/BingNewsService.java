package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.*;
import model.AdTopic;
import model.Article;
import org.json.JSONObject;
import org.w3c.dom.Node;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class BingNewsService {
    public static NewsConfig newsConfig;
    public static MapperConfig mapperConfig;
    public static EndpointConfig endpointConfig;

    public static <T> T readConfig(String configPath, Class<T> configClass) throws Exception {
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

//    public static void getSportsInfo() throws Exception {
//        var mappedMatchResults = new ArrayList<MatchResult>();
//        List<JSONObject> jsonMatchResults = ReaderService.getMatchResultFromAPIUrl("abc.com");
//        mappedMatchResults = MapperService.mapJsonMatchResultsToMatchResults(jsonMatchResults);
//        return mappedMatchResults;
//    }

    Node node;

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
            var mappedItems = MapperService.mapJsonNewsToArticles(items, mapper);
            topNews.addAll(mappedItems);
        }

        return topNews;
    }
}

