package service.mapper;

import model.Stock;
import service.mapper.gettetpropvalue.GetterValueFactory;
import service.mapper.listconverter.ConverterFactory;

import java.util.HashMap;
import java.util.List;

public class StockMapperService implements IModelMapper<Stock> {
    @Override
    public <R> Stock mapObject(R object, HashMap<String, String> mapper) throws Exception {
        var getterPropValue = new GetterValueFactory<Object>() {}.create(object);
        var stock = new Stock();
        for (var entry : mapper.entrySet()) {
            var source = entry.getKey();
            var destination = entry.getValue();
            var content = getterPropValue.getPropValue(destination);
            var setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            var method = Stock.class.getMethod(setMethod, String.class);
            method.invoke(stock, content);
        }
        return stock;
    }

    @Override
    public <R> List<Stock> mapObjects(R objects, HashMap<String, String> mapper) throws Exception {
        var result = new java.util.ArrayList<Stock>();
        var converter = new ConverterFactory<R>() {}.create(objects);
        var convertedList = converter.convert(objects);
        for (var object : convertedList) {
            result.add(mapObject(object, mapper));
        }
        return result;
    }
}
