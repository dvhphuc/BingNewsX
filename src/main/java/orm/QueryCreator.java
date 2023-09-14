package orm;

public class QueryCreator {
    public static String createSelectQuery(String tableName, String[] columns) {
        StringBuilder query = new StringBuilder("SELECT ");
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]);
            if (i != columns.length - 1) {
                query.append(", ");
            }
        }
        query.append(" FROM ");
        query.append(tableName);
        return query.toString();
    }


}
