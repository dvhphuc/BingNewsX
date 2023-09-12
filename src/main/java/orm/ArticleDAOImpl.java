package orm;

import model.Article;

import java.sql.*;
import java.util.List;

public class ArticleDAOImpl implements DAO<Article>{
    private List<Article> articles;
    @Override
    public void save(Article object) {

    }

    @Override
    public void update(Article object) {

    }

    @Override
    public void delete(Article object) {

    }

    @Override
    public Article get(int id) {
        return null;
    }

    @Override
    public List<Article> getAll() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            String sqlQuery = "SELECT * FROM article";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String guid = resultSet.getString("guid");
                String title = resultSet.getString("title");
                String imageUrl = resultSet.getString("imageUrl");
                String channelId = resultSet.getString("channelId");
                String pubDate = resultSet.getString("pubDate");
                String sourceLink = resultSet.getString("sourceLink");
                // Add the retrieved student to the list
                articles.add(new Article(guid, title, imageUrl, channelId, pubDate, sourceLink));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
}
