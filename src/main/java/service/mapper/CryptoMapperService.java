package service.mapper;

import model.Crypto;
import service.mapper.gettetpropvalue.GetterValueFactory;
import service.mapper.gettetpropvalue.IGetPropertyValue;
import service.mapper.listconverter.ConverterFactory;
import service.mapper.listconverter.IListConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CryptoMapperService implements IModelMapper<Crypto> {
    @Override
    public <TypeOfObject> Crypto mapObject(TypeOfObject object, HashMap<String, String> mapper) throws Exception {
        var getterPropValue = new GetterValueFactory<TypeOfObject>() {}.create(object);
        var crypto = new Crypto();
        for (var entry : mapper.entrySet()) {
            var source = entry.getKey();
            var destination = entry.getValue();
            var content = getterPropValue.getPropValue(destination);
            var setMethod = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
            var method = Crypto.class.getMethod(setMethod, String.class);
            method.invoke(crypto, content);
        }
        return crypto;
    }

    @Override
    public <TypeOfObject> List<Crypto> mapObjects(TypeOfObject objects, HashMap<String, String> mapper) throws Exception {
        IListConvert<TypeOfObject> converter = new ConverterFactory<TypeOfObject>() {}.create(objects);
        List<TypeOfObject> convertedList = converter.convert(objects);
        var result = new ArrayList<Crypto>();
        for (var object : convertedList) {
            result.add(mapObject(object, mapper));
        }
        return result;
    }
}
