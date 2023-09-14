package orm;

import model.Article;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityMapperTest {

    @Test
    void getSelectAllSql() {
        var entityMapper = new EntityManager();
        var sql = entityMapper.getSelectAllSql(Article.class);
        assertEquals("SELECT * FROM Article", sql);
    }

    @Test
    void mapResultSetToList() throws Exception {
        var entityMapper = new EntityManager();
        var sqlQuery = "SELECT * FROM Article";
        var dbConnection = new DbConnection("jdbc:sqlserver://localhost:1433;database=BingNews;integratedSecurity=true;trustServerCertificate=true");
        var connection = dbConnection.getConnection();
        var resultSet = connection.prepareStatement(sqlQuery).executeQuery();
        var results = entityMapper.mapResultSetToList(resultSet, Article.class);
        assert results.size() > 0;
    }

    @Test
    void testGetInsertSql() throws Exception {
        var entityMapper = new EntityManager();
        var sql = entityMapper.getInsertSql(Article.class);
        System.out.println(sql);
    }

    @Test
    void testUpdateSql() throws Exception {
        var entityMapper = new EntityManager();
        var sql = entityMapper.getUpdateSql(Article.class);
        System.out.println(sql);
    }
}