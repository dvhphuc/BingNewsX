package org.example;

import configuration.Configuration;
import configuration.article.MapperConfig;
import configuration.topnews.EndpointConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import service.*;
import service.factory.ServiceFactory;
import service.mapper.ArticleMapperService;
import service.mapper.CurrencyExchangeMapperService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        var financialConfig = cfg.getFinancialConfig().getCurExchanges();

        var cms = new CurrencyExchangeMapperService();
        var mapper = financialConfig.getMapper();
        var currentExchange = ReaderService.getCurrencyExchange(financialConfig);
    }
}
