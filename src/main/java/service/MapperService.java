package service;

import configuration.MapperConfig;

import model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Method;
import java.util.*;

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

    //Generic for mapping
    public static Article mapToTopNews(JSONObject jsonNews, HashMap<String, String> mapper) throws Exception {
        var topNews = new Article();
        for (var source : mapper.keySet()) {
            var destination = mapper.get(source);
            var content = jsonNews.getString(destination);
            String setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            Method method = Article.class.getMethod(setMethod, String.class);
            method.invoke(topNews, content);
        }
        return topNews;
    }

    public static List<Article> mapJsonNewsToArticles(JSONArray jsonNews, HashMap<String, String> mapper) throws Exception {
        var topNews = new ArrayList<Article>();
        for (int i = 0; i < jsonNews.length(); ++i) {
            var jsonArticle = jsonNews.getJSONObject(i);
            var atc =  mapToTopNews(jsonArticle, mapper);
            topNews.add(atc);
        }
        return topNews;
    }
    private static final HashMap<Class<?> , String> fieldOfClass = new HashMap<>();

    static void putDestinationField(Class<?> cls, String field) {
        fieldOfClass.put(cls, field);
    }
    public static <T> String getContentOfItem(T item, String destination) {
        for (var cls : fieldOfClass.keySet()) {
            if (item.getClass() == cls) {
                var fieldReturnedByFunction = fieldOfClass.get(cls);
                return fieldReturnedByFunction;
            }
        }
        return "";
    }
    public static <T> Article mapItemToArticle(T item, HashMap<String, String> mapper) throws Exception {
        var article = new Article();
        for (var source : mapper.keySet()) {
            var destination = mapper.get(source);
            String content = getContentOfItem(item, destination);
            String setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            Method method = Article.class.getMethod(setMethod, String.class);
            method.invoke(article, content);
        }
        return article;
    }
}
