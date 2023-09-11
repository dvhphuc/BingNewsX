package org.example;

import configuration.Configuration;
import configuration.article.MapperConfig;
import configuration.topnews.EndpointConfig;
import service.*;
import service.factory.ServiceFactory;
import service.mapper.ArticleMapperService;

public class Main {
    public static void main(String[] args) throws Exception {
        var bns = new BingNewsService();
        System.out.println(bns.getSportInfo().size());


    }

}
