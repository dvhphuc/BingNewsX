package service;

import configuration.MapperConfig;
import configuration.NewsConfig;
import model.Article;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class MapperService {
    public MapperService(String cfg) {
        BingNewsService.readMapperConfig(new MapperConfig(cfg));
    }
    public static String getContentOfSourceConfigTag(Element e, String listTags) {
        return null;
    }

    public static List<Article> mapToArticles(NodeList items, MapperConfig mapperConfigClass, String channelId) throws Exception {
        return null;
    }
}
