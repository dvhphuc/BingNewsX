package configuration.weather;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;

public class WeatherApi {
    private String name;
    private String endpoint;
    private String responseKey;
    private HashMap<String, String> mapper;

    private String location;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("endpoint")
    public String getEndpoint() { return endpoint; }
    @JsonProperty("endpoint")
    public void setEndpoint(String value) { this.endpoint = value; }

    @JsonProperty("responseKey")
    public String getResponseKey() { return responseKey; }
    @JsonProperty("responseKey")
    public void setResponseKey(String value) { this.responseKey = value; }

    @JsonProperty("mapper")
    public HashMap<String, String> getMapper() { return mapper; }
    @JsonProperty("mapper")
    public void setMapper(HashMap<String, String> value) { this.mapper = value; }

    @JsonProperty("location")
    public String getLocation() { return name; }
    @JsonProperty("location")
    public void setLocation(String value) { this.name = value; }
}