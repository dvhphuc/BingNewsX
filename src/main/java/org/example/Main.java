package org.example;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import service.BingNewsService;
import service.ReaderService;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {

        BingNewsService.newsConfig = ReaderService.readConfig("src/main/resources/bingnewsconfig.json",
                configuration.NewsConfig.class);
        BingNewsService.mapperConfig = ReaderService.readConfig("src/main/resources/rssmapperconfig.json",
                configuration.MapperConfig.class);
        BingNewsService.endpointConfig = ReaderService.readConfig("src/main/resources/endpointTopNewsConfig.json",
                configuration.EndpointConfig.class);


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
