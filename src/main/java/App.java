import domain.Member;
import domain.MemberFinder;

import java.util.List;
import java.util.Optional;

public class App {
    private final static String URL = "jdbc:mysql://localhost:3306/test_db";
    private final MembersFromDB membersFromDB = new MembersFromDB(URL, "root", Optional.empty(), "members");
    private final MemberFinder memberFinder = new MemberFinder();
    private final UI ui;

    public App(UI ui) {
        this.ui = ui;
    }

    public void lookFor(int memberId) {
        List<Member> members = membersFromDB.allMembers();

        Optional<Member> maybeMember = memberFinder.memberById(members, memberId);

        maybeMember.ifPresentOrElse(
                ui::printMemberFullNameMessage,
                () -> ui.printNoMemberMessage(memberId)
        );
    }
}
