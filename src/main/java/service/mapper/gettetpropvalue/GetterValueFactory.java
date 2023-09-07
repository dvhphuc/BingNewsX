package service.mapper.gettetpropvalue;

import org.json.JSONObject;
import org.w3c.dom.Node;

public abstract class GetterValueFactory<T> {
    public IGetPropertyValue create(T o) throws Exception {
        if (o instanceof JSONObject) {
            return new JsonValueGetter((JSONObject) o);
        } else if (o instanceof Node) {
            return new NodeValueGetter((Node) o);
        } else {
            throw new Exception("Invalid object type");
        }
    }
}
