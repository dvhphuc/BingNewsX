package service.factory;

import configuration.Configuration;
import configuration.NewsConfig;
import service.*;

public abstract class ServiceFactory {

    public static IService create(String serviceType) throws Exception {

        if (serviceType.equals("Article")) return new ArticleService();
        if (serviceType.equals("TopNews")) return new TopNewsService();
        if (serviceType.equals("Weather")) return new WeatherService();
        if (serviceType.equals("Sport")) return new SportService();
        return null;
    }
}
