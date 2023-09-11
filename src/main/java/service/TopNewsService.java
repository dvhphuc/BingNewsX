package service;

import configuration.Configuration;
import configuration.topnews.EndpointConfig;
import model.Article;
import service.mapper.ArticleMapperService;
import java.util.ArrayList;
import java.util.List;

public class TopNewsService implements IService<Article> {
    private EndpointConfig endpointConfig;
    private ArticleMapperService atcMapper;

    public TopNewsService() throws Exception {
        endpointConfig = new Configuration().getEndpointConfig();
        atcMapper = new ArticleMapperService();
    }

    @Override
    public List<Article> getAll() throws Exception {
        var topNews = new ArrayList<Article>();
        var endpoints = endpointConfig.getEndpoints();
        for (var endpoint : endpoints){
            var uri = endpoint.getURI();
            var mapper = endpoint.getMapper();
            var items = ReaderService.getNewsJsonFromAPI(uri, endpoint.getResponseKey());
            var mappedItems = atcMapper.mapObjects(items, mapper);
            topNews.addAll(mappedItems);
        }
        return topNews;
    }
}
