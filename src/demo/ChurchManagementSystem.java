/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import leadevsys.users.org.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import leadevsys.users.org.LoginView;

public class ChurchManagementSystem {
    

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    
        
//     int member_id=0;
//     String fname, mname, lname;
//     MemberDao memberDao = new MemberDaoImpl();
//     
//      //print all students
////      for (Member member : memberDao.getAllMembers()) {
////         System.out.println("Member : "+member.getMemberId()+" " + member.getFname() + " "+ member.getMname()+ " "+ member.getLname());
////      }
//            String username,password;
//            System.out.println("Enter username:");
//            Scanner input = new Scanner(System.in);
//            username = input.next();
//            System.out.println("Enter password:");
//            password = input.next();
//            
//            UserDao userDao = new UserDaoImpl();
//            User user = userDao.getUserByCredentials(username, password);
//            if(user.getUsername().equals(username)&&(user.getPassword().equals(password))){
//             System.out.println("Login successful!");
//            }else{
//                System.out.println("Invalid credentials!");
//            }
//            
//      Scanner input = new Scanner(System.in);
////      member_id = input.nextInt();
////      Member member =memberDao.getAllMembers().get(member_id);
////      System.out.print("Enter firstname:");
////      fname = input.next();
////      member.setFname(fname);
////      System.out.print("Enter middle name:");
////      mname = input.next();
////      member.setMname(mname);
////      System.out.print("Enter lastname:");
////      lname = input.next();
////      member.setLname(lname);
////      memberDao.updateMember(member);

////      System.out.println("Enter ID to update:");
//      Scanner input = new Scanner(System.in);
////      member_id = input.nextInt();
////      Member member =memberDao.getAllMembers().get(member_id);
////      System.out.print("Enter firstname:");
////      fname = input.next();
////      member.setFname(fname);
////      System.out.print("Enter middle name:");
////      mname = input.next();
////      member.setMname(mname);
////      System.out.print("Enter lastname:");
////      lname = input.next();
////      member.setLname(lname);
////      memberDao.updateMember(member);
////      
////      //get member
////      memberDao.getMemberById(member_id);
////      System.out.println("Member : " + member.getFname() + " "+ member.getMname()+ " "+ member.getLname());
////    
////      System.out.println("Enter ID to delete:");
////      member_id = input.nextInt();
////      memberDao.deleteMember(member_id);
////      
//      //print all students
//      for (Member member2 : memberDao.getAllMembers()) {
//         System.out.println("Member : "+member2.getMemberId()+" " + member2.getFname() + " "+ member2.getMname()+ " "+ member2.getLname());
//      }
//      
//      
//      System.out.println("Enter new member details:");
//      Member member3 = new Member();
//      System.out.print("Enter firstname:");
//      fname = input.next();
//      member3.setFname(fname);
//      System.out.print("Enter middle name:");
//      mname = input.next();
//      member3.setMname(mname);
//      System.out.print("Enter lastname:");
//      lname = input.next();
//      member3.setLname(lname);
//      memberDao.createMember(member3);
//
    }
}
