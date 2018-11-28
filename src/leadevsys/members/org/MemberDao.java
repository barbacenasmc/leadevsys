package leadevsys.members.org;

import java.util.ArrayList;
public interface MemberDao {
    
    public ArrayList<Member> getAllMembers();
    public Member getMemberById(int member_id);
    public void createMember(Member member);
    public void updateMember(Member member);
    public void deleteMember(int member_id);
    public Member getMemberByName(String keyword);
    
}
