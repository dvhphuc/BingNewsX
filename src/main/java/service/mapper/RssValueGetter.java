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
    public String getPropValue(String props) throws Exception {
        // props = "tag.subtag.subtag#attr"
        if (!props.contains(".")) {
            Element eNode = (Element) node;
            return eNode.getElementsByTagName(props).item(0).getTextContent();
        }
        var lastProp = props.split(".")[props.split(".").length - 1];
        props = props.substring(0, props.length() - lastProp.length() - 1);

        var tmpNode = node;
        for (String subProp : props.split(".")) {
            Element eNode = (Element) tmpNode;
            tmpNode = eNode.getElementsByTagName(subProp).item(0);
        }

        if (!lastProp.contains("#"))
            return tmpNode.getTextContent();

        var attribute = props.split("#")[props.length() - 1];
        lastProp = lastProp.split("#")[0];
        Element eNode = (Element) tmpNode;
        return eNode.getElementsByTagName(lastProp).item(0).getAttributes().getNamedItem(attribute).getTextContent();
    }
}