package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    //load all Customers
    ArrayList getAllCustomers() throws SQLException, ClassNotFoundException;

    //save customer
    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    //update Customer
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    //is customer exists
    boolean isCustomerExists(String id) throws SQLException, ClassNotFoundException;

    //customer delete
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    //Generate new ID
    String generateID() throws SQLException, ClassNotFoundException;


}
