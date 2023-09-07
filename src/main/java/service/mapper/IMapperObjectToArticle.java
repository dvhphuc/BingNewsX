package service.mapper;

import model.Article;

import java.util.HashMap;
import java.util.List;

public interface IMapperObjectToArticle {
    public <T> String getFieldValue(T item, String field) throws Exception;
    public <T> Article mapItemToArticle(T item, HashMap<String, String> mapper) throws Exception;
    public <T> List<Article> mapItemsToArticles(T items, HashMap<String, String>  mapper) throws Exception;
}
