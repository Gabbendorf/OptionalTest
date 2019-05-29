package db;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryExecutorTest {

    @Test
    public void executesQuery() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        Statement statement = mock(Statement.class);
        when(statement.executeQuery(anyString())).thenReturn(resultSet);

        QueryExecutor queryExecutor = new QueryExecutor(statement);

        assertEquals(resultSet, queryExecutor.executeQuery("a query"));
    }

    @Test(expected = InvalidQueryException.class)
    public void throwsSQLException() throws SQLException {
        String invalidQuery = "invalid query";

        Statement statement = mock(Statement.class);
        when(statement.executeQuery(anyString())).thenThrow(SQLException.class);

        QueryExecutor queryExecutor = new QueryExecutor(statement);

        queryExecutor.executeQuery(invalidQuery);
    }
}
