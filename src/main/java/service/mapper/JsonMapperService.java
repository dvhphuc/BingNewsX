package service.mapper;

import model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import service.mapper.IMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonMapperService implements IMapper {
    @Override
    public <T> String getFieldValue(T item, String field) throws Exception {
        if (!(item instanceof JSONObject))
            throw new Exception("Wrong type of item, must be JSONObject");
        var jsonItem = (JSONObject) item;
        return jsonItem.getString(field);
    }
    @Override
    public <T> Article mapItemToArticle(T item, HashMap<String, String> mapper) throws Exception {
        if (!(item instanceof JSONObject))
            throw new Exception("Wrong type of item, must be JSONObject");
        var article = new Article();
        var jsonItem = (JSONObject) item;
        for (var soucre : mapper.keySet()) {
            var destination = mapper.get(soucre);
            var content = getFieldValue(jsonItem, destination);
            var setMethod = "set" + soucre.substring(0, 1).toUpperCase() + soucre.substring(1);
            var method = Article.class.getMethod(setMethod, String.class);
            method.invoke(article, content);
        }
        return article;
    }

    @Override
    public <T> List<Article> mapItemsToArticles(T items, HashMap<String, String> mapper) throws Exception {
        if (!(items instanceof JSONArray))
            throw new Exception("Wrong type of item, must be JSONObject");
        var listOfItems = (JSONArray) items;
        var articles = new ArrayList();
        for (int i = 0; i < listOfItems.length(); ++i) {
            var item = listOfItems.getJSONObject(i);
            var article = mapItemToArticle(item, mapper);
            articles.add(article);
        }
        return articles;
    }
}
