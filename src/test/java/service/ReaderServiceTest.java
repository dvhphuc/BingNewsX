package service;

import configuration.SportAPI;
import configuration.SportAPIsConfig;
import org.junit.jupiter.api.Test;

class ReaderServiceTest {

    @Test
    void getRssItems() throws Exception {
        String rssUrl = "https://vnexpress.net/rss/phap-luat.rss";
        var items = ReaderService.getRssItems(rssUrl);

        assert  (items.getLength() > 0);
    }

    @Test
    void getMatchResultFromAPI() throws Exception {
        var sportAPI = BingNewsService.readConfig("src/main/resources/sportConfig.json", SportAPIsConfig.class);
        var firstAPI = sportAPI.getSportapis().get(0);

        var matchResults = ReaderService.getMatchResultFromAPI(firstAPI);

        for (var i=0; i<matchResults.length(); ++i) {
            var matchResult = matchResults.getJSONObject(i);
            System.out.println(matchResult);
        }
        assert (matchResults.length() > 0);
    }
}