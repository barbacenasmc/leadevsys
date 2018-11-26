
package leadevsys.users.org;

import java.util.ArrayList;
import leadevsys.members.org.Member;

public interface UserDao {
        
//    public ArrayList<Member> getAllMembers();
    public User getUserByCredentials(String username, String password);
//    public void createUser(User user);
//    public void updateUser(User user);
//    public void deleteUser(int user_id);
}
