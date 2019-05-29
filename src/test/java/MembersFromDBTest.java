import db.ConnectionFailureException;
import db.MembersFromDB;
import domain.Member;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MembersFromDBTest {
    private static String URL = "jdbc:mysql://localhost:8085/test_db";

    @Test
    public void getsMembersFromMembersTableInTestDb() {
        MembersFromDB membersFromDB = new MembersFromDB(URL, "root", Optional.of("pwd"), "members");

        List<Member> members = membersFromDB.allMembers();

        Member member = members.get(0);
        assertEquals("Jon", member.getName());
        assertEquals("Snow", member.getSurname());
        assertEquals(1, members.size());
    }

    @Test(expected = ConnectionFailureException.class)
    public void throwsConnectionFailureExceptionForInvalidConnectionAttempt() {
        Optional<String> invalidPassword = Optional.empty();
        MembersFromDB membersFromDB = new MembersFromDB(URL, "root", invalidPassword, "members");

        membersFromDB.allMembers();
    }
}
