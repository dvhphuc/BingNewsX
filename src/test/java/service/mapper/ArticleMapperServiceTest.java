package service.mapper;

import org.junit.jupiter.api.Test;
import service.BingNewsService;
import service.ReaderService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleMapperServiceTest {

    @Test
    void mapObject() throws Exception {
        BingNewsService bingNewsService = new BingNewsService();
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json",
                        configuration.NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json",
                        configuration.MapperConfig.class);

        var listRssItems = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");

        var firstItem = listRssItems.item(0);
        var mapper = bingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();

        var articleMapperService = new ArticleMapperService();
        var article = articleMapperService.mapObject(firstItem, mapper);

        System.out.println(article.getTitle());
    }

    @Test
    void mapObjects() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json",
                        configuration.NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json",
                        configuration.MapperConfig.class);

        BingNewsService bingNewsService = new BingNewsService();
        var listRssItems = ReaderService.getRssItems("https://vnexpress.net/rss/tin-moi-nhat.rss");

        var articleMapperService = new ArticleMapperService();
        var mapper = bingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();
        var mappedItems = articleMapperService.mapObjects(listRssItems, mapper);

        System.out.println(mappedItems.get(0).getTitle());
    }
}