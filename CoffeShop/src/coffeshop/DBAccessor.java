/*
* This class is meant to be used to access the database
* Simply use the methods inside it, and get your data back.
* Can also be used to create reports
 */
package coffeshop;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ghin
 */
public class DBAccessor {

    private final String DATABASE_URL = "jdbc:mysql://167.160.84.186:3306/krankies";
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

    public ResultSet getManager(int id) {
        ResultSet rs = null;
        String st = "SELECT * FROM employee WHERE employee_id=?";
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

    public ResultSet getAccount(String user) {
        ResultSet rs = null;
        String st = "SELECT * FROM account WHERE account.user = ?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(st);
            pst.setString(1, user);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Boolean resetPassword(String password, String user) {
        int result = 0;
        String st = "UPDATE account SET account.password =? WHERE user =?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(st);
            pst.setString(1, password);
            pst.setString(2, user);
            result = pst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ResultSet getProduct() {
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

    public ResultSet getPromo() {
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

    public ResultSet getOrder() {
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

    public ResultSet getOrderDetail(int id) {
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

    public Boolean insertPayment(int empId, String transType, BigDecimal tax, BigDecimal total, String promoCd, List<Button> products, List<Payment> payments) {
        String st1 = "INSERT INTO krankies.transaction"
                + "(trans_date," + "emp_id," + "trans_type," + "tax," + "total_price," + "promo_cd)"
                + "VALUES"
                + "(?,?,?,?,?,?,?);";
        String st2 = "INSERT INTO krankies.products_in_transaction"
                + "(product_id," + "trans_id," + "quantity)"
                + "VALUES"
                + "(?,?,?);";
        String st3 = "INSERT INTO krankies.payment"
                + "(payment_method," + "trans_id," + "amount)"
                + "VALUES"
                + "(?,?,?);";

        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = null;
            int key = 0;
            if (transType.equals("ONLINE")) {
                Statement stm = connection.createStatement();
                ResultSet rsKey = stm.executeQuery("SELECT transaction_id FROM transaction ORDER BY transaction_id DESC LIMIT 1;");
                key = rsKey.getInt(1);
            } else {
                pst = connection.prepareStatement(st1, Statement.RETURN_GENERATED_KEYS);
                pst.setDate(1, new Date(System.currentTimeMillis()));
                pst.setInt(2, empId);
                pst.setString(3, transType);
                pst.setBigDecimal(4, tax);
                pst.setBigDecimal(5, total);
                pst.setString(6, promoCd);
                pst.executeUpdate();
                ResultSet rsKey = pst.getGeneratedKeys();
                while (rsKey.next()) {
                    key = rsKey.getInt(1);
                }
                pst.close();
            }

            pst = connection.prepareStatement(st2);
            for (Button i : products) {
                pst.setInt(1, i.getID());
                pst.setInt(2, key);
                pst.setInt(3, i.getQty());
                pst.addBatch();
            }
            pst.executeBatch();
            pst.close();
            pst = connection.prepareStatement(st3);
            for (Payment i : payments) {
                pst.setString(1, i.getMethod());
                pst.setInt(2, key);
                pst.setBigDecimal(3, i.getPayAmt());
                pst.addBatch();
            }
            pst.executeBatch();
            pst.close();
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }

        return false;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
