/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadevsys.users.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import leadevsys.members.org.Member;
import leadevsys.members.org.MemberDaoImpl;
import leadevsys.utils.org.ConnectDB;


public class UserDaoImpl implements UserDao{
    private final Connection conn = ConnectDB.getConnection();
    private final String SQL_GET_USER_BY_CREDENTIALS = "SELECT* FROM USERS WHERE username=? AND password=?";
    


    @Override
    public User getUserByCredentials(String username, String password) {
     User user = new User();
        try(PreparedStatement ps = conn.prepareStatement(SQL_GET_USER_BY_CREDENTIALS)){
            ps.setString(1,username);
            ps.setString(2,password);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    System.out.println("username:"+user.getUsername());
                    System.out.println("password:"+user.getPassword());             
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
}
