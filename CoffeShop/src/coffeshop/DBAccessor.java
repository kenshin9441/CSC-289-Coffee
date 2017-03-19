/*
* This class is meant to be used to access the database
* Simply use the methods inside it, and get your data back.
* Can also be used to create reports
 */
package coffeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author praykor
 */
public class DBAccessor {
    public static void main(String args[]){
    final String DATABASE_URL = "jdbc:mysql://167.160.84.186:3306/Coffee-Shop";
    final String SELECT_QUERY = "SELECT * FROM testtable";
    final String USERNAME = "praykor";
    final String PASSWORD = "1Password!";
    String results = "";
    String sql = "SELECT * FROM Files";
    PreparedStatement prep;
    
    
    try{
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        prep = connection.prepareStatement(SELECT_QUERY);
        ResultSet data = prep.executeQuery();
        
        ResultSet result = prep.executeQuery();
        System.out.println(result + " Database Connected");
    }catch(SQLException ex){
        System.out.print(ex);
    }
    }
}
