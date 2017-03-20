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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author praykor
 */
public class DBAccessor {

    private final String DATABASE_URL = "jdbc:mysql://167.160.84.186:3306/krankies";
    private final String SELECT_QUERY = "SELECT * FROM account";
    private final String USERNAME = "praykor";
    private final String PASSWORD = "1Password!";
    private Connection connection;

    public void connectDB() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database server", "No Connection", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public int loginSQL(String user, String password) {
        ResultSet rs = null;
        String st = "SELECT * FROM account, account_type WHERE account.acc_type = account_type.acc_type AND account.user =? AND account.password =?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(st);
            pst.setString(1, user);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                return Integer.parseInt(rs.getString(5));
            } else JOptionPane.showMessageDialog(null, "Invalid user or password", "Login failed", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
