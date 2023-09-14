package orm;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    public <T> List<T> mapResultSetToList(ResultSet resultSet, Class<T> clazz) throws Exception {
        var results = new ArrayList<T>();
        var fileds = clazz.getDeclaredFields();
        while (resultSet.next()) {
            var object = clazz.newInstance();
            for (var field : fileds) {
                var fieldName = field.getName();
                fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                var fieldValue = resultSet.getObject(fieldName);
                var setter = clazz.getMethod("set" + fieldName, field.getType());
                setter.invoke(object, fieldValue);
            }
            results.add(object);
        }
        return results;
    }

    public String getSelectAllSql(Class clazz) {
        return "SELECT * FROM " + clazz.getSimpleName();
    }
    public <T> String getInsertSql(Class<T> clazz) throws Exception {
        String sql = "INSERT INTO " + clazz.getSimpleName() + " (";
        var fields = clazz.getDeclaredFields();
        var fieldNames = new ArrayList<String>();
        for (var field : fields) {
            fieldNames.add(field.getName());
        }
        sql += String.join(", ", fieldNames);
        sql += ") VALUES (";
        var values = new ArrayList<String>();
        for (var field : fields) {
            values.add("?");
        }
        sql += String.join(", ", values);
        sql += ")";
        return sql;
    }

    public <T> String getUpdateSql(Class<T> clazz) {
        String sql = "UPDATE " + clazz.getSimpleName() + " SET ";
        var fields = clazz.getDeclaredFields();
        var fieldNames = new ArrayList<String>();
        for (var field : fields) {
            fieldNames.add(field.getName());
        }
        var values = new ArrayList<String>();
        for (var field : fields) {
            values.add(field.getName() + " = ?");
        }
        sql += String.join(", ", values);
        sql += " WHERE Guid = ?";
        return sql;
    }
}
