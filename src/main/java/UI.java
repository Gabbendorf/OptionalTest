import domain.Member;

import java.io.OutputStream;
import java.io.PrintStream;

public class UI {

    private final PrintStream systemOut;

    public UI(OutputStream outputStream) {
        this.systemOut = new PrintStream(outputStream);
    }

    public void printMemberFullNameMessage(Member member) {
        systemOut.println(String.format("domain.Member with id %d found: \n", member.getId()));
        systemOut.println(member.getFullName());
    }

    public void printNoMemberMessage(int memberId) {
        systemOut.println(String.format("domain.Member with id %d is not a member", memberId));
    }
}
