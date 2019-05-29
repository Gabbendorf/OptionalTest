import db.MembersFromDB;
import domain.MemberFinder;
import ui.UI;

import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) {
        String port = "8083";
        String user = "root";
        Optional<String> maybePassword = Optional.of("pwd");

        MembersFromDB membersFromDB = new MembersFromDB(port, user, maybePassword);
        MemberFinder memberFinder = new MemberFinder(membersFromDB);
        UI ui = new UI(System.out);
        App app = new App(ui, memberFinder);

        int memberId = Integer.parseInt(args[0]);

        app.lookFor(memberId);
    }
}
