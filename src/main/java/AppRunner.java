import db.MembersFromDB;
import domain.MemberFinder;
import ui.UI;

public class AppRunner {

    public static void main(String[] args) {
        String port = "8083";
        String user = "root";
        String password = "pwd";

        MembersFromDB membersFromDB = new MembersFromDB(port, user, password);
        MemberFinder memberFinder = new MemberFinder(membersFromDB);
        UI ui = new UI(System.out);
        App app = new App(ui, memberFinder);

        int memberId = Integer.parseInt(args[0]);

        app.lookFor(memberId);
    }
}
