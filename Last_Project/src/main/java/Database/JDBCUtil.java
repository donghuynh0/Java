package Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    // get connection to database
    public static Connection getConnection(){
        Connection c = null;
        try {
            // create drive for driveManager and from that getConnection from driveManager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url  = "jdbc:mySQL://localhost:3306/Database";
            String userName = "root";
            String password = "bemo1806";
            c = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }
    // close connection to database
    public static void closeConnection(Connection c){
        try{
            if (c != null){
                c.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
