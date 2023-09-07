package configuration;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class Sportapi {
    private String name;
    private String uri;
    private HashMap<String, String> header;
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
    public HashMap<String, String> getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(HashMap<String, String> value) { this.header = value; }

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

}