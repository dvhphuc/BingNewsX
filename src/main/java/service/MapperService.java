package service;

import configuration.MapperConfig;
import configuration.NewsConfig;
import model.Article;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class MapperService {
    public MapperService(String cfg) {
        BingNewsService.readMapperConfig(new MapperConfig(cfg));
    }

    public static List<Article> mapToArticles(NodeList items, MapperConfig mapperConfig, String channelId) throws Exception {
        var articles = new ArrayList<Article>();

        var channel = mapperConfig.getChannelById(channelId);
        var channelMapSrcDesmapSrcDes = channel.getMapSrcDes();

        // For each item in the RSS feed, map it to an Article object
//        for (var item : items) {
//            des = channelMapSrcDesmapSrcDes.des;
//            src = channelMapSrcDesmapSrcDes.scr;
//            var atc = new Article();
//            atc.des = item.scr;
//            articles.add(atc);
        //}
        return articles;
    }
}
