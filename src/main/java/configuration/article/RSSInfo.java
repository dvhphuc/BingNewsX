package configuration.article;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RSSInfo {
    private String channelId;
    private String url;

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
        return url;
    }

    @JsonProperty("url")
    public void setURL(String value) {
        this.url = value;
    }
}
