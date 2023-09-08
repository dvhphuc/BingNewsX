package service;


import configuration.article.MapperConfig;
import configuration.sport.SportConfig;
import model.Weather;
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
        BingNewsService.newsConfig = ReaderService.getConfig("src/main/resources/bingnewsconfig.json",
                configuration.NewsConfig.class);
        BingNewsService.mapperConfig = ReaderService.getConfig("src/main/resources/rssmapperconfig.json",
                MapperConfig.class);

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
    void testGetSportsInfo() throws Exception {
        BingNewsService.sportConfig = ReaderService.getConfig("src/main/resources/sportConfig.json",
                SportConfig.class);
        var sportsInfo = BingNewsService.getSportInfo();

        assert (sportsInfo.size() > 0);
    }
    @Test
    void getWeatherInfo() throws Exception {
        BingNewsService.weatherConfig = ReaderService.getConfig("src/main/resources/weatherconfig.json",
                configuration.weather.WeatherConfig.class);
        var weathersInfo = BingNewsService.getWeatherInfo();
        for (Weather weather : weathersInfo) {
            System.out.println(weather.getLocation() + " " + weather.getTemperatureC() + " " + weather.getTime());
        }
        assert (weathersInfo.size() > 0);
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