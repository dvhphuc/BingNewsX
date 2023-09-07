package configuration;

import com.fasterxml.jackson.annotation.*;

public class Header {
    private String xRapidAPIHost;
    private String xRapidAPIKey;

    @JsonProperty("X-RapidAPI-Host")
    public String getXRapidAPIHost() { return xRapidAPIHost; }
    @JsonProperty("X-RapidAPI-Host")
    public void setXRapidAPIHost(String value) { this.xRapidAPIHost = value; }

    @JsonProperty("X-RapidAPI-Key")
    public String getXRapidAPIKey() { return xRapidAPIKey; }
    @JsonProperty("X-RapidAPI-Key")
    public void setXRapidAPIKey(String value) { this.xRapidAPIKey = value; }
}
