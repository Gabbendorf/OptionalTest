import domain.Member;
import domain.MemberFinder;
import domain.Members;
import ui.UI;

import java.util.List;
import java.util.Optional;

public class App {
    private final MemberFinder memberFinder;
    private final UI ui;
    private final Members members;

    public App(UI ui, Members members, MemberFinder memberFinder) {
        this.ui = ui;
        this.members = members;
        this.memberFinder = memberFinder;
    }

    public void lookFor(int memberId) {
        List<Member> allMembers = members.allMembers();

        Optional<Member> maybeMember = memberFinder.memberById(allMembers, memberId);

        maybeMember.ifPresentOrElse(
                ui::printMemberFullNameMessage,
                () -> ui.printNoMemberMessage(memberId)
        );
    }
}
