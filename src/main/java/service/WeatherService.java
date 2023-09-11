package service;

import configuration.Configuration;
import configuration.weather.WeatherConfig;
import model.Weather;
import service.mapper.WeatherMapperService;

import java.util.ArrayList;
import java.util.List;

public class WeatherService implements IService {
    private WeatherConfig weatherConfig;

    public WeatherService() throws Exception {
        weatherConfig = new Configuration().getWeatherConfig();
    }
    @Override
    public List getAll() throws Exception {
        var weatherInfos = new ArrayList<Weather>();
        var weatherMapper = new WeatherMapperService();
        for (var weatherApi : weatherConfig.getWeatherapis()) {
            var items = ReaderService.getWeatherJsonFromAPI(weatherApi);
            var mappedItems = weatherMapper.mapObjects(items, weatherApi.getMapper());
            var location = weatherApi.getLocation();
            mappedItems = weatherMapper.setLocation(mappedItems, location);
            weatherInfos.addAll(mappedItems);
        }
        return weatherInfos;
    }
}
