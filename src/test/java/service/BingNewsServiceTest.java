package service;


import configuration.NewsConfig;
import org.junit.jupiter.api.Test;

class BingNewsServiceTest {

    @Test
    void readBingNewsConfig() {
        String cfg = "src/main/resources/bingnewsconfig.json";
        BingNewsService.readBingNewsConfig(new NewsConfig(cfg));

        assert (BingNewsService.newsConfig.getCategories().size() > 0);
    }

    @Test
    void readMapperConfig() {
    }

    @Test
    void getAllArticles() throws Exception {
        var articles = BingNewsService.getAllArticles();
        assert (articles.size() > 0);
    }

    @Test
    void getAllAdTopic() {
        var adTopics = BingNewsService.getAllAdTopic();
        assert (adTopics.size() > 0);
    }

    @Test
    void getTopNews() {
        var topNews = BingNewsService.getTopNews();
        assert (topNews.size() > 0);
    }

    @Test
    void getTrendingNews() {
        var trendingNews = BingNewsService.getTrendingNews();
        assert (trendingNews.size() > 0);
    }
}