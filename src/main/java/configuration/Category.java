package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {
    private String name;
    private List<RssInfo> rssInfos;

    @JsonProperty("categoryName")
    public String getCategoryName() {
        return name;
    }


    @JsonProperty("urls")
    public List<RssInfo> getRssInfo() {
        return rssInfos;
    }

}
