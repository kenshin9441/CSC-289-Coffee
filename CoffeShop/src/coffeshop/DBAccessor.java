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
import java.sql.Statement;
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
        String st = "SELECT * FROM account, account_type WHERE account.acc_type = 'MAN' AND account.user =? AND account.password =?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(st);
            pst.setString(1, user);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                return Integer.parseInt(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public ResultSet getManager(int id){
        ResultSet rs = null;
        String st ="SELECT * FROM employee WHERE employee_id=?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(st);
            pst.setInt(1, id);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getAccount(String user){
        ResultSet rs = null;
        String st = "SELECT * FROM account WHERE account.user = ?";
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(st);
            pst.setString(1, user);
            rs = pst.executeQuery();
        }catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public Boolean resetPassword(String password, String user){
        int result = 0;
        String st = "UPDATE account SET account.password =? WHERE user =?";
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(st);
            pst.setString(1, password);
            pst.setString(2, user);
            result = pst.executeUpdate();
            if (result >0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ResultSet getProduct(){
        ResultSet rs = null;
        String st = "SELECT * FROM product";
        try {
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(st);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getPromo(){
        ResultSet rs = null;
        String st = "SELECT promo_cd, discount_amount FROM promo_cd WHERE promo_availability = 1";
        try {
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(st);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getOrder(){
        ResultSet rs = null;
        String st = "SELECT transaction_id, fname, lname, trans_date, total_price, promo_cd  FROM transaction, customer WHERE trans_type = 'ONLINE' AND transaction.cust_id = customer.customer_id "
                + "AND transaction_id NOT IN (SELECT trans_id FROM payment)";
        try {
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(st);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getOrderDetail(int id){
        ResultSet rs = null;
        String st = "SELECT * FROM krankies.products_in_transaction WHERE trans_id = ?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(st);
            pst.setInt(1, id);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
