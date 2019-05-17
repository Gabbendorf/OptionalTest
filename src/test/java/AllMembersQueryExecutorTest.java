import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AllMembersQueryExecutorTest {

    @Test
    public void executesQuery() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        Statement statement = mock(Statement.class);
        when(statement.executeQuery(anyString())).thenReturn(resultSet);

        AllMembersQueryExecutor queryExecutor = new AllMembersQueryExecutor(statement);

        assertEquals(resultSet, queryExecutor.executeQuery(Query.MEMBERS_QUERY));
    }

    @Test(expected = InvalidQueryException.class)
    public void throwsSQLException() throws SQLException {
        String invalidQuery = "invalid query";

        Statement statement = mock(Statement.class);
        when(statement.executeQuery(anyString())).thenThrow(SQLException.class);

        AllMembersQueryExecutor queryExecutor = new AllMembersQueryExecutor(statement);

        queryExecutor.executeQuery(invalidQuery);
    }

}
