package service;

import configuration.EndpointConfig;
import configuration.MapperConfig;
import configuration.NewsConfig;
import org.junit.jupiter.api.Test;
import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.junit.platform.engine.support.descriptor.FileSystemSource;
import org.w3c.dom.Node;

import static org.junit.jupiter.api.Assertions.*;

class MapServiceTest {

    @Test
    void getContentOfItem() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                    .readConfig("src/main/resources/bingnewsconfig.json", NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                    .readConfig("src/main/resources/rssmapperconfig.json", MapperConfig.class);
        BingNewsService.endpointConfig = BingNewsService
                    .readConfig("src/main/resources/endpointTopNewsConfig.json", EndpointConfig.class);

        //System.out.println(BingNewsService.getNewsConfig().getCategories().size());

        var ListOfArticles = BingNewsService.getAllArticles();

        var article = ListOfArticles.get(0);

        System.out.println(article.getTitle());
    }

    @Test
    void mapItemToArticle() throws Exception {
        BingNewsService.newsConfig = BingNewsService
                .readConfig("src/main/resources/bingnewsconfig.json", NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService
                .readConfig("src/main/resources/rssmapperconfig.json", MapperConfig.class);
        BingNewsService.endpointConfig = BingNewsService
                .readConfig("src/main/resources/endpointTopNewsConfig.json", EndpointConfig.class);
        var items = ReaderService.getRssItems("https://www.vnexpress.net/rss/tin-moi-nhat.rss");
        var mapper = BingNewsService.mapperConfig.getChannels().get(0).getMapperConfig();
        var item = items.item(0);
        System.out.println(item.getClass().getInterfaces().getClass().getName());
        //System.out.println(com.sun.org.apache.xerces.internal.dom.DeferredElementImpl.class);
        var mappedItem = MapService.mapItemToArticle(item, mapper);
        System.out.println(mappedItem.getTitle());
        //System.out.println(item.getClass());
    }

    @Test
    void mapItemsToArticles() {
    }
}