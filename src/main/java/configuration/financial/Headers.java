package configuration.financial;

import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.annotation.*;

public class Headers {
    private String xRapidAPIKey;
    private String xRapidAPIHost;

    @JsonProperty("X-RapidAPI-Key")
    public String getXRapidAPIKey() { return xRapidAPIKey; }
    @JsonProperty("X-RapidAPI-Key")
    public void setXRapidAPIKey(String value) { this.xRapidAPIKey = value; }

    @JsonProperty("X-RapidAPI-Host")
    public String getXRapidAPIHost() { return xRapidAPIHost; }
    @JsonProperty("X-RapidAPI-Host")
    public void setXRapidAPIHost(String value) { this.xRapidAPIHost = value; }
}