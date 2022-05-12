package bo;

import dao.Custom.CustomerDAO;
import dao.Custom.Impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    //Property Injection
    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return  customerDAO.getAll();
    }

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    public boolean customerExists(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExists(id);
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateID();
    }

}
