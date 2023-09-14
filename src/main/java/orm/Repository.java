package orm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T> {
    private DbConnection dbConnection;
    private EntityManager entityManager;
    private Class<T> clazz;

    public Repository(DbConnection _db, EntityManager _entityMapper, Class<T> _clazz) {
        this.dbConnection = _db;
        this.entityManager = _entityMapper;
        this.clazz = _clazz;
    }

    public T find(Predicate<T> tPredicate) throws Exception {
        String sql = this.entityManager.getSelectAllSql(this.clazz);
        var connection = this.dbConnection.getConnection();
        var resultSet = connection.prepareStatement(sql).executeQuery();
        var results = this.entityManager.mapResultSetToList(resultSet, this.clazz);
        for (var result : results) {
            if (tPredicate.test(result)) {
                return result;
            }
        }
        return null;
    }

    public void save(T object) throws Exception {
        String sql = this.entityManager.getInsertSql(this.clazz);
        var preparedStatement = this.dbConnection.getConnection().prepareStatement(sql);
        var fields = this.clazz.getDeclaredFields();
        var fieldNames = new ArrayList<String>();
        for (var field : fields) {
            fieldNames.add(field.getName());
        }
        var index = 1;
        for (var field : fields) {
            var fieldName = field.getName();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); //Refactor this
            var getter = this.clazz.getMethod("get" + fieldName);
            var fieldValue = getter.invoke(object);
            preparedStatement.setObject(index, fieldValue);
            index++;
        }
        preparedStatement.execute();
    }

    public void update(T object) throws Exception {
        var updateQuery = this.entityManager.getUpdateSql(this.clazz);
        var preparedStatement = this.dbConnection.getConnection().prepareStatement(updateQuery);
        var fields = this.clazz.getDeclaredFields();
        var fieldNames = new ArrayList<String>();
        for (var field : fields) {
            fieldNames.add(field.getName());
        }
        var index = 1;
        var guid = "";
        for (var field : fields) {
            var fieldName = field.getName();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            var getter = this.clazz.getMethod("get" + fieldName);
            var fieldValue = getter.invoke(object);
            if (fieldName == "Guid") {
                guid = fieldValue.toString();
            }
            preparedStatement.setObject(index, fieldValue); //set value to ?
            index++;
        }
        preparedStatement.setObject(index, guid);
        preparedStatement.execute();
    }

    public void delete(T object) throws Exception {

    }

    public List<T> getAll() throws Exception {
        List<T> results = new ArrayList<T>();
        String sql = this.entityManager.getSelectAllSql(this.clazz);
        var connection = this.dbConnection.getConnection();
        var resultSet = connection.prepareStatement(sql).executeQuery();
        return this.entityManager.mapResultSetToList(resultSet, this.clazz);
    }
}
