import db.MembersFromDB;
import domain.MemberFinder;
import ui.UI;

import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:8083/test_db";
        MembersFromDB membersFromDB = new MembersFromDB(URL, "root", Optional.of("pwd"), "members");
        MemberFinder memberFinder = new MemberFinder(membersFromDB);
        UI ui = new UI(System.out);
        App app = new App(ui, memberFinder);

        int memberId = Integer.parseInt(args[0]);

        app.lookFor(memberId);
    }
}
