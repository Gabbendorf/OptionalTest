package db;

import domain.Member;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MembersMapperTest {
    private final static MembersMapper membersMapper = new MembersMapper();

    @Test
    public void createsListOfMembersFromResultSet() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("name")).thenReturn("Jon");
        when(resultSet.getString("surname")).thenReturn("Snow");
        when(resultSet.getInt("member_id")).thenReturn(1);

        List<Member> members = membersMapper.membersFrom(resultSet);

        Member firstMember = members.get(0);
        assertEquals(1, firstMember.getId());
        assertEquals("Jon", firstMember.getName());
        assertEquals("Snow", firstMember.getSurname());
        assertEquals(1, members.size());
    }

    @Test
    public void createsEmptyListOfMembersForEmptyResultSet() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(false);

        List<Member> members = membersMapper.membersFrom(resultSet);

        assertTrue(members.isEmpty());
    }

    @Test
    public void createsEmptyListOfMembersForNullResultSet() {
        List<Member> members = membersMapper.membersFrom(null);

        assertTrue(members.isEmpty());
    }
}
