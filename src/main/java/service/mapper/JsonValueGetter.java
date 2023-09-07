package service.mapper;

import org.json.JSONObject;

public class JsonValueGetter implements IGetPropertyValue {
    private JSONObject jsonObject;

    public JsonValueGetter(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String getPropValue(String prop) throws Exception {
//            List<String> props = List.of(prop.split("\\."));
//            //String lastProp = props.get(props.size() - 1);
//            //props.remove(props.size() - 1);
//
//            for (String subProp : props) {
//                jsonObject = jsonObject.getJSONObject(subProp);
//            }

        if (!prop.contains("\\.")) {
            return jsonObject.get(prop).toString();
        }

        return null;
    }
}