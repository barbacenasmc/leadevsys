package leadevsys.utils.org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectDB {
	
	public static Connection getConnection(){
		Connection connection = null;
                String dbUrl = "jdbc:mysql://localhost:3306/leadevsys";
              
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl,"root","");
                        System.out.println("Successfully connected to database");
		}catch (ClassNotFoundException e){
                    System.out.println("Could not found the database driver" + e.getMessage());
		}catch (SQLException e){
                    Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
                }
		
		return connection;
	}
}
