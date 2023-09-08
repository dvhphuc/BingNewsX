package service.mapper;

import configuration.WeatherInfo;
import model.Weather;
import service.mapper.gettetpropvalue.GetterValueFactory;
import service.mapper.listconverter.ConverterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeatherMapperService implements IModelMapper<Weather> {

    @Override
    public <TypeOfObject> Weather mapObject(TypeOfObject object, HashMap<String, String> mapper) throws Exception {
        var getterPropValue = new GetterValueFactory(){}.create(object);
        var WeatherInfo = new Weather();
        for (var entry : mapper.entrySet()) {
            var source = entry.getKey();
            var destination = entry.getValue();
            var content = getterPropValue.getPropValue(destination);
            var methodSetName = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            var methodSet = Weather.class.getMethod(methodSetName, String.class);
            methodSet.invoke(WeatherInfo, content);
        }
        return WeatherInfo;
    }

    public List<Weather> setLocation(List<Weather> WeatherInfos, String location) {
        for (var WeatherInfo : WeatherInfos) {
            WeatherInfo.setLocation(location);
        }
        return WeatherInfos;
    }

    @Override
    public <TypeOfObject> List<Weather> mapObjects(TypeOfObject objects, HashMap<String, String> mapper) throws Exception {
        var converter = new ConverterFactory<TypeOfObject>(){}.create(objects);
        var listObjecsConverted = converter.convert(objects);

        var WeatherInfos = new ArrayList<Weather>();

        for (var objectConverted : listObjecsConverted) {
            var WeatherInfo = mapObject(objectConverted, mapper);
            WeatherInfos.add(WeatherInfo);
        }
        return WeatherInfos;
    }
}
