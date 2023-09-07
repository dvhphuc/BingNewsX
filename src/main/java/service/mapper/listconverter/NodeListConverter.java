package service.mapper.listconverter;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class NodeListConverter implements IListConvert<NodeList>{
    @Override
    public List<Node> convert(NodeList objects) throws Exception {
        List<Node> convertedList = new java.util.ArrayList<>();
        for (int i = 0; i < objects.getLength(); i++) {
            convertedList.add(objects.item(i));
        }
        return convertedList;
    }
}
