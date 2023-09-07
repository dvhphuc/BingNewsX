package service.mapper;

import configuration.MatchResult;
import model.Article;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonMapperObjectToSportInfo implements IMapperObjectToSportInfo {
    @Override
    public <T> String getFieldValue(T item, String field) throws Exception {
        return null;
    }

    @Override
    public <T> MatchResult mapItemToMatchResult(T item, HashMap<String, String> mapper) throws Exception {
        if (!(item instanceof JSONObject))
            throw new Exception("Invalid Object Type");

        var mathResult = new MatchResult();
        var jsonItem = (JSONObject) item;

        for (var soucre : mapper.keySet()) {
            var destination = mapper.get(soucre);
            var content = getFieldValue(jsonItem, destination);
            var setMethod = "set" + soucre.substring(0, 1).toUpperCase() + soucre.substring(1);
            var method = Article.class.getMethod(setMethod, String.class);
            method.invoke(mathResult, content);
        }
        return mathResult;
    }

    @Override
    public <T> List<MatchResult> mapItemsToListResult(T items, HashMap<String, String> mapper) throws Exception {
        if (!(items instanceof JSONArray))
            throw new Exception("Invalid Object Type");
        var listResults = new ArrayList<MatchResult>();

        var jsonArrayItems = (JSONArray) items;
        for (int i=0; i<((JSONArray) items).length(); ++i) {
            var item = ((JSONArray) items).getJSONObject(i);
            var mappedItem =  mapItemToMatchResult(item, mapper);
            listResults.add(mappedItem);
        }

        return listResults;
    }
}


