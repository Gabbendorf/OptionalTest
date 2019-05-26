package domain;

import domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberFinder {

    public Optional<Member> memberById(List<Member> members, int memberId) {
        return members.stream()
                .filter(member -> member.getId() == memberId)
                .findFirst();
    }
}
