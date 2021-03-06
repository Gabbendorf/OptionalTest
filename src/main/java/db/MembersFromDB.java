package db;

import domain.Member;
import domain.Members;

import java.sql.*;
import java.util.List;

public class MembersFromDB implements Members {
    private final Connection connection;
    private final MembersMapper membersMapper;
    private final String query;
    private final String url;

    public MembersFromDB(String port, String user, String password) {
        this.url = "jdbc:mysql://localhost:" + port + "/optional_db";
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ConnectionFailureException(e);
        }
        this.membersMapper = new MembersMapper();
        this.query = "SELECT member_id, name, surname FROM members";
    }

    @Override
    public List<Member> allMembers() {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new ConnectionFailureException(e);
        }
        QueryExecutor queryExecutor = new QueryExecutor(statement);
        ResultSet resultSet = queryExecutor.executeQuery(query);
        return membersMapper.membersFrom(resultSet);
    }
}
