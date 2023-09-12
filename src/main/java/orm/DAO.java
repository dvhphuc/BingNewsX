package orm;

import java.util.List;

public interface DAO<T>{
    static final String jdbcUrl = "jdbc:mysql://localhost:3306/orm";
    public void save(T object);
    public void update(T object);
    public void delete(T object);
    public T get(int id);
    public List<T> getAll();
}
