package service.mapper;

import configuration.SportConfig;
import org.junit.jupiter.api.Test;
import service.BingNewsService;
import service.ReaderService;

import static org.junit.jupiter.api.Assertions.*;

class SportMapperServiceTest {

    @Test
    void mapObject() throws Exception {
        //Hey copilot can you add config for this test?
        BingNewsService bingNewsService = new BingNewsService();

        BingNewsService.sportConfig = ReaderService.readConfig("src/main/resources/sportConfig.json",
                SportConfig.class);

        var firstAPIInCfg = BingNewsService.sportConfig.getSportapis().get(0);

        var matchResultJson = ReaderService.getMatchResultFromAPI(firstAPIInCfg).getJSONObject(0);

        var mapper = firstAPIInCfg.getMapper();

        var sportMapperService = new SportMapperService();
        var matchResult = sportMapperService.mapObject(matchResultJson, mapper);

        assert(matchResult != null);
    }

    @Test
    void mapObjects() throws Exception {
        BingNewsService.sportConfig = ReaderService.readConfig("src/main/resources/sportConfig.json",
                SportConfig.class);

        var firstAPIInCfg = BingNewsService.sportConfig.getSportapis().get(0);
        var matchResultsJson = ReaderService.getMatchResultFromAPI(firstAPIInCfg);
        var mapper = firstAPIInCfg.getMapper();
        var sportMapperService = new SportMapperService();

        var mappedMatchResults = sportMapperService.mapObjects(matchResultsJson, mapper);

        assert(mappedMatchResults.size() > 0);
    }

}