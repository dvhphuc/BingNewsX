package configuration;

import configuration.article.MapperConfig;
import configuration.financial.FinancialConfig;
import configuration.sport.SportConfig;
import configuration.topnews.EndpointConfig;
import configuration.weather.WeatherConfig;
import service.ReaderService;

public class Configuration {

    private final String NEWSCFG_PATH = "src/main/resources/bingnewsconfig.json";
    private final String MAPPERCFG_PATH = "src/main/resources/rssmapperconfig.json";
    private final String ENDPOINTCFG_PATH = "src/main/resources/endpointTopNewsConfig.json";
    private final String SPORTCFG_PATH = "src/main/resources/sportconfig.json";
    private final String WEATHERCFG_PATH = "src/main/resources/weatherconfig.json";
    private final String FINANCECFG_PATH = "src/main/resources/financialConfig.json";

    NewsConfig newsConfig;

    MapperConfig mapperConfig;
    EndpointConfig endpointConfig;
    SportConfig sportConfig;
    WeatherConfig weatherConfig;

    public FinancialConfig getFinancialConfig() {
        return financialConfig;
    }

    public void setFinancialConfig(FinancialConfig financialConfig) {
        this.financialConfig = financialConfig;
    }

    FinancialConfig financialConfig;

    public NewsConfig getNewsConfig() {
        return newsConfig;
    }

    public void setNewsConfig(NewsConfig newsConfig) {
        this.newsConfig = newsConfig;
    }

    public MapperConfig getMapperConfig() {
        return mapperConfig;
    }

    public void setMapperConfig(MapperConfig mapperConfig) {
        this.mapperConfig = mapperConfig;
    }

    public EndpointConfig getEndpointConfig() {
        return endpointConfig;
    }

    public void setEndpointConfig(EndpointConfig endpointConfig) {
        this.endpointConfig = endpointConfig;
    }

    public SportConfig getSportConfig() {
        return sportConfig;
    }

    public void setSportConfig(SportConfig sportConfig) {
        this.sportConfig = sportConfig;
    }

    public WeatherConfig getWeatherConfig() {
        return weatherConfig;
    }

    public void setWeatherConfig(WeatherConfig weatherConfig) {
        this.weatherConfig = weatherConfig;
    }

    public Configuration() throws Exception {
        newsConfig = ReaderService.getConfig(NEWSCFG_PATH, NewsConfig.class);
        mapperConfig = ReaderService.getConfig(MAPPERCFG_PATH, MapperConfig.class);
        endpointConfig = ReaderService.getConfig(ENDPOINTCFG_PATH, EndpointConfig.class);
        sportConfig = ReaderService.getConfig(SPORTCFG_PATH, SportConfig.class);
        weatherConfig = ReaderService.getConfig(WEATHERCFG_PATH, WeatherConfig.class);
        financialConfig = ReaderService.getConfig(FINANCECFG_PATH, FinancialConfig.class);
    }
}
