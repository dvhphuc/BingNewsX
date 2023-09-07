package service.mapper;

import configuration.MatchResult;

import java.util.HashMap;
import java.util.List;

public interface IMapperObjectToSportInfo {
    public <T> String getFieldValue(T item, String field) throws Exception;
    public <T> MatchResult mapItemToMatchResult(T item, HashMap<String, String> mapper) throws Exception;
    public <T> List<MatchResult> mapItemsToListResult(T item, HashMap<String, String> mapper) throws Exception;
}
