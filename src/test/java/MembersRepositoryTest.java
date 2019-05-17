import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MembersRepositoryTest {
    private static String URL = "jdbc:mysql://localhost:3306/test_db";
    private static String TEST_QUERY = "SELECT member_id, name, surname FROM test";

    @Test
    public void getsMembersFromTestDatabase() {

        MembersRepository membersRepository = new MembersRepository(URL, "root", Optional.empty());

        List<Member> members = membersRepository.allMembers(TEST_QUERY);

        Member member = members.get(0);
        assertEquals("Jon", member.getName());
        assertEquals("Snow", member.getSurname());
        assertEquals(1, members.size());
    }

    @Test(expected = ConnectionFailureException.class)
    public void throwsConnectionFailureExceptionWhenQueryIsInvalid() {
        MembersRepository membersRepository = new MembersRepository(URL, "", Optional.empty());

        membersRepository.allMembers(TEST_QUERY);
    }
}
