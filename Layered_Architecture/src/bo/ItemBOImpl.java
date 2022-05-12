package bo;

import dao.Custom.Impl.ItemDAOImpl;
import dao.Custom.ItemDAO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    //Property Injection
    private final ItemDAO itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
       return itemDAO.delete(id);
    }

    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(dto);
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    public boolean itemExists(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists(id);
    }

    public String generateNewItemID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateID();
    }
}
