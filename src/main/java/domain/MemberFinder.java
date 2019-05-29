package domain;

import java.util.Optional;

public class MemberFinder {

    private final Members members;

    public MemberFinder(Members members) {
        this.members = members;
    }

    public Optional<Member> memberById(int memberId) {
        return members.allMembers().stream()
                .filter(member -> member.getId() == memberId)
                .findFirst();
    }
}
