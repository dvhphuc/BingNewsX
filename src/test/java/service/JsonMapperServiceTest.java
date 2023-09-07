package service;

import org.junit.jupiter.api.Test;
import service.mapper.JsonMapperObjectToArticleService;

class JsonMapperServiceTest {

    @Test
    void getFieldValue() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", configuration.NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", configuration.MapperConfig.class);
        BingNewsService.endpointConfig = BingNewsService
                .readConfig("src/main/resources/endpointTopNewsConfig.json", configuration.EndpointConfig.class);
        var endpoint = BingNewsService.endpointConfig.getEndpoints().get(0).getURI();
        var responseKey = BingNewsService.endpointConfig.getEndpoints().get(0).getResponseKey();
        var items = ReaderService.getNewsJsonFromAPI(endpoint, responseKey);

        var item = items.getJSONObject(0);
        var field = "title";
        var jsonMapperService = new JsonMapperObjectToArticleService();
        var value = jsonMapperService.getFieldValue(item, field);

        assert (value != null);
    }

    @Test
    void mapItemToArticle() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", configuration.NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", configuration.MapperConfig.class);
        BingNewsService.endpointConfig = BingNewsService
                .readConfig("src/main/resources/endpointTopNewsConfig.json", configuration.EndpointConfig.class);
        var endpoint = BingNewsService.endpointConfig.getEndpoints().get(0).getURI();
        var responseKey = BingNewsService.endpointConfig.getEndpoints().get(0).getResponseKey();

        var items = ReaderService.getNewsJsonFromAPI(endpoint, responseKey);

        var item = items.getJSONObject(0);
        var mapper = BingNewsService.endpointConfig.getEndpoints().get(0).getMapper();
        var jsonMapperService = new JsonMapperObjectToArticleService();
        var mappedItem = jsonMapperService.mapItemToArticle(item, mapper);

        assert (mappedItem != null);
    }

    @Test
    void mapItemsToArticles() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", configuration.NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", configuration.MapperConfig.class);
        BingNewsService.endpointConfig = BingNewsService
                .readConfig("src/main/resources/endpointTopNewsConfig.json", configuration.EndpointConfig.class);
        var endpoint = BingNewsService.endpointConfig.getEndpoints().get(0).getURI();
        var responseKey = BingNewsService.endpointConfig.getEndpoints().get(0).getResponseKey();

        var items = ReaderService.getNewsJsonFromAPI(endpoint, responseKey);

        var mapper = BingNewsService.endpointConfig.getEndpoints().get(0).getMapper();

        var jsonMapperService = new JsonMapperObjectToArticleService();
        var mappedItems = jsonMapperService.mapItemsToArticles(items, mapper);

        assert (mappedItems.size() > 0);
    }
}