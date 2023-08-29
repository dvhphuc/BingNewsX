package configuration;

import java.util.List;

public class NewsConfig {
    public NewsConfig(String cfg) {
        // TODO Auto-generated constructor stub
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    List<Category> categories;

}
