package service.mapper.gettetpropvalue;

import org.json.JSONObject;

public class GettingJsonCreator extends GetterValueFactory<JSONObject> {
    @Override
    public IGetPropertyValue create(JSONObject object) throws Exception {
        return new JsonValueGetter(object);
    }
}
