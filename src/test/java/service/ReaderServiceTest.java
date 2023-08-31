package service;

import org.junit.jupiter.api.Test;

class ReaderServiceTest {

    @Test
    void getRssItems() throws Exception {
        String rssUrl = "https://vnexpress.net/rss/phap-luat.rss";
        var items = ReaderService.getRssItems(rssUrl);

        assert  (items.getLength() > 0);
    }
}