import java.sql.*;
import java.util.List;
import java.util.Optional;

public class MembersRepository {
    private final Connection connection;
    private final MembersMapper membersMapper;

    public MembersRepository(String url, String root, Optional<String> maybePassword) {
        try {
            this.connection = DriverManager.getConnection(url, root, maybePassword.orElse(null));
        } catch (SQLException e) {
            throw new ConnectionFailureException(e);
        }
        this.membersMapper = new MembersMapper();
    }

    public List<Member> allMembers(String query) {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new ConnectionFailureException(e);
        }
        AllMembersQueryExecutor queryExecutor = new AllMembersQueryExecutor(statement);
        ResultSet resultSet = queryExecutor.executeQuery(query);
        return membersMapper.membersFrom(resultSet);
    }
}
