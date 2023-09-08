package configuration.weather;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class WeatherConfig {
    private List<WeatherApi> weatherapis;

    @JsonProperty("weatherapis")
    public List<WeatherApi> getWeatherapis() { return weatherapis; }
    @JsonProperty("weatherapis")
    public void setWeatherapis(List<WeatherApi> value) { this.weatherapis = value; }
}
