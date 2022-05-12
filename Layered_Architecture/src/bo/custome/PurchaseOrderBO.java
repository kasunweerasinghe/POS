package bo.custome;

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

public interface PurchaseOrderBO {

     boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

     CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException;

     boolean checkItemISAvailable(String code) throws SQLException, ClassNotFoundException;

     boolean checkCustomerISAvailable(String id) throws SQLException, ClassNotFoundException;

     String generateNewOrderId() throws SQLException, ClassNotFoundException;

     ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

     ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
}
