package db;

import domain.Member;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MembersFromDBTest {
    private final String portForTestsDb = "8085";

    @Test
    public void getsMembersFromMembersTableInTestDb() {
        MembersFromDB membersFromDB = new MembersFromDB(portForTestsDb, "root", "pwd");

        List<Member> members = membersFromDB.allMembers();

        Member member = members.get(0);
        assertEquals("Jon", member.getName());
        assertEquals("Snow", member.getSurname());
        assertEquals(1, members.size());
    }

    @Test(expected = ConnectionFailureException.class)
    public void throwsConnectionFailureExceptionForInvalidConnectionAttempt() {
        String invalidPassword = "";
        MembersFromDB membersFromDB = new MembersFromDB(portForTestsDb, "root", invalidPassword);

        membersFromDB.allMembers();
    }
}
