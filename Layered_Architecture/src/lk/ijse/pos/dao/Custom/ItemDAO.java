package lk.ijse.pos.dao.Custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item, String> {
    public ArrayList<ItemDTO> getItemFromPrice(double price)throws ClassNotFoundException, SQLException;
}
