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
    private IGetPropertyValue propValueService;

    public ArticleMapperService() {
    }

    @Override
    public <T> Article mapObject(T object, HashMap<String, String> mapper) throws Exception {
        propValueService = new GetterValueFactory<T>() {}.create(object);

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
        IListConvert<T> converter = new ConverterFactory<T>() {}.create(objects); // Use factory to create a converter
        List<Object> convertedObjects = converter.convert(objects);
        for (Object object : convertedObjects) {
            articles.add(mapObject(object, mapper));
        }

        return articles;
    }

}