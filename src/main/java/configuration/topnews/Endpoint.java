package configuration.topnews;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;

public class Endpoint {
    private String uri;
    private String responseKey;
    private HashMap<String, String> mapper;

    @JsonProperty("uri")
    public String getURI() { return uri; }
    @JsonProperty("uri")
    public void setURI(String value) { this.uri = value; }

    @JsonProperty("responseKey")
    public String getResponseKey() { return responseKey; }
    @JsonProperty("responseKey")
    public void setResponseKey(String value) { this.responseKey = value; }

    @JsonProperty("mapper")
    public HashMap<String, String>  getMapper() { return mapper; }
    @JsonProperty("mapper")
    public void setMapper(HashMap<String, String>  value) { this.mapper = value; }
}