import java.sql.SQLException;

public class ConnectionFailureException extends RuntimeException {

    public ConnectionFailureException(SQLException e) {
        super("Something went wrong while trying to connect to the database: ", e.getCause());
    }
}
