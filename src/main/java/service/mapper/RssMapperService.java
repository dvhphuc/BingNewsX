package service.mapper;

import model.Article;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import service.mapper.IMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RssMapperService implements IMapper {

    @Override
    public <T> String getFieldValue(T item, String destination) throws Exception {
        if (!(item instanceof Node))
            throw new Exception("Wrong type of item, must be Node");
        var nodeItem = (Node) item;

        var attributeOfLastTag = "";
        if (destination.contains("#")) {
            attributeOfLastTag = destination.split("#")[1];
            destination = destination.split("#")[0];
        }

        var tagsList = destination.split("\\.");

        for (var tag : tagsList) {
            if (tag.contains("#")) {
                attributeOfLastTag = tag.split("#")[1];
                tag = tag.split("#")[0];
            }
            nodeItem = ((Element) nodeItem).getElementsByTagName(tag).item(0);
        }

        if (attributeOfLastTag != "")
            return ((Element) nodeItem).getAttribute(attributeOfLastTag);
        return nodeItem.getTextContent();
    }
    @Override
    public <T> Article mapItemToArticle(T item, HashMap<String, String> mapper) throws Exception {
        if (!(item instanceof Node))
            throw new Exception("Wrong type of item, must be Node");
        var article = new Article();
        var nodeItem = (Node) item;
        for (var soucre : mapper.keySet()) {
            var destination = mapper.get(soucre);
            var content = getFieldValue(nodeItem, destination);
            var setMethod = "set" + soucre.substring(0, 1).toUpperCase() + soucre.substring(1);
            var method = Article.class.getMethod(setMethod, String.class);
            method.invoke(article, content);
        }
        return article;
    }

    @Override
    public <T> List<Article> mapItemsToArticles(T items, HashMap<String, String> mapper) throws Exception {
        if (!(items instanceof NodeList))
            throw new Exception("Wrong type of item, must be Node");

        var articles = new ArrayList<Article>();
        NodeList itemsNodeList = (NodeList) items;
        for (int i = 0; i < itemsNodeList.getLength(); ++i) {
            var article = mapItemToArticle(itemsNodeList.item(i), mapper);
            articles.add(article);
        }
        return articles;
    }
}
