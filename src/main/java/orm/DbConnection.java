package orm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private String connectionUrl;
    public DbConnection(String _connectionUrl) throws Exception {
        this.connectionUrl = _connectionUrl;
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(this.connectionUrl);
    }
}
