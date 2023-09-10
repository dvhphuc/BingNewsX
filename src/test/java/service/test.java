package service;

import org.junit.jupiter.api.Test;
import service.factory.ServiceFactory;

public class test {
    @Test
    public void testFactory() {
        var service = ServiceFactory.create("Article");
        assert (service instanceof ArticleService);
    }
}
