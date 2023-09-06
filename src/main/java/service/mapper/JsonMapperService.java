package service.mapper;

import configuration.MatchResult;
import model.Article;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonMapperService implements IMapper {
    @Override
    public <T> String getFieldValue(T item, String field) throws Exception {
        if (!(item instanceof JSONObject jsonItem))
            throw new IllegalArgumentException("Wrong type of item, must be JSONObject");
        return jsonItem.getString(field);
    }
    @Override
    public <T> Article mapItemToArticle(T item, HashMap<String, String> mapper) throws Exception {
        if (!(item instanceof JSONObject jsonItem))
            throw new IllegalArgumentException("Wrong type of item, must be JSONObject");

        Article article = new Article();

        for (var entry : mapper.entrySet()) {
            var soucre = entry.getKey();
            var destination = entry.getValue();
            var content = getFieldValue(jsonItem, destination);
            var setMethod = "set" + soucre.substring(0, 1).toUpperCase() + soucre.substring(1);
            var method = Article.class.getMethod(setMethod, String.class);
            method.invoke(article, content);
        }

        return article;
    }

    @Override
    public <T> List<Article> mapItemsToArticles(T items, HashMap<String, String> mapper) throws Exception {
        if (!(items instanceof JSONArray listOfItems))
            throw new IllegalArgumentException("Wrong type of item, must be JSONObject");

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < listOfItems.length(); ++i) {
            var item = listOfItems.getJSONObject(i);
            var article = mapItemToArticle(item, mapper);
            articles.add(article);
        }

        return articles;
    }

    public String getPropertiesValue(JSONObject object, String properties) throws Exception {
        List<String> propertiesList = List.of(properties.split("\\."));
        var result = object;

        var lastProperty = propertiesList.get(propertiesList.size() - 1);
        propertiesList = propertiesList.subList(0, propertiesList.size() - 1);

        for (var property : propertiesList) {
            result = result.getJSONObject(property);
        }
        return result.get(lastProperty).toString();
    }
    public MatchResult mapJsonResultToMatchResult(JSONObject matchResult, HashMap<String, String> mapper) throws Exception {
        var result = new MatchResult();
        for (var entry : mapper.entrySet()) {
            var soucre = entry.getKey();
            var destination = entry.getValue();
            var content = getPropertiesValue(matchResult, destination);
            var setMethod = "set" + soucre.substring(0, 1).toUpperCase() + soucre.substring(1);
            var method = MatchResult.class.getMethod(setMethod, String.class);
            method.invoke(result, content);
        }
        return result;
    }

    public List<MatchResult> mapJsonResultsToMatchResults(JSONArray matchResults, HashMap<String, String> mapper) throws Exception {
        List<MatchResult> results = new ArrayList<>();
        for (int i = 0; i < matchResults.length(); ++i) {
            var matchResult = matchResults.getJSONObject(i);
            var result = mapJsonResultToMatchResult(matchResult, mapper);
            results.add(result);
        }
        return results;
    }
}



