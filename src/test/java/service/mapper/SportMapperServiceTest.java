package service.mapper;

import configuration.sport.SportConfig;
import org.junit.jupiter.api.Test;
import service.BingNewsService;
import service.ReaderService;

class SportMapperServiceTest {

    @Test
    void testMapObjectToMatchResult() throws Exception {
        //Hey copilot can you add config for this test?
        BingNewsService bingNewsService = new BingNewsService();

        BingNewsService.sportConfig = ReaderService.getConfig("src/main/resources/sportConfig.json",
                SportConfig.class);

        var firstAPIInCfg = BingNewsService.sportConfig.getSportapis().get(0);

        var matchResultJson = ReaderService.getMatchResultFromAPI(firstAPIInCfg).getJSONObject(0);

        var mapper = firstAPIInCfg.getMapper();

        var sportMapperService = new SportMapperService();
        var matchResult = sportMapperService.mapObject(matchResultJson, mapper);

        assert(matchResult != null);
    }

    @Test
    void testMapObjectsToListMatchResult() throws Exception {
        BingNewsService.sportConfig = ReaderService.getConfig("src/main/resources/sportConfig.json",
                SportConfig.class);

        var firstAPIInCfg = BingNewsService.sportConfig.getSportapis().get(0);
        var matchResultsJson = ReaderService.getMatchResultFromAPI(firstAPIInCfg);
        var mapper = firstAPIInCfg.getMapper();
        var sportMapperService = new SportMapperService();

        var mappedMatchResults = sportMapperService.mapObjects(matchResultsJson, mapper);

        System.out.println(mappedMatchResults.get(0).getHomeTeam() + " vs " + mappedMatchResults.get(0).getAwayTeam());
        assert(mappedMatchResults.size() > 0);
    }

}