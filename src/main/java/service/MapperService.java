package service;

import configuration.MapperConfig;
import model.Article;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapperService {
    public MapperService() {
    }

    // "description.img#scr"
    public static String getFieldValue(Node node, String destination) {
        var attributeInDestination = "";
        if (destination.contains("#")) {
            attributeInDestination = destination.split("#")[1];
            destination = destination.split("#")[0];
        }

        var tagsList = destination.split("\\.");

        for (var tag : tagsList)
            node = ((Element) node).getElementsByTagName(tag).item(0);


        if (attributeInDestination != "")
            return ((Element) node).getAttribute(attributeInDestination);
        return node.getTextContent();
    }

    public static Article mapToArticle(Node item, HashMap<String, String> mapper) {
        var article = new Article();
        for (var source : mapper.keySet()) {
            var destination = mapper.get(source);
            var content = getFieldValue(item, destination);
            article.setField(source, content);
        }
        return article;
    }
    public static List<Article> mapItemsToArticles(NodeList items, MapperConfig mapperConfig, String channelId) throws Exception {
        var articles = new ArrayList<Article>();
        var channel = mapperConfig.getChannelById(channelId);
        var mapper = channel.getMapperConfig();

        for (int i = 0; i < items.getLength(); ++i) {
            var item = items.item(i);
            var atc =  mapToArticle(item, mapper);
            articles.add(atc);
        }
        return articles;
    }
}
