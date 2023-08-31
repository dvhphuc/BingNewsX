package service;


import org.junit.jupiter.api.Test;

class BingNewsServiceTest {

    @Test
    void readBingNewsConfig() throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        BingNewsService.readBingNewsConfig(newsCfg);

        assert (BingNewsService.newsConfig.getCategories().size() > 0);
    }

    @Test
    void readMapperConfig() throws Exception {
        String mapperCfg = "src/main/resources/mapperconfig.json";
        BingNewsService.readMapperConfig(mapperCfg);

        assert (BingNewsService.mapperConfig.getChannels().size() > 0);
    }

    @Test
    void testGetAllArticles() throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        String mapperCfg = "src/main/resources/mapperconfig.json";
        BingNewsService.readBingNewsConfig(newsCfg);
        BingNewsService.readMapperConfig(mapperCfg);

        var articles = BingNewsService.getAllArticles();

        assert (articles.size() > 0);
    }

    @Test
    void getAllAdTopic() {
        var adTopics = BingNewsService.getAllAdTopic();
        assert (adTopics.size() > 0);
    }

    @Test
    void testReadTopNewsAPIConfig() throws Exception {
        BingNewsService.readTopNewsAPIConfig("src/main/resources/topnewsAPIconfig.json");
        assert (BingNewsService.topNewsAPIConfig.getName() != null);
    }

    @Test
    void testGetAllTopNews() throws Exception {
        BingNewsService.readTopNewsAPIConfig("src/main/resources/topnewsAPIconfig.json");
        var topNewses = BingNewsService.getAllTopNews();

        assert (topNewses.size() > 0);
    }

    @Test
    void getTrendingNews() { //TODO: add https://rapidapi.com/blog/rapidapi-featured-news-apis/
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