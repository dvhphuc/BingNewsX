package configuration;

import com.fasterxml.jackson.annotation.*;
import configuration.article.Category;

import java.util.List;

public class NewsConfig {
    private List<Category> categories;

    @JsonProperty("categories")
    public List<Category> getCategories() { return categories; }
    @JsonProperty("categories")
    public void setCategories(List<Category> value) { this.categories = value; }
}