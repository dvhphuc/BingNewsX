package service.mapper;

import org.junit.jupiter.api.Test;
import service.BingNewsService;
import service.ReaderService;

import static org.junit.jupiter.api.Assertions.*;

class WeatherMapperServiceTest {

    @Test
    void testMapObjectToWeather() throws Exception {
        BingNewsService.weatherConfig = ReaderService.getConfig("src/main/resources/weatherconfig.json",
                configuration.weather.WeatherConfig.class);

        var weatherApi = BingNewsService.weatherConfig.getWeatherapis().get(0);
        var weatherItem = ReaderService.getWeatherJsonFromAPI(weatherApi).getJSONObject(0);

        var weatherMapperService = new WeatherMapperService();
        var mapper = weatherApi.getMapper();
        var weather = weatherMapperService.mapObject(weatherItem, mapper);
        System.out.println(weather.getTime());
    }

    @Test
    void testMapObjectsToWeathers() throws Exception {
        BingNewsService.weatherConfig = ReaderService.getConfig("src/main/resources/weatherconfig.json",
                configuration.weather.WeatherConfig.class);

        var weatherApi = BingNewsService.weatherConfig.getWeatherapis().get(0);
        var weatherItems = ReaderService.getWeatherJsonFromAPI(weatherApi);

        var weatherMapperService = new WeatherMapperService();
        var mapper = weatherApi.getMapper();
        var weathers = weatherMapperService.mapObjects(weatherItems, mapper);
    }
}