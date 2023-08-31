package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.*;
import model.AdTopic;
import model.Article;
import model.TopNews;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Node;

import javax.lang.model.element.Element;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BingNewsService {
    static NewsConfig newsConfig;
    static MapperConfig mapperConfig;

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
                var items = ReaderRSSService.getRssItems(rssUrl);
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

    public static List<TopNews> getTopNews() throws Exception {
        // 1. From config, get api url
        // 2. Get data from api
        // 3. Parse data to TopNews
        // 4. Return list of TopNews
        var topNewses = new ArrayList<TopNews>();
        var apiUrls = topNewsAPIConfig.apiUrls;

        for (var apiUrl : apiUrls) {
                topNewses.addAll(getTopNews(apiUrl));
        }

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        var topNewses = new ArrayList<TopNews>();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray articles = jsonResponse.getJSONArray("results");
            var topNews = new TopNews();
            for (int i = 0; i < articles.length(); i++) {
                JSONObject news = articles.getJSONObject(i);
                //Base on config, map json object news to TopNews
                topNewses.add(topNews);
            }
        }

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

    public static void readTopNewsAPIConfig(String cfgPath) {

    }
}

