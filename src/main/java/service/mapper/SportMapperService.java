// SportMapperService.java and SportMapperServiceTest.java ends here
// This service is used map object to MatchResult model

package service.mapper;

import configuration.MatchResult;
import org.json.JSONArray;
import org.json.JSONObject;
import service.mapper.gettetpropvalue.GetterValueFactory;
import service.mapper.gettetpropvalue.IGetPropertyValue;
import service.mapper.gettetpropvalue.JsonValueGetter;
import service.mapper.listconverter.ConverterFactory;
import service.mapper.listconverter.IListConvert;
import service.mapper.listconverter.JSONArrayConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Map Another Object To MatchResult Model
public class SportMapperService implements IModelMapper<MatchResult> {
    @Override
    public <T> MatchResult mapObject(T object, HashMap<String, String> mapper) throws Exception {
        var getterPropValue = new GetterValueFactory<T>() {}.create(object);
        var matchResult = new MatchResult();
        for (var entry : mapper.entrySet()) {
            var source = entry.getKey();
            var destination = entry.getValue();
            var content = getterPropValue.getPropValue(destination);
            var setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            var method = MatchResult.class.getMethod(setMethod, String.class);
            method.invoke(matchResult, content);
        }
        return matchResult;
    }

    @Override
    public <T> List<MatchResult> mapObjects(T objects, HashMap<String, String> mapper) throws Exception {
        IListConvert<T> converter = new ConverterFactory<T>() {}.create(objects);
        List<JSONObject> convertedList = converter.convert(objects);
        var result = new ArrayList<MatchResult>();
        for (var object : convertedList) {
            result.add(mapObject(object, mapper));
        }
        return result;
    }
}
