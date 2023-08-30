package configuration;

import java.util.List;

public class NewsConfig {
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    List<Category> categories;
}
