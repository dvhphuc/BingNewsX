package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/orm";
    private Statement statement;
    public Database() throws Exception {
        Connection connection = DriverManager.getConnection(URL, "root", "root");
        statement = connection.createStatement();
    }

}
