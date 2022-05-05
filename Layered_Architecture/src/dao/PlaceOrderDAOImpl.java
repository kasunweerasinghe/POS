package dao;

import model.CustomerDTO;
import model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements CrudDAO<OrderDTO,String>{
    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean isExists(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return null;
    }



    /*public void searchCustomer() {

    }

    public void findItem() {

    }

    public boolean isExistsItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", code).next();
    }

    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?", id).next();
    }

    public String generateOrderID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

    }

    public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
        ArrayList<String> allCustomerID = new ArrayList<>();

        while (rst.next()) {
            allCustomerID.add(rst.getString(1));
        }
        return allCustomerID;

    }

    public ArrayList<String> loadAllItemCodes() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<String> loadAllItemCode = new ArrayList<>();

        while (rst.next()) {
            loadAllItemCode.add(rst.getString(1));
        }
        return loadAllItemCode;
    }

    public void saveOrder() {


    }

    public void findItem(String code){

    }*/
}
