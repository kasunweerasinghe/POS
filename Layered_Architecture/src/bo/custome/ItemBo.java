package bo.custome;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {

     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

     boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

     boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean itemExists(String id) throws SQLException, ClassNotFoundException;

     String generateNewItemID() throws SQLException, ClassNotFoundException;
}
