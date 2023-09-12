package configuration.financial;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;

public class CurExchangesCfg {
    private String url;
    private Object responseKey;
    private HashMap<String, String> mapper;

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("responseKey")
    public Object getResponseKey() { return responseKey; }
    @JsonProperty("responseKey")
    public void setResponseKey(Object value) { this.responseKey = value; }

    @JsonProperty("mapper")
    public HashMap<String, String> getMapper() { return mapper; }
    @JsonProperty("mapper")
    public void setMapper(HashMap<String, String> value) { this.mapper = value; }
}