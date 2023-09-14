package orm;

import configuration.sport.SportInfo;
import model.MatchResult;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SportDAOImp implements DAO<MatchResult> {
    @Override
    public void save(MatchResult object) {

    }

    @Override
    public void update(MatchResult object) {

    }

    @Override
    public void delete(MatchResult object) {

    }

    @Override
    public MatchResult get(int id) {
        return null;
    }

    @Override
    public List<MatchResult> getAll() {
        try (var connection = DriverManager.getConnection(jdbcUrl)) {
            var preparedStatement = connection.prepareStatement("SELECT * FROM sport");
            var resultSet = preparedStatement.executeQuery();
            var matchResults = new ArrayList<MatchResult>();
            while (resultSet.next()) {
                var homeTeam = resultSet.getString("HOMETEAM");
                var awayTeam = resultSet.getString("AWAYTEAM");
                var homeScore = resultSet.getString("HOMESCORE");
                var awayScore = resultSet.getString("AWAYSCORE");
                var matchResult = new MatchResult();
                matchResults.add(matchResult);
            }
            return matchResults;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
