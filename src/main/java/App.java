import java.util.List;
import java.util.Optional;

public class App {
    private final static String URL = "jdbc:mysql://localhost:3306/test_db";
    private final MembersRepository membersRepository = new MembersRepository(URL, "root", Optional.empty());
    private final MemberFinder memberFinder = new MemberFinder();
    private final UI ui;

    public App(UI ui) {
        this.ui = ui;
    }

    public void lookFor(int memberId) {
        List<Member> members = membersRepository.allMembers(Query.MEMBERS_QUERY);

        Optional<Member> maybeMember = memberFinder.memberById(members, memberId);

        maybeMember.ifPresentOrElse(
                ui::printMemberFullNameMessage,
                () -> ui.printNoMemberMessage(memberId)
        );
    }
}
