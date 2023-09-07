package service.mapper.listconverter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONArrayConverter implements IListConvert<JSONArray>{
    @Override
    public List<JSONObject> convert(JSONArray objects) throws Exception {
        List<JSONObject> convertedList = new ArrayList<>();
        for (int i = 0; i < objects.length(); i++) {
            convertedList.add(objects.getJSONObject(i));
        }
        return convertedList;
    }
}
