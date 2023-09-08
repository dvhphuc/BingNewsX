package service;

import configuration.weather.WeatherConfig;
import org.junit.jupiter.api.Test;

class ReaderServiceTest {

    @Test
    void getRssItems() throws Exception {
        String rssUrl = "https://vnexpress.net/rss/phap-luat.rss";
        var items = ReaderService.getRssItems(rssUrl);

        assert  (items.getLength() > 0);
    }

    @Test
    void testGetHourlyWeather() throws Exception {
        var weatherApi = ReaderService.getConfig("src/main/resources/weatherconfig.json", WeatherConfig.class);
        var firstWeatherApi = weatherApi.getWeatherapis().get(0);
        var hourlyWeather = ReaderService.getWeatherJsonFromAPI(firstWeatherApi);

        for (var i = 0; i < hourlyWeather.length(); ++i) {
            var hourlyWeatherItem = hourlyWeather.getJSONObject(i);
            System.out.println(hourlyWeatherItem.toString());
        }
        assert (hourlyWeather.length() > 0);
    }
}