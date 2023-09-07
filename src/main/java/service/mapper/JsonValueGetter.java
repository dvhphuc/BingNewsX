package service.mapper;

import org.json.JSONObject;

import java.util.List;

public class JsonValueGetter implements IGetPropertyValue {
    private JSONObject jsonObject;

    public JsonValueGetter(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String getPropValue(String prop) throws Exception {
        if (!prop.contains("."))
            return jsonObject.get(prop).toString();
        List<String> listProp = List.of(prop.split("\\."));
        String lastProp = listProp.get(listProp.size() - 1);
        listProp = listProp.subList(0, listProp.size() - 1);

        var tmp = jsonObject;
        for (String subProp : listProp) {
            tmp = tmp.getJSONObject(subProp);
        }
        return tmp.get(lastProp).toString();
    }
}