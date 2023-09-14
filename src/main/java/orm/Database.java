package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    static final String connectionUrl =
            "jdbc:sqlserver://DVHPHUC.BingNews.windows.net:1433;"
                    + "database=BingNews;"
                    + "user=dvhphuc\\20520@DVHPHUC;"
                    + "password=root;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;";
    private Statement statement;
    public Database() throws Exception {
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "root");
        statement = connection.createStatement();
    }

}
