package service;

import configuration.MapperConfig;
import configuration.NewsConfig;
import configuration.TrendingConfig;
import model.Article;
import java.util.ArrayList;
import java.util.List;

public class BingNewsService {
    static NewsConfig newsConfig;
    private static MapperConfig mapperConfig;

    public static void readBingNewsConfig(NewsConfig _newsConfig) {
        newsConfig = _newsConfig;
    }

    public static void readMapperConfig(MapperConfig _mapperConfig) {
        mapperConfig = _mapperConfig;
    }

    public static List<Article> getAllArticles() throws Exception {
        var articles = new ArrayList<Article>();
        String cfg = "";
        readBingNewsConfig(new NewsConfig(cfg));
        var categories = newsConfig.getCategories();

        for (var category : categories) {
            for (var rssUrl_channel : category.getUrls()) {
                var channelId = rssUrl_channel.getChannelID();
                var rssUrl = rssUrl_channel.getURL();
                var items = ReaderRSSService.getRssItems(rssUrl);
                var mappedItem = MapperService.mapToArticles(items, mapperConfig, channelId);

                articles.addAll(mappedItem);
            }
        }

        return articles;
    }

    public static List<AdTopic> getAllAdTopic() {
        //Db db = new Db();
        //return db.getAllAdTopic();
        return null;
    }

    public static List<Article> getTopNews() {
        return null;
    }

    public static List<Article> getTrendingNews() {
        return null;
    }

    public static void readTrendingConfig(TrendingConfig trendingConfig) {

    }

    public class AdTopic {
        // Order by ......
    }
}

