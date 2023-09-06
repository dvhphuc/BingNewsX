package service;

import configuration.MapperConfig;
import configuration.NewsConfig;
import org.junit.jupiter.api.Test;
import service.mapper.RssMapperService;

class RssMapperServiceTest {

    @Test
    void getFieldValue() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", MapperConfig.class);

        var items = ReaderService.getRssItems("https://www.vnexpress.net/rss/tin-moi-nhat.rss");
        var item = items.item(0);
        var field = "title";
        var rssMapperService = new RssMapperService();
        var value = rssMapperService.getFieldValue(item, field);

        assert (value != null);
    }

    @Test
    void mapItemToArticle() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", MapperConfig.class);
        var items = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");
        var mapper = BingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();
        var item = items.item(0);
        var rssMapperService = new RssMapperService();
        var mappedItem = rssMapperService.mapItemToArticle(item, mapper);

        System.out.println(mappedItem.getTitle());
        assert (mappedItem.getTitle() != null);
    }

    @Test
    void mapItemsToArticles() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", MapperConfig.class);
        var items = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");
        var mapper = BingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();

        var rssMapperService = new RssMapperService();
        var ListOfItem = rssMapperService.mapItemsToArticles(items, mapper);

        System.out.println(ListOfItem.get(0).getTitle());
    }
}