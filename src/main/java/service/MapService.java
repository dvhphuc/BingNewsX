package service;

import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import model.Article;
import org.json.JSONObject;
import org.w3c.dom.Node;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapService {
    private static final HashMap<Class<?>, Method> methodToGetContentOfClass = new HashMap<>();

    static {

        try {
            methodToGetContentOfClass.put(JSONObject.class, JSONObject.class.getMethod("getString", String.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {
            methodToGetContentOfClass.put(Node.class, MapperService.class.getMethod("getFieldValue", Node.class, String.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String getFieldValue(T item, String field) throws Exception {
        var getContentMethod = methodToGetContentOfClass.get(item.getClass());
        if (item.getClass() == JSONObject.class)
            return (String) getContentMethod.invoke(item, field);
        else if (item.getClass() == DeferredElementImpl.class)
            return (String) getContentMethod.invoke(null, item, field);
        else
        return "wrong type";
    }

    public static <T> Article mapItemToArticle(T item, HashMap<String, String> mapper) throws Exception {
        var article = new Article();
        for (var source : mapper.keySet()) {
            var destination = mapper.get(source);
            String content = getFieldValue(item, destination);
            String setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            var method = Article.class.getMethod(setMethod, String.class);
            method.invoke(article, content);
        }
        return article;
    }

    public static <T>List<Article> mapItemsToArticles(List<T> items, HashMap<String, String> mapper) throws Exception {
        var articles = new ArrayList();
        for (var item : items) {
            var article = mapItemToArticle(item, mapper);
            articles.add(article);
        }
        return articles;
    }
}
