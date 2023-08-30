package service;

import configuration.MapperConfig;
import model.Article;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapperService {
    public MapperService() {
    }

    public static String getContentInTag(Node node, String tags) {
        for (var tag : tags.split("\\.")) {
                Element element = (Element) node;
                node = element.getElementsByTagName(tag).item(0);
        }
        var attribute = Arrays.stream(tags.split("#")).toList().get(tags.split("#").length - 1);
        return node.getAttributes().getNamedItem(attribute).getNodeValue();
    }

    public static List<Article> mapItemsToArticles(NodeList items, MapperConfig mapperConfig, String channelId) throws Exception {
        var articles = new ArrayList<Article>();
        var channel = mapperConfig.getChannelById(channelId);
        var channelMapSrcDesmapSrcDes = channel.getMapSrcDES();

        for (int i=0; i<items.getLength(); ++i) {
            var item = items.item(i);
            var atc = new Article();

            for (var key : channelMapSrcDesmapSrcDes.keySet()) {
                var value = channelMapSrcDesmapSrcDes.get(key);
                var content = getContentInTag(item, value);
                //atc.setField(key, content);
                System.out.println(key + ": " + content);
            }

        }
        return articles;
    }
}
