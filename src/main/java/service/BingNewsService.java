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

    private final IService articleService, topNewsService, weatherService, sportService;


    public BingNewsService() throws Exception {
        articleService = ServiceFactory.create("Article");
        topNewsService = ServiceFactory.create("TopNews");
        weatherService = ServiceFactory.create("Weather");
        sportService = ServiceFactory.create("Sport");
    }

    public List<Article> getArticles() throws Exception {
        return articleService.getAll();
    }

    public List<Article> getTopNews() throws Exception {
        return topNewsService.getAll();
    }

    public List<Weather> getWeatherInfo() throws Exception {
        return weatherService.getAll();
    }

    public List<MatchResult> getSportInfo() throws Exception {
        return sportService.getAll();
    }

}