package service;

import configuration.Configuration;
import configuration.NewsConfig;
import configuration.article.MapperConfig;
import model.Article;
import service.mapper.ArticleMapperService;

import java.util.ArrayList;
import java.util.List;

public class ArticleService implements IService<Article> {
    private NewsConfig newsConfig;
    private MapperConfig mapperConfig;
    private ArticleMapperService articleMapperService;

    public ArticleService() throws Exception {
        newsConfig = new Configuration().getNewsConfig();
        mapperConfig = new Configuration().getMapperConfig();
        articleMapperService = new ArticleMapperService();
    }

    public ArticleService(NewsConfig newsConfig, MapperConfig mapperConfig, ArticleMapperService atcMapperService) {
        this.newsConfig = newsConfig;
        this.mapperConfig = mapperConfig;
        this.articleMapperService = atcMapperService;
    }

    @Override
    public List<Article> getAll() throws Exception {
        var categories = newsConfig.getCategories();
        var articles = new ArrayList<Article>();
        for (var category : categories) {
            for (var RssInfo : category.getRSSInfos()) {
                var channelId = RssInfo.getChannelID();
                var rssUrl = RssInfo.getURL();
                var items = ReaderService.getRssItems(rssUrl);
                var mapper = mapperConfig.getChannelById(channelId).getMapperConfig();
                var mappedItems = articleMapperService.mapObjects(items, mapper);
                articles.addAll(mappedItems);
            }
        }
        return articles;
    }
}
