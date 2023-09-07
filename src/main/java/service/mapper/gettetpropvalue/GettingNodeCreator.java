package service.mapper.gettetpropvalue;

import org.w3c.dom.Node;

public class GettingNodeCreator extends GetterValueFactory<Node> {
    @Override
    public IGetPropertyValue create(Node object) throws Exception {
        return new NodeValueGetter(object);
    }
}
