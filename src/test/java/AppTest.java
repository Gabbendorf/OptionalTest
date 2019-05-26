import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void printsSuccessfulMessageForValidMemberId() {
        OutputStream outputStream = new ByteArrayOutputStream();
        UI ui = new UI(outputStream);
        App app = new App(ui);

        int validMemberId = 1;
        app.lookFor(validMemberId);

        assertTrue(outputStream.toString().contains("domain.Member with id 1 found"));
    }

    @Test
    public void printsUnsuccessfulMessageForNonValidMemberId() {
        OutputStream outputStream = new ByteArrayOutputStream();
        UI ui = new UI(outputStream);
        App app = new App(ui);

        int invalidMemberId = 10;
        app.lookFor(invalidMemberId);

        assertTrue(outputStream.toString().contains("domain.Member with id 10 is not a member"));
    }
}
