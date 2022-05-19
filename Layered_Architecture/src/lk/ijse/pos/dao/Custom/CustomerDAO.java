package lk.ijse.pos.dao.Custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public ArrayList<CustomerDTO> getAllCustomersByAddress(String address)throws ClassNotFoundException, SQLException;
}
