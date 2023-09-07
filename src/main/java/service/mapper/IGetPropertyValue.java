package service.mapper;

public interface IGetPropertyValue {
    String getPropValue(String prop) throws Exception; //prop = "tag.subtag.subtag#attr"
}