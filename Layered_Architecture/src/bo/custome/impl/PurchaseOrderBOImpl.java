package bo.custome.impl;

import bo.custome.PurchaseOrderBO;
import dao.Custom.*;
import dao.Custom.Impl.*;
import dao.DAOFactory;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    //Hiding the object creation logic using the factory design pattern
    CustomerDAO customerDAO =(CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.CUSTOMER);
    ItemDAO itemDAO =(ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ITEM);
    PlaceOrderDAO orderDAO =(PlaceOrderDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ORDER);
    PlaceOrderDetailDAO orderDetailsDAO  =(PlaceOrderDetailDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ORDERDETAILS);
    QueryDAO queryDAO =(QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.QUERYDAO);

    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException{
            /*Transaction*/
            Connection connection = DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            if (orderDAO.isExists(orderId)) {

            }

            connection.setAutoCommit(false);
            boolean save = orderDAO.save(new OrderDTO(orderId, orderDate, customerId));

            if (!save) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : orderDetails) {
                boolean save1 = orderDetailsDAO.save(detail);
                if (!save1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item

                ItemDTO item = searchItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                System.out.println(item);
                boolean update = itemDAO.update(item);

                if (!update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }

    @Override
    public boolean checkItemISAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists(code);
    }

    @Override
    public boolean checkCustomerISAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExists(id);
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

}
