package service;

import configuration.MapperConfig;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Article;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapperService {
    public MapperService() {
    }

    // "description.img#scr"
    public static String getFieldValue(Node node, String destination) throws Exception {
        var attributeOfLastTag = "";
        if (destination.contains("#")) {
            attributeOfLastTag = destination.split("#")[1];
            destination = destination.split("#")[0];
        }

        var tagsList = destination.split("\\.");

        for (var tag : tagsList) {
            if (tag.contains("#")) {
                attributeOfLastTag = tag.split("#")[1];
                tag = tag.split("#")[0];
            }
            node = ((Element) node).getElementsByTagName(tag).item(0);
        }

        if (attributeOfLastTag != "")
            return ((Element) node).getAttribute(attributeOfLastTag);
        return node.getTextContent();
    }

    public static Article mapToArticle(Node item, HashMap<String, String> mapper) throws Exception {
        var article = new Article();
        for (var source : mapper.keySet()) {
            var destination = mapper.get(source);
            var content = getFieldValue(item, destination);
            // set property destination of article
            // if want to set "title", call method "setTitle"
            String setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            Method method = Article.class.getMethod(setMethod, String.class);
            method.invoke(article, content);
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
