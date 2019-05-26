import domain.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class MembersMapper {
    private static List<Member> noMembers = emptyList();

    public List<Member> membersFrom(ResultSet resultSet) {
        List<Member> members = new ArrayList<>();
        try {
            if (resultSet == null || !resultSet.next()) {
                return noMembers;
            } else {
                do {
                    members.add(parseMember(resultSet));
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            System.err.println("Sql query not valid");
            e.printStackTrace();
        }

        return members;
    };

    private Member parseMember(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name" );
        String surname = resultSet.getString("surname" );
        int id = resultSet.getInt("member_id" );
        return new Member(id, name, surname);
    }
}
