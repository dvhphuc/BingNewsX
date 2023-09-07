package service.mapper;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class RssValueGetter implements IGetPropertyValue {
    private Node node;
    public RssValueGetter(Node node) {
        this.node = node;
    }
    @Override
    public String getPropValue(String prop) throws Exception {
        // prop = "tag.subtag.subtag#attr"
        if (!prop.contains(".")) {
            Element eNode = (Element) node;
            return eNode.getElementsByTagName(prop).item(0).getTextContent();
        }
        return null;
    }
}