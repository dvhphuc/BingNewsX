package service;


import configuration.EndpointConfig;
import configuration.MapperConfig;
import configuration.NewsConfig;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

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
        BingNewsService.newsConfig = ReaderService.readConfig("src/main/resources/bingnewsconfig.json",
                configuration.NewsConfig.class);
        BingNewsService.mapperConfig = ReaderService.readConfig("src/main/resources/rssmapperconfig.json",
                configuration.MapperConfig.class);

        var articles = BingNewsService.getAllArticles();

        System.out.println(articles.get(0).getTitle());
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
    void testGetAllTopNews() throws Exception {
        //BingNewsService.endpointConfig =
        //        BingNewsService.readConfig("src/main/resources/endpointTopNewsConfig.json", EndpointConfig.class);
        var topNewses = BingNewsService.getTopNews();
        topNewses.forEach(article -> System.out.println(article.getTitle()));
        assert (topNewses.size() > 0);

    }

    @Test
    void getTrendingNews() { //TODO: add https://rapidapi.com/blog/rapidapi-featured-news-apis/
        var trendingNews = BingNewsService.getTrendingNews();
        assert (trendingNews.size() > 0);
    }

    @Test
    void getSportInfo() throws Exception {
        BingNewsService.sportConfig = ReaderService.readConfig("src/main/resources/sportconfig.json",
                configuration.SportConfig.class);

        var sportInfo = BingNewsService.getSportInfo();
        for (var result : sportInfo) {
            System.out.println(result.getHomeTeam() + " " + result.getHomeScore() + " - " + result.getAwayScore() + " " + result.getAwayTeam());
        }
        assert (sportInfo.size() > 0);
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
    void getFeed365() {
    }
}