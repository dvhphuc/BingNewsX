//package service;
//
//
//import configuration.article.MapperConfig;
//import configuration.sport.SportConfig;
//import configuration.topnews.EndpointConfig;
//import model.Weather;
//import org.junit.jupiter.api.Test;
//
//class BingNewsServiceTest {
//
//
//
//    @Test
//    void testGetAllArticles() throws Exception {
//        BingNewsService.newsConfig = ReaderService.getConfig("src/main/resources/bingnewsconfig.json",
//                configuration.NewsConfig.class);
//        BingNewsService.mapperConfig = ReaderService.getConfig("src/main/resources/rssmapperconfig.json",
//                MapperConfig.class);
//
//        var articles = BingNewsService.getAllArticles();
//
//        System.out.println(articles.get(0).getTitle());
//        assert (articles.size() > 0);
//    }
//
//    @Test
//    void getAllAdTopic() {
//        var adTopics = BingNewsService.getAllAdTopic();
//        assert (adTopics.size() > 0);
//    }
//
//
//    @Test
//    void testGetTopNews() throws Exception {
//        BingNewsService.endpointConfig =
//                ReaderService.getConfig("src/main/resources/endpointTopNewsConfig.json", EndpointConfig.class);
//        var topNewses = BingNewsService.getTopNews();
//        topNewses.forEach(article -> System.out.println(article.getTitle()));
//        assert (topNewses.size() > 0);
//
//    }
//
//    @Test
//    void getTrendingNews() { //TODO: add https://rapidapi.com/blog/rapidapi-featured-news-apis/
//        var trendingNews = BingNewsService.getTrendingNews();
//        assert (trendingNews.size() > 0);
//    }
//
//    @Test
//    void testGetSportsInfo() throws Exception {
//        BingNewsService.sportConfig = ReaderService.getConfig("src/main/resources/sportConfig.json",
//                SportConfig.class);
//        var sportsInfo = BingNewsService.getSportInfo();
//
//        assert (sportsInfo.size() > 0);
//    }
//    @Test
//    void getWeatherInfo() throws Exception {
//        BingNewsService.weatherConfig = ReaderService.getConfig("src/main/resources/weatherconfig.json",
//                configuration.weather.WeatherConfig.class);
//        var weathersInfo = BingNewsService.getWeatherInfo();
//        for (Weather weather : weathersInfo) {
//            System.out.println(weather.getLocation() + " " + weather.getTemperatureC() + " " + weather.getTime());
//        }
//        assert (weathersInfo.size() > 0);
//    }
//
//    @Test
//    void getFinanceInfo() {
//        var financeInfo = BingNewsService.getFinanceInfo();
//        assert (financeInfo != null);
//    }
//
//
//    @Test
//    void getFeed365() {
//    }
//}