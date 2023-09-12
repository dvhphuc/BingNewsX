package service.mapper;

import configuration.Configuration;
import configuration.article.MapperConfig;
import org.junit.jupiter.api.Test;
import service.BingNewsService;
import service.ReaderService;

class ArticleMapperServiceTest {

    @Test
    void testMapObjectToArticle() throws Exception {
        Configuration cfg = new Configuration();
        BingNewsService bingNewsService = new BingNewsService();

        var listRssItems = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");

        var firstItem = listRssItems.item(0);
        var mapper = cfg.getMapperConfig().getChannels().get(0).getMapperConfig();

        var articleMapperService = new ArticleMapperService();
        var article = articleMapperService.mapObject(firstItem, mapper);

        System.out.println(article.getTitle());
    }

    @Test
    void testMapObjectsToListArticle() throws Exception {

    }
}