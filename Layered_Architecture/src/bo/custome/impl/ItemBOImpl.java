package bo.custome.impl;

import bo.custome.ItemBo;
import dao.Custom.Impl.ItemDAOImpl;
import dao.Custom.ItemDAO;
import dao.DAOFactory;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBo {
    //Property Injection
    //private final ItemDAO itemDAO = new ItemDAOImpl();

    //Hiding the object creation logic using the factory design pattern
    private ItemDAO itemDAO =(ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
       return itemDAO.delete(id);
    }

    @Override
    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(dto);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean itemExists(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists(id);
    }

    @Override
    public String generateNewItemID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateID();
    }
}
