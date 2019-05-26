import db.MembersFromDB;
import domain.MemberFinder;
import ui.UI;

import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/test_db";
        MemberFinder memberFinder = new MemberFinder();
        MembersFromDB membersFromDB = new MembersFromDB(URL, "root", Optional.empty(), "members");
        UI ui = new UI(System.out);
        App app = new App(ui, membersFromDB, memberFinder);

        int memberId = Integer.parseInt(args[0]);

        app.lookFor(memberId);
    }
}
