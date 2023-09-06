package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class SportAPI {
    private String name;
    private String uri;
    private HashMap<String, String> headers;
    private String method;
    private String responseKey;
    private HashMap<String, String> mapper;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("uri")
    public String getURI() { return uri; }
    @JsonProperty("uri")
    public void setURI(String value) { this.uri = value; }

    @JsonProperty("header")
    public HashMap<String, String> getHeaders() { return headers; }
    @JsonProperty("header")
    public void setHeaders(HashMap<String, String> value) { this.headers = value; }

    @JsonProperty("method")
    public String getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(String value) { this.method = value; }

    @JsonProperty("responseKey")
    public String getResponseKey() { return responseKey; }
    @JsonProperty("responseKey")
    public void setResponseKey(String value) { this.responseKey = value; }

    @JsonProperty("mapper")
    public HashMap<String, String> getMapper() { return mapper; }
    @JsonProperty("mapper")
    public void setMapper(HashMap<String, String> value) { this.mapper = value; }

    public Map.Entry<String, String> getRapidHost() {
        return headers.entrySet().stream().filter(x -> x.getKey().equals("X-RapidAPI-Host")).findFirst().get();
    }

    public Map.Entry<String, String> getRapidKey() {
        return headers.entrySet().stream().filter(x -> x.getKey().equals("X-RapidAPI-Key")).findFirst().get();
    }
}
