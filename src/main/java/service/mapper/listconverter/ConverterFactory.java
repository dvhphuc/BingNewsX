package service.mapper.listconverter;

import org.json.JSONArray;
import org.w3c.dom.NodeList;

public abstract class ConverterFactory<T> {
    public IListConvert<T> create(T o) throws Exception {
        if (o instanceof JSONArray) {
            return (IListConvert<T>) new JSONArrayConverter();
        } else if (o instanceof NodeList) {
            return (IListConvert<T>) new NodeListConverter();
        } else {
            throw new Exception("Invalid object type");
        }
    }
}
