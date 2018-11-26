
package leadevsys.members.org;
import leadevsys.utils.org.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberDaoImpl implements MemberDao{
    
    private final Connection conn = ConnectDB.getConnection();
    private final String SQL_CREATE_MEMBER = "INSERT INTO MEMBERS (member_id,fname,mname,lname) VALUES (?,?,?,?)";
    private final String SQL_GET_MEMBER_BY_ID = "SELECT* FROM MEMBERS WHERE member_id=?";
    private final String SQL_GET_ALL_MEMBERS = "SELECT * FROM MEMBERS";
    private final String SQL_UPDATE_MEMBER = "UPDATE members SET fname = ?, mname = ?, lname = ? WHERE member_id = ?";
    private final String SQL_DELETE_MEMBER = "DELETE FROM members WHERE member_id = ?";
    @Override
    
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> allMembers = new ArrayList();
        try(PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL_MEMBERS);
                ResultSet rs =  ps.executeQuery()){
                while (rs.next()){
                    Member member = new Member();
                    member.setMemberId(rs.getInt(1));
                    member.setFname(rs.getString(2));
                    member.setMname(rs.getString(3));
                    member.setLname(rs.getString(4));
                    allMembers.add(member);
                }
            
       } catch (SQLException ex) {  
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return allMembers;
    }

    @Override
    public Member getMemberById(int member_id) {
        Member member = new Member();
        try(PreparedStatement ps = conn.prepareStatement(SQL_GET_MEMBER_BY_ID)){
            ps.setInt(1,member_id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    member.setMemberId(rs.getInt(1));
                    member.setFname(rs.getString(2));
                    member.setMname(rs.getString(3));
                    member.setLname(rs.getString(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return member;
    }

    @Override
    public void createMember(Member member) {
       try(PreparedStatement ps = conn.prepareStatement(SQL_CREATE_MEMBER,Statement.RETURN_GENERATED_KEYS)){
           ps.setInt(1,member.getMemberId());
           ps.setString(2,member.getFname());
           ps.setString(3, member.getMname());
           ps.setString(4, member.getLname());
           ps.executeUpdate();
           try(ResultSet generatedKeys= ps.getGeneratedKeys()){
            if(generatedKeys.next()){
                member.setMemberId(generatedKeys.getInt(1));
            }   
           }
 
       } catch (SQLException ex) {  
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    @Override
    public void updateMember(Member member) {
        try(PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_MEMBER)){
            ps.setString(1, member.getFname());
            ps.setString(2,member.getMname());
            ps.setString(3, member.getLname());
            ps.setInt(4, member.getMemberId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteMember(int member_id) {
        try(PreparedStatement ps = conn.prepareStatement(SQL_DELETE_MEMBER)){
            ps.setInt(1, member_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
