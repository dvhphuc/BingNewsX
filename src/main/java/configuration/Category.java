package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {
    private String name;
    private List<URL> urls;

    @JsonProperty("categoryName")
    public String getCategoryName() {
        return name;
    }

    @JsonProperty("categoryName")
    public void setCategoryName(String value) {
        this.name = value;
    }

    @JsonProperty("urls")
    public List<URL> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<URL> value) {
        this.urls = value;
    }
}
