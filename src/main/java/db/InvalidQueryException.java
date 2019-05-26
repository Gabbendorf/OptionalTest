package db;

import java.sql.SQLException;

public class InvalidQueryException extends RuntimeException {

    public InvalidQueryException(SQLException e) {
        super("Sql query not valid: " + e.getCause());
    }
}
