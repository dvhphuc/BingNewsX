package service.mapper;

import model.CurrencyExchange;
import service.mapper.gettetpropvalue.GetterValueFactory;
import service.mapper.listconverter.ConverterFactory;
import service.mapper.listconverter.IListConvert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyExchangeMapperService implements IModelMapper<CurrencyExchange> {
    @Override
    public <TypeOfObject> CurrencyExchange mapObject(TypeOfObject object, HashMap<String, String> mapper) throws Exception {
        var mapperService = new GetterValueFactory <TypeOfObject>() {}.create(object);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        for (var entry : mapper.entrySet()) {
            String source = entry.getKey();
            String destination = entry.getValue();
            String content = mapperService.getPropValue(destination);
            String setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            Method method = CurrencyExchange.class.getMethod(setMethod, String.class);
            method.invoke(currencyExchange, content);
        }
        return currencyExchange;
    }

    @Override
    public <TypeOfObject> List<CurrencyExchange> mapObjects(TypeOfObject objects, HashMap<String, String> mapper) throws Exception {
        IListConvert<TypeOfObject> converter = new ConverterFactory<TypeOfObject>() {
        }.create(objects);
        List<TypeOfObject> convertedObjects = converter.convert(objects);
        var currenciesExchange = new ArrayList<CurrencyExchange>();
        for (TypeOfObject object : convertedObjects) {
            currenciesExchange.add(mapObject(object, mapper));
        }
        return currenciesExchange;
    }
}
