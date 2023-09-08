package configuration.article;
import com.fasterxml.jackson.annotation.*;
import configuration.article.RSSInfo;

import java.util.List;

public class Category {
    private String categoryName;
    private List<RSSInfo> rssInfos;

    @JsonProperty("categoryName")
    public String getCategoryName() { return categoryName; }
    @JsonProperty("categoryName")
    public void setCategoryName(String value) { this.categoryName = value; }

    @JsonProperty("RssInfos")
    public List<RSSInfo> getRSSInfos() { return rssInfos; }
    @JsonProperty("RssInfos")
    public void setRSSInfos(List<RSSInfo> value) { this.rssInfos = value; }
}