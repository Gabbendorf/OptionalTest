import java.util.List;
import java.util.Optional;

public class AppRunner {
    private final static String URL = "jdbc:mysql://localhost:3306/test_db";

    public static void main(String[] args) {
        MembersRepository membersRepository = new MembersRepository(URL, "root", Optional.empty());
        List<Member> members = membersRepository.allMembers(Query.MEMBERS_QUERY);

        if (members.isEmpty()) {
            System.out.println("No members were found");
        }

        System.out.println("All members found: \n");
        for (Member member : members) {
            System.out.println(member.getName() + " " + member.getSurname());
        }
    }

}
