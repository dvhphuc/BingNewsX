package orm;

import java.util.List;

public interface DAO<T>{
    public void save(T object);
    public void update(T object);
    public void delete(T object);
    public T get(int id);
    public List<T> getAll();
}
