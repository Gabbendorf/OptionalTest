import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberTest {

    @Test
    public void returnsFullName() {
        Member member = new Member(1, "Homer", "Simpson");

        assertEquals("Homer Simpson", member.getFullName());
    }
}
