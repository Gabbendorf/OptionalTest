package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class MemberFinderTest {

    @Test
    public void memberWithValidIdIsPresent() {
        MemberFinder memberFinder = new MemberFinder(members);

        Optional<Member> maybeMember = memberFinder.memberById(1);

        assertTrue(maybeMember.isPresent());
    }

    @Test
    public void memberWithInvalidIdIsNotPresent() {
        MemberFinder memberFinder = new MemberFinder(members);

        Optional<Member> maybeMember = memberFinder.memberById(2);

        assertFalse(maybeMember.isPresent());
    }

    private final Members members = new Members() {
        @Override
        public List<Member> allMembers() {
            return new ArrayList<>(asList(new Member(1, "Homer", "Simpson")));
        }
    };
}
