import domain.Member;
import domain.MemberFinder;
import ui.UI;

import java.util.Optional;

public class App {
    private final MemberFinder memberFinder;
    private final UI ui;

    public App(UI ui, MemberFinder memberFinder) {
        this.ui = ui;
        this.memberFinder = memberFinder;
    }

    public void lookFor(int memberId) {
        Optional<Member> maybeMember = memberFinder.memberById(memberId);

        maybeMember.ifPresentOrElse(
                ui::printMemberFullNameMessage,
                () -> ui.printNoMemberMessage(memberId)
        );
    }
}
