package lk.ijse.pos.bo.custome.impl;

import lk.ijse.pos.bo.custome.CustomerBO;
import lk.ijse.pos.dao.Custom.CustomerDAO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    //Property Injection
    //private final CustomerDAO customerDAO = new CustomerDAOImpl();

    //Hiding the object creation logic using the factory design pattern
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.CUSTOMER);


    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all =  customerDAO.getAll();
        for(Customer customer : all){
            allCustomers.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public boolean customerExists(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExists(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateID();
    }

}
