package dao;

import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class CustomerDAOImpl implements CrudDAO<CustomerDTO,String> {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
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


//    //load all Customers
//    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        while (rst.next()) {
//            allCustomers.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
//        }
//        return allCustomers;
//    }
//
//    //save customer
//    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
//    }
//
//    //update Customer
//    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//       return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
//    }
//
//    //is customer exists
//    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
//          return SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id).next();
//    }
//
//    //customer delete
//    public boolean delete(String id) throws SQLException, ClassNotFoundException {
//       return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
//    }
//
//    //Generate new ID
//    public String generateID() throws SQLException, ClassNotFoundException {
//        //Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }

}
