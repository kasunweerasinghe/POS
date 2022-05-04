package dao;

import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class PlaceOrderDAOImpl {

    public void searchCustomer() throws SQLException, ClassNotFoundException {

    }

    public void findItem(){

    }

    public boolean isExistsItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();

        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
    }

    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();

        return SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id).next();
    }

    public String generateOrderID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

    }

    public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
        ArrayList<String> allCustomerID = new ArrayList<>();

        while (rst.next()){
            allCustomerID.add(rst.getString(1));
        }
        return allCustomerID;

    }

    public ArrayList<String> loadAllItemCodes() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<String> loadAllItemCode = new ArrayList<>();

        while (rst.next()){
            loadAllItemCode.add(rst.getString(1));
        }
        return loadAllItemCode;
    }

    public void saveOrder(){

    }


}
