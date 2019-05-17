import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class MemberFinderTest {

    private final List<Member> members = new ArrayList<>(asList(new Member(1, "Homer", "Simpson")));

    @Test
    public void memberWithValidIdIsPresent() {
        MemberFinder memberFinder = new MemberFinder();

        Optional<Member> maybeMember = memberFinder.memberById(members, 1);

        assertTrue(maybeMember.isPresent());
    }

    @Test
    public void memberWithInvalidIdIsNotPresent() {
        MemberFinder memberFinder = new MemberFinder();

        Optional<Member> maybeMember = memberFinder.memberById(members, 2);

        assertFalse(maybeMember.isPresent());
    }
}
