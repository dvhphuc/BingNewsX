package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderRSSServiceTest {

    @Test
    void getRssItems() throws Exception {
        String rssUrl = "https://vnexpress.net/rss/phap-luat.rss";
        var items = ReaderRSSService.getRssItems(rssUrl);

        assert  (items.getLength() > 0);
    }
}