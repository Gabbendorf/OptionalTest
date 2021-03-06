import db.MembersFromDB;
import domain.MemberFinder;
import org.junit.Test;
import ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void printsSuccessfulMessageForValidMemberId() {
        OutputStream outputStream = new ByteArrayOutputStream();
        App app = newApp(outputStream);

        int validMemberId = 1;
        app.lookFor(validMemberId);

        assertTrue(outputStream.toString().contains("Member with id 1 found"));
    }

    @Test
    public void printsUnsuccessfulMessageForNonValidMemberId() {
        OutputStream outputStream = new ByteArrayOutputStream();
        App app = newApp(outputStream);

        int invalidMemberId = 10;
        app.lookFor(invalidMemberId);

        assertTrue(outputStream.toString().contains("Member with id 10 is not a member"));
    }

    private App newApp(OutputStream outputStream) {
        UI ui = new UI(outputStream);
        String portForTestsDb = "8085";
        MembersFromDB membersFromDB = new MembersFromDB(portForTestsDb, "root", "pwd");
        MemberFinder memberFinder = new MemberFinder(membersFromDB);
        return new App(ui, memberFinder);
    }
}
