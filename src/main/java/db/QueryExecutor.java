package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {
    private final Statement statement;

    public QueryExecutor(Statement statement) {
        this.statement = statement;
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new InvalidQueryException(e);
        }
        return resultSet;
    }
}
