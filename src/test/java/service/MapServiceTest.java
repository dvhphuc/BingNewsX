package service;

import configuration.EndpointConfig;
import configuration.MapperConfig;
import configuration.NewsConfig;
import configuration.SportAPIsConfig;
import org.junit.jupiter.api.Test;
import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.junit.platform.engine.support.descriptor.FileSystemSource;
import org.w3c.dom.Node;
import service.mapper.JsonMapperService;

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
    void mapItemsToArticles() {
    }

    @Test
    void mapJsonMatchResultToMatchResult() throws Exception {
        BingNewsService.sportConfig = BingNewsService
                    .readConfig("src/main/resources/sportConfig.json", SportAPIsConfig.class);
        var sportAPI = BingNewsService.sportConfig.getSportapis().get(0);
        var matchResults = ReaderService.getMatchResultFromAPI(sportAPI);
        var matchResult = matchResults.getJSONObject(0);

        var mapService = new JsonMapperService();
        var mappedMatchResult = mapService.mapJsonResultToMatchResult(matchResult, sportAPI.getMapper());

        System.out.println(mappedMatchResult.getAwayScore());
    }
}