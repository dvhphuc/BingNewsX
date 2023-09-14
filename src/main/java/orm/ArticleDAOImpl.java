package orm;

import model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements DAO<Article>{
    private List<Article> articles = new ArrayList<Article>();
    @Override
    public void save(Article atc) throws SQLException {
        String query = String.format("INSERT INTO articles (GUID, TITLE, IMGURL, PUBDATE, SOURCELINK) VALUES"
                        + "('%s', '%s', '%s', '%s', '%s')",
                        atc.getGuid(),
                        atc.getTitle(),
                        atc.getImgUrl(),
                        atc.getPubDate(),
                        atc.getSourceLink());

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }
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
            String sqlQuery = "SELECT * FROM articles";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String guid = resultSet.getString("GUID");
                String title = resultSet.getString("TITLE");
                String imageUrl = resultSet.getString("IMGURL");
                String pubDate = resultSet.getString("PUBDATE");
                String sourceLink = resultSet.getString("SOURCELINK");
                // Add the retrieved student to the list
                articles.add(new Article(guid, title, imageUrl, "vnexpress", pubDate, sourceLink));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
}
