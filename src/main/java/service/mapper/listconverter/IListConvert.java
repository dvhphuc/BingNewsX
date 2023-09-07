package service.mapper.listconverter;

import java.util.List;

public interface IListConvert<T> {
    <R> List<R> convert(T objects) throws Exception;
}
