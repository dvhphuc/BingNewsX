package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {
    private String name;
    private List<RssInfo> rssInfos;

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public String setName() {
        return name;
    }


    @JsonProperty("RssInfos")
    public List<RssInfo> getRssInfo() {
        return rssInfos;
    }
    @JsonProperty("RssInfos")
    public List<RssInfo> setRssInfo() {
        return rssInfos;
    }
}
