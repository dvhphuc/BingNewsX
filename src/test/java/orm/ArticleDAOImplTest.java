package orm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleDAOImplTest {

    @Test
    void testGetArticlesFromDb() {
        var articleDAO = new ArticleDAOImpl();
        var articles = articleDAO.getAll();
        System.out.println(articles.get(0).getTitle());
        assert articles.size() > 0;
    }
}


