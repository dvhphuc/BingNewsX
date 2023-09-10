package service;

import configuration.*;
import configuration.article.MapperConfig;
import configuration.sport.SportConfig;
import configuration.topnews.EndpointConfig;
import configuration.weather.WeatherConfig;
import model.AdTopic;
import model.Article;
import model.MatchResult;
import model.Weather;
import org.w3c.dom.Node;
import service.factory.ServiceFactory;
import service.mapper.ArticleMapperService;
import service.mapper.SportMapperService;
import service.mapper.WeatherMapperService;

import java.util.ArrayList;
import java.util.List;

public class BingNewsService {

    public Configuration config;

    public ArticleService articleService;
    public TopNewsService topNewsService;

    public WeatherService weatherService;

    public BingNewsService(Configuration _cfg, ArticleService _atcService, TopNewsService _topNewsService,
                           WeatherService _weatherService) throws Exception {
        config = _cfg;
        articleService = _atcService;
        topNewsService = _topNewsService;
        weatherService = _weatherService;
    }

    public List<Article> getArticles() throws Exception {
        var newsConfig = config.getNewsConfig();
        return articleService.getAll();
    }

    public List<Article> getTopNews() throws Exception {
        var endpointConfig = config.getEndpointConfig();
        return topNewsService.getAll();
    }

    public List<Weather> getWeatherInfo() throws Exception {
        var weatherConfig = config.getWeatherConfig();
        return weatherService.getAll();
    }

//    public static List<Article> getAllArticles() throws Exception {
//        var articleMapper = new ArticleMapperService();
//        var articles = new ArrayList<Article>();
//        var categories = newsConfig.getCategories();
//
//        for (var category : categories) {
//            for (var RssInfo : category.getRSSInfos()) {
//                var channelId = RssInfo.getChannelID();
//                var rssUrl = RssInfo.getURL();
//                var items = ReaderService.getRssItems(rssUrl);
//                var mapper = mapperConfig.getChannelById(channelId).getMapperConfig();
//                var mappedItems = articleMapper.mapObjects(items, mapper);
//                articles.addAll(mappedItems);
//            }
//        }
//
//        return articles;
//    }

//    public static List<AdTopic> getAllAdTopic() {
////        Db db = new Db();
////        return db.getAllAdTopic();
//        //ORM
//        return null;
//    }
//
//    public static List<Article> getTrendingNews() {
//        return null;
//    }
//
//
//    public static List<MatchResult> getSportInfo() throws Exception {
//        var sportInfo = new ArrayList<MatchResult>();
//        var sportMapper = new SportMapperService();
//        for (var sportApi : sportConfig.getSportapis()) {
//            var items = ReaderService.getMatchResultFromAPI(sportApi);
//            var mappedItems = sportMapper.mapObjects(items, sportApi.getMapper());
//            sportInfo.addAll(mappedItems);
//        }
//        return sportInfo;
//    }
//    public static List<Weather> getWeatherInfo() throws Exception { //

//    }
//
//
//    public static FinanceInfo getFinanceInfo() {
//        return null;
//    }
//
////    public static void getSportsInfo() throws Exception {
////        var mappedMatchResults = new ArrayList<MatchResult>();
////        List<JSONObject> jsonMatchResults = ReaderService.getMatchResultFromAPIUrl("abc.com");
////        mappedMatchResults = MapperService.mapJsonMatchResultsToMatchResults(jsonMatchResults);
////        return mappedMatchResults;
////    }
//
//    public static Feed getFeed365() {
//        return null;
//    }
//
//    public static List<Article> getTopNews() throws Exception {

//    }
}
//
//- Article
//- TopNews
//- Weather
//- Sport
//- Implementing: Finance, Feed365, AdTopic