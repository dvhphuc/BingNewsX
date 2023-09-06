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


//        var articles = BingNewsService.getAllArticles();
//        var adTopics = BingNewsService.getAllAdTopic();
//        var topNews = BingNewsService.getTopNews();
//        var trendingNews = BingNewsService.getTrendingNews();
//        var feed365 = BingNewsService.getFeed365();
//        var weatherInfo = BingNewsService.getWeatherInfo();
//        var financeInfo = BingNewsService.getFinanceInfo();
//        var sportsInfo = BingNewsService.getSportsInfo();

        var a = ReaderService.getMatchResultFromAPI();

        for (int i=1; i<a.length(); i++) {
            //System.out.println(a.getJSONObject(i));
            var s = a.getJSONObject(i).getJSONObject("teams").getJSONObject("home").getString("name");
            System.out.println(s);
        }
    }

}
