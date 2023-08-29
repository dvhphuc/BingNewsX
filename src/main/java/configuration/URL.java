package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class URL {
    private String channelId;
    private String rssUrl;

    @JsonProperty("channelId")
    public String getChannelID() {
        return channelId;
    }

    @JsonProperty("channelId")
    public void setChannelID(String value) {
        this.channelId = value;
    }

    @JsonProperty("url")
    public String getURL() {
        return rssUrl;
    }

    @JsonProperty("url")
    public void setURL(String value) {
        this.rssUrl = value;
    }
}
