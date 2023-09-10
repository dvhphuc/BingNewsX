package service.factory;

import service.ArticleService;
import service.IService;

public abstract class ServiceFactory {
    public static IService create(String serviceType) {
        if (serviceType.equals("Article")) return new ArticleService();
        //if (serviceType.equals("mapperchannel")) return new MapperService();
        return null;
    }
}
