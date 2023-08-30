package service;


import configuration.MapperConfig;
import configuration.NewsConfig;
import org.junit.jupiter.api.Test;

class BingNewsServiceTest {

    @Test
    void readBingNewsConfig() {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        BingNewsService.readBingNewsConfig(new NewsConfig(newsCfg));

        assert (BingNewsService.newsConfig.getCategories().size() > 0);
    }

    @Test
    void readMapperConfig() {
        String mapperCfg = "src/main/resources/mapperconfig.json";
        BingNewsService.readMapperConfig(new MapperConfig(mapperCfg));

        assert (BingNewsService.mapperConfig.getChannels().size() > 0);
    }

    @Test
    void testGetAllArticles() throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        String mapperCfg = "src/main/resources/mapperconfig.json";
        BingNewsService.readBingNewsConfig(new NewsConfig(newsCfg));
        BingNewsService.readMapperConfig(new MapperConfig(mapperCfg));

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

    @Test
    void getWeatherInfo() {
        var weatherInfo = BingNewsService.getWeatherInfo();
        assert (weatherInfo != null);
    }

    @Test
    void getFinanceInfo() {
        var financeInfo = BingNewsService.getFinanceInfo();
        assert (financeInfo != null);
    }

    @Test
    void getSportsInfo() {
        var sportsInfo = BingNewsService.getSportsInfo();
        assert (sportsInfo != null);
    }

    @Test
    void getFeed365() {
    }
}