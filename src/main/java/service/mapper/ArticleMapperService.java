package service.mapper;

import model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArticleMapperService implements IModelMapper<Article> {
    private IGetPropertyValue propValueService;

    public ArticleMapperService() {
    }

    @Override
    public <T> Article mapObject(T object, HashMap<String, String> mapper) throws Exception {

        if (object instanceof JSONObject) {
            propValueService = new JsonValueGetter((JSONObject) object);
        } else if (object instanceof Node) {
            propValueService = new RssValueGetter((Node) object);
        } else {
            throw new Exception("Invalid object type");
        }

        Article article = new Article();
        for (var entry : mapper.entrySet()) {
            String source = entry.getKey();
            String destination = entry.getValue();

            String content = propValueService.getPropValue(destination);

            Method setMethod = Article.class
                    .getMethod("set"
                            + source.substring(0, 1).toUpperCase() // capitalize first letter (setTitle, setLink, ...)
                            + source.substring(1), String.class);

            setMethod.invoke(article, content);
        }
        return article;
    }

    @Override
    // Type of objects must be JSONArray or NodeList,... (multiple objects need to wrap in a list)
    public <T> List<Article> mapObjects(T objects, HashMap<String, String> mapper) throws Exception {
        var articles = new ArrayList<Article>();
        if (objects instanceof JSONArray) {
            var jsonObjects = (JSONArray) objects;
            for (int i = 0; i < jsonObjects.length(); i++) {
                articles.add(mapObject(jsonObjects.get(i), mapper));
            }
        } else if (objects instanceof NodeList) {
            var nodes = (NodeList) objects;
            for (int i = 0; i < nodes.getLength(); i++) {
                articles.add(mapObject(nodes.item(i), mapper));
            }
        } else {
            throw new Exception("Invalid object type");
        }
        return articles;
    }

}