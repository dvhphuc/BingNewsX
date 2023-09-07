package service.mapper.listconverter;

import org.json.JSONArray;
import org.w3c.dom.NodeList;
import service.mapper.listconverter.IListConvert;
import service.mapper.listconverter.JSONArrayConverter;
import service.mapper.listconverter.NodeListConverter;

public abstract class ConverterFactory<T> {
    public IListConvert<T> create(T o) throws Exception {
        if (o instanceof JSONArray)
            return (IListConvert<T>) new JSONArrayConverter();
        if (o instanceof NodeList)
            return (IListConvert<T>) new NodeListConverter();
        throw new Exception("Invalid object type");
    }
}
