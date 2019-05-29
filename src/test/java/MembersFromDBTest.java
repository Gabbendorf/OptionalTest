import db.ConnectionFailureException;
import db.MembersFromDB;
import domain.Member;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MembersFromDBTest {
    private static String URL = "jdbc:mysql://localhost:3306/test_db";

    @Test
    public void getsMembersFromTestDatabase() {
        MembersFromDB membersFromDB = new MembersFromDB(URL, "root", Optional.empty(), "test");

        List<Member> members = membersFromDB.allMembers();

        Member member = members.get(0);
        assertEquals("Jon", member.getName());
        assertEquals("Snow", member.getSurname());
        assertEquals(1, members.size());
    }

    @Test(expected = ConnectionFailureException.class)
    public void throwsConnectionFailureExceptionWhenQueryIsInvalid() {
        MembersFromDB membersFromDB = new MembersFromDB(URL, "", Optional.empty(), "test");

        membersFromDB.allMembers();
    }
}
