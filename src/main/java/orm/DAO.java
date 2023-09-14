package orm;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T>{
    static final String jdbcUrl = "jdbc:sqlserver://localhost:1433;database=BingNews;integratedSecurity=true;trustServerCertificate=true";

    public void save(T object) throws SQLException;
    public void update(T object);
    public void delete(T object);
    public T get(int id);
    public List<T> getAll();
}
