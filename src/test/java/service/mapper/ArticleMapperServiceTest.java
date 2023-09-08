package service.mapper;

import configuration.article.MapperConfig;
import org.junit.jupiter.api.Test;
import service.BingNewsService;
import service.ReaderService;

class ArticleMapperServiceTest {

    @Test
    void testMapObjectToArticle() throws Exception {
        BingNewsService bingNewsService = new BingNewsService();
        BingNewsService.newsConfig = ReaderService.getConfig("src/main/resources/bingnewsconfig.json",
                        configuration.NewsConfig.class);
        BingNewsService.mapperConfig = ReaderService.getConfig("src/main/resources/rssmapperconfig.json",
                        MapperConfig.class);

        var listRssItems = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");

        var firstItem = listRssItems.item(0);
        var mapper = bingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();

        var articleMapperService = new ArticleMapperService();
        var article = articleMapperService.mapObject(firstItem, mapper);

        System.out.println(article.getTitle());
    }

    @Test
    void testMapObjectsToListArticle() throws Exception {
        BingNewsService.newsConfig = ReaderService.getConfig("src/main/resources/bingnewsconfig.json",
                configuration.NewsConfig.class);
        BingNewsService.mapperConfig = ReaderService.getConfig("src/main/resources/rssmapperconfig.json",
                MapperConfig.class);

        BingNewsService bingNewsService = new BingNewsService();
        var listRssItems = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");

        var articleMapperService = new ArticleMapperService();
        var mapper = bingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();
        var mappedItems = articleMapperService.mapObjects(listRssItems, mapper);

        System.out.println(mappedItems.get(0).getTitle());
        assert mappedItems.size() > 0;
    }
}