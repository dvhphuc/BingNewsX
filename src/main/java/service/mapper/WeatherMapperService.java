package service.mapper;

import configuration.WeatherInfo;
import model.Weather;

import java.util.HashMap;
import java.util.List;

public class WeatherMapperService implements IModelMapper<Weather> {

    @Override
    public <TypeOfObject> Weather mapObject(TypeOfObject object, HashMap<String, String> mapper) throws Exception {
        return null;
    }

    @Override
    public <TypeOfObject> List<Weather> mapObjects(TypeOfObject objects, HashMap<String, String> mapper) throws Exception {
        return null;
    }
}
