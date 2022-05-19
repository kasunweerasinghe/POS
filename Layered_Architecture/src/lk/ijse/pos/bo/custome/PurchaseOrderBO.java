package lk.ijse.pos.bo.custome;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBO {

     boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

     CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException;

     boolean checkItemISAvailable(String code) throws SQLException, ClassNotFoundException;

     boolean checkCustomerISAvailable(String id) throws SQLException, ClassNotFoundException;

     String generateNewOrderId() throws SQLException, ClassNotFoundException;

     ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

     ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
}
