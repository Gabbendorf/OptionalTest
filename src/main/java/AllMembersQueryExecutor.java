import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllMembersQueryExecutor {
    private final Statement statement;

    public AllMembersQueryExecutor(Statement statement) {
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
