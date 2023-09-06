package service;


import configuration.EndpointConfig;
import configuration.MapperConfig;
import configuration.NewsConfig;
import configuration.SportAPI;
import org.junit.jupiter.api.Test;
import service.mapper.RssMapperService;

class BingNewsServiceTest {

    @Test
    void readBingNewsConfig() throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        //BingNewsService.newsConfig = BingNewsService.readConfig(newsCfg, NewsConfig.class);

        assert (BingNewsService.newsConfig.getCategories().size() > 0);
    }

    @Test
    void readMapperConfig() throws Exception {
        String mapperCfg = "src/main/resources/rssmapperconfig.json";
        //BingNewsService.mapperConfig = BingNewsService.readConfig(mapperCfg, MapperConfig.class);

        assert (BingNewsService.mapperConfig.getChannels().size() > 0);
    }

    @Test
    void testGetAllArticles() throws Exception {
        String newsCfg = "src/main/resources/bingnewsconfig.json";
        String mapperCfg = "src/main/resources/rssmapperconfig.json";

        BingNewsService.newsConfig = BingNewsService.readConfig(newsCfg, NewsConfig.class);
        BingNewsService.mapperConfig = BingNewsService.readConfig(mapperCfg, MapperConfig.class);

        var rssMapperService = new RssMapperService();
        var bingNewsService = new BingNewsService(rssMapperService);

        var articles = bingNewsService.getAllArticles();

        assert (articles.size() > 0);
    }

    @Test
    void getAllAdTopic() {
        var adTopics = BingNewsService.getAllAdTopic();
        assert (adTopics.size() > 0);
    }

//    @Test
//    void testReadTopNewsAPIConfig() throws Exception {
//        BingNewsService.readTopNewsAPIConfig("src/main/resources/endpointTopNewsConfig.json");
//        System.out.println(BingNewsService.endpointConfig.getEndpoints());
//        assert (BingNewsService.endpointConfig.getEndpoints().size() > 0);
//    }

    @Test
    void testGetTopNews() throws Exception {
        String endpointTopNewsAPICfg = "src/main/resources/endpointTopNewsConfig.json";

        BingNewsService.endpointConfig = BingNewsService.readConfig(endpointTopNewsAPICfg, EndpointConfig.class);

        var jsonMapperService = new service.mapper.JsonMapperService();
        var bingNewsService = new BingNewsService(jsonMapperService);

        var articles = bingNewsService.getTopNews();

        assert (articles.size() > 0);
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

//    @Test
//    void getSportInfo() throws Exception {
//        BingNewsService.sportConfig = BingNewsService
//                    .readConfig("src/main/resources/sportAPIConfig.json", SportAPI.class);
//
//        var bingNewsService = new BingNewsService(new service.mapper.JsonMapperService());
//        //var sportInfo = bingNewsService.
//        //assert (sportInfo != null);
//    }

    @Test
    void getFinanceInfo() {
        var financeInfo = BingNewsService.getFinanceInfo();
        assert (financeInfo != null);
    }


    @Test
    void getFeed365() {
    }
}