package orm;

import model.Article;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    void testUpdate() throws Exception {
        var dbConnection = new DbConnection("jdbc:sqlserver://localhost:1433;" +
                "database=BingNews;" +
                "integratedSecurity=true;" +
                "trustServerCertificate=true");
        var articleRepo = new Repository<Article>(dbConnection, new EntityManager(), Article.class);
        //Find an article with the title "test"
        var article = articleRepo.find(a -> a.getTitle().equals("test"));
        article.setTitle("test2");
        articleRepo.update(article);
        var updatedArticle = articleRepo.find(a -> a.getTitle().equals("test2"));
        assertNotNull(updatedArticle);
    }

    @Test
    void testDelete() throws Exception {
    }

    @Test
    void getAll() throws Exception {
        var articles = new ArrayList();
        var dbConnection = new DbConnection("jdbc:sqlserver://localhost:1433;" +
                "database=BingNews;" +
                "integratedSecurity=true;" +
                "trustServerCertificate=true");
        var entityManager = new EntityManager();
        var articleRepository = new Repository<Article>(dbConnection, entityManager, Article.class);
        var results = articleRepository.getAll();
        assert results.size() > 0;
    }

    @Test
    void testInsert() throws Exception {
        var dbConnection = new DbConnection("jdbc:sqlserver://localhost:1433;database=BingNews;integratedSecurity=true;trustServerCertificate=true");
        var entityMapper = new EntityManager();
        var articleRepo = new Repository<Article>(dbConnection, entityMapper, Article.class);
        var before = articleRepo.getAll().size();
        var article = new Article("1", "test", "test", "test", "test", "test");
        articleRepo.save(article);
        var after = articleRepo.getAll().size();
        assertEquals(before + 1, after);
    }

    @Test
    void testFindByLambda() throws Exception {
        var dbConnection = new DbConnection("jdbc:sqlserver://localhost:1433;database=BingNews;integratedSecurity=true;trustServerCertificate=true");
        var entityMapper = new EntityManager();
        var articleRepo = new Repository<Article>(dbConnection, entityMapper, Article.class);
        var article = articleRepo.find(a -> a.getTitle().equals("test"));
        assertNotNull(article);
    }
}