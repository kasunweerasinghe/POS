package lk.ijse.pos.bo.custome.impl;

import lk.ijse.pos.bo.custome.ItemBo;
import lk.ijse.pos.dao.Custom.ItemDAO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBo {
    //Property Injection
    //private final ItemDAO itemDAO = new ItemDAOImpl();

    //Hiding the object creation logic using the factory design pattern
    private ItemDAO itemDAO =(ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ArrayList<Item> all =  itemDAO.getAll();
        for(Item item : all){
            allItems.add(new ItemDTO(item.getCode(),item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return allItems;

    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
       return itemDAO.delete(id);
    }

    @Override
    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice()));
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
