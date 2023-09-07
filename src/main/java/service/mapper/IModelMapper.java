package service.mapper;

import java.util.HashMap;
import java.util.List;

// T is a generic type and must be Model class
interface IModelMapper<T> {
    <TypeOfObject> T mapObject(TypeOfObject object, HashMap<String, String> mapper) throws Exception;
    <TypeOfObject> List<T> mapObjects(TypeOfObject objects, HashMap<String, String> mapper) throws Exception;
    //If need to map multiple objects, wrap them in a list (JSONArray or NodeList, ...)
}