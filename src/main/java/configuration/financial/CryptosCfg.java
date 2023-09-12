package configuration.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class CryptosCfg {
    private String method;
    private String responseKey;
    private String uri;
    private Headers headers;
    private HashMap<String, String> mapper;

    @JsonProperty("method")
    public String getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(String value) { this.method = value; }

    @JsonProperty("responseKey")
    public String getResponseKey() { return responseKey; }
    @JsonProperty("responseKey")
    public void setResponseKey(String value) { this.responseKey = value; }

    @JsonProperty("uri")
    public String getURI() { return uri; }
    @JsonProperty("uri")
    public void setURI(String value) { this.uri = value; }

    @JsonProperty("headers")
    public Headers getHeaders() { return headers; }
    @JsonProperty("headers")
    public void setHeaders(Headers value) { this.headers = value; }

    @JsonProperty("mapper")
    public HashMap<String, String> getMapper() { return mapper; }
    @JsonProperty("mapper")
    public void setMapper(HashMap<String, String> value) { this.mapper = value; }
}
