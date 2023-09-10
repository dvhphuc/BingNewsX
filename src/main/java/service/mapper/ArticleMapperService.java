//Article Mapper is used to map any type object (JSON,XML,RSS)  to Article object
package service.mapper;

import model.Article;
import service.mapper.gettetpropvalue.GetterValueFactory;
import service.mapper.gettetpropvalue.IGetPropertyValue;
import service.mapper.listconverter.ConverterFactory;
import service.mapper.listconverter.IListConvert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArticleMapperService implements IModelMapper<Article> {

    public ArticleMapperService() {
    }

    // propValueService is used to get value of a property of an object, ex: propValueService.getPropValue("title")
    @Override
    public <T> Article mapObject(T object, HashMap<String, String> mapper) throws Exception {
        var getterPropValue = new GetterValueFactory<T>() {}.create(object);

        Article article = new Article();
        for (var entry : mapper.entrySet()) {
            String source = entry.getKey(); // title, link, ...
            String destination = entry.getValue(); // title, source, img.url# ...

            String content = getterPropValue.getPropValue(destination);

            Method setMethod = Article.class
                    .getMethod("set"
                            + source.substring(0, 1).toUpperCase() // capitalize first letter (setTitle, setLink, ...)
                            + source.substring(1), String.class);

            setMethod.invoke(article, content);
        }
        return article;
    }

    @Override
    // Type of objects must be JSONArray or NodeList,... (multiple objects need to wrap into a list)
    // Convertor will convert JSONArray to List<JSONObject> or NodeList to List<Node>,...
    public <T> List<Article> mapObjects(T objects, HashMap<String, String> mapper) throws Exception {
        var articles = new ArrayList<Article>();
        IListConvert<T> converter = new ConverterFactory<T>() {}.create(objects); // Use factory to create a converter
        List<Object> convertedObjects = converter.convert(objects);
        for (Object object : convertedObjects) {
            articles.add(mapObject(object, mapper));
        }

        return articles;
    }

}