package DAO;

import Database.JDBCUtil;
import Models.Product.Pen;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PenDAO implements DAOInterface<Pen>{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static PenDAO instance;
    public static PenDAO getInstance(){
        if (instance == null){
            instance = new PenDAO();
        }
        return instance;
    }

    @Override
    public int insert(Pen pen) {
        int rowsAffected = 0;
        try{
            // step 1: create a connection
            Connection conn = JDBCUtil.getConnection();

            // step 2: create statement
//            Statement st = conn.createStatement();
//            // step 3: execute statements
//            String sql = "insert into Pen(pid,name,origin,supplier,maf_date,price) values('" +
//                    pen.getPid() +"','"+ pen.getName() +"','"+ pen.getOrigin() +"','"+ pen.getSupplier() +"','"+
//                    pen.getMaf_date() +"','"+ pen.getPrice() +"');";

            String sql = "INSERT INTO Pen(pid, name, origin, maf_date, supplier, price, inkColor, penType) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, pen.getPid());
            pst.setString(2, pen.getName());
            pst.setString(3, pen.getOrigin());
            pst.setDate(4, new java.sql.Date(pen.getMaf_date().getTime())); // Proper date conversion
            pst.setString(5, pen.getSupplier());
            pst.setDouble(6, pen.getPrice());
            pst.setString(7,pen.getInkColor());
            pst.setString(8,pen.getPenType());

            rowsAffected = pst.executeUpdate(); // execute insert statement
            // step 4: handle result
            System.out.println("Insert statement executed.");
            if (rowsAffected > 0) {
                System.out.println("Rows affected: " + rowsAffected);
                System.out.println("Status: Successfully insert.");
            } else {
                System.out.println("Status: Insert failed or no changes made.");
            }
            // step 5: close connection
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public int update(Pen pen) {
        int rowsAffected = 0;
        String sql = "UPDATE Pen SET name = ?, origin = ?, maf_date = ?, supplier = ?, price = ?, inkColor = ?, penType = ? WHERE pid = ?;";

        // step 1,2: create a connection and create statement
        try(Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            // set values into table
            pst.setString(1, pen.getName());
            pst.setString(2, pen.getOrigin());
            pst.setDate(3, new java.sql.Date(pen.getMaf_date().getTime())); // Proper date conversion
            pst.setString(4, pen.getSupplier());
            pst.setDouble(5, pen.getPrice());
            pst.setString(6, pen.getInkColor());
            pst.setString(7, pen.getPenType());
            pst.setString(8, pen.getPid());

            // step 3: execute update statement
            rowsAffected = pst.executeUpdate(); // execute insert statment

            // step 4: handle result
            System.out.println("Update statement executed.");
            if (rowsAffected > 0) {
                System.out.println("Rows affected: " + rowsAffected);
                System.out.println("Status: Successfully updated.");
            } else {
                System.out.println("Status: Update failed or no changes made.");
            }

            // step 5: close connection
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public int delete(Pen pen) {
        int rowsAffected = 0;
        String sql = "DELETE FROM Pen WHERE pid = ?;";  // Ensure 'pid' is the unique identifier column

        // step 1,2: create a connection and create statement
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            // set value into table
            pst.setString(1, pen.getPid());

            // step 3: Execute delete statement
            rowsAffected = pst.executeUpdate();

            // step 4: Handle result
            System.out.println("Delete statement executed.");
            if (rowsAffected > 0) {
                System.out.println("Rows affected: " + rowsAffected);
                System.out.println("Status: Successfully deleted.");
            } else {
                System.out.println("Status: Delete failed or no record found.");
            }

            // step 5: close connection
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;

    }

    @Override
    public ArrayList<Pen> selectAll() {
        ArrayList<Pen> result = new ArrayList<>();
        String sql = "SELECT * FROM PEN";
        try (Connection conn = JDBCUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                // get data from sql
                String pid = rs.getString("pid");
                String name = rs.getString("name");
                String origin = rs.getString("origin");

                // get sql date and convert to util date and continue convert to string
                java.sql.Date sql_maf_date = rs.getDate("maf_date");
                String maf_date = (sql_maf_date != null) ? sdf.format(new java.util.Date(sql_maf_date.getTime())) : null;


                String supplier = rs.getString("supplier");
                double price = rs.getDouble("price");
                String inkColor = rs.getString("inkColor");
                String penType = rs.getString("penType");

                result.add(new Pen(pid,name,origin,maf_date,supplier,price,inkColor,penType));
            }
            // close connection
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Pen selectById(String id) {
        Pen result = null;
        String sql = "SELECT * FROM PEN WHERE pid = '" + id + "';";
        try (Connection conn = JDBCUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                // get data from sql
                String pid = rs.getString("pid");
                String name = rs.getString("name");
                String origin = rs.getString("origin");

                // get sql date and convert to util date and continue convert to string
                java.sql.Date sql_maf_date = rs.getDate("maf_date");
                String maf_date = (sql_maf_date != null) ? sdf.format(new java.util.Date(sql_maf_date.getTime())) : null;


                String supplier = rs.getString("supplier");
                double price = rs.getDouble("price");
                String inkColor = rs.getString("inkColor");
                String penType = rs.getString("penType");

                result = new Pen(pid,name,origin,maf_date,supplier,price,inkColor,penType);
            }
            // close connection
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Pen> selectByCondition(String condition) {
        return null;
    }
}
