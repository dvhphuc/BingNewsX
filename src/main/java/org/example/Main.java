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

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-beta.p.rapidapi.com/fixtures?date=2020-02-06"))
                .header("X-RapidAPI-Key", "65e4f82b53msh001c94c3de4e044p16cf4fjsna8cbb2957755")
                .header("X-RapidAPI-Host", "api-football-beta.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        var jsonObject = new JSONObject(response.body());
        var fixtures = jsonObject.getJSONArray("response");

        for (var i = 0; i<fixtures.length(); ++i) {
            var match = fixtures.getJSONObject(i);
            var result = match.getJSONObject("teams").getJSONObject("home").getString("name");
            System.out.println(result);
        }
    }

}
