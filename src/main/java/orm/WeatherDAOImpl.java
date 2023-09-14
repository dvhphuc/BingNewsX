package orm;

import configuration.WeatherInfo;
import model.Weather;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAOImpl implements DAO<WeatherInfo> {
    @Override
    public void save(WeatherInfo object) throws SQLException {
        String query = String.format("INSERT INTO weather (CITY, COUNTRY, TEMPERATURE, WEATHER) VALUES"
                        + "('%s', '%s', '%s', '%s')",
                        object.getCity(),
                        object.getCountry(),
                        object.getTemperature(),
                        object.getWeather());

        try (var connection = DriverManager.getConnection(jdbcUrl)) {
            var statement = connection.createStatement();
            statement.executeUpdate(query);
        }
    }

    @Override
    public void update(WeatherInfo object) {

    }

    @Override
    public void delete(WeatherInfo object) {

    }

    @Override
    public WeatherInfo get(int id) {
        return null;
    }

    @Override
    public List<WeatherInfo> getAll() {
        String sqlQuery = "SELECT * FROM weather";
        var weatherInfos = new ArrayList<Weather>();
        try (var connection = DriverManager.getConnection(jdbcUrl)) {
            var preparedStatement = connection.prepareStatement(sqlQuery);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var city = resultSet.getString("CITY");
                var country = resultSet.getString("COUNTRY");
                var temperature = resultSet.getString("TEMPERATURE");
                var weather = resultSet.getString("WEATHER");
                var weatherInfo = new Weather(city, country, temperature, weather);
                weatherInfos.add(weatherInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
