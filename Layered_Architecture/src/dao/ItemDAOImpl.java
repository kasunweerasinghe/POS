package dao;

import db.DBConnection;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    //load All Items
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()) {
            String code = rst.getString(1);
            String description = rst.getString(2);
            BigDecimal unitPrice = rst.getBigDecimal(3);
            int qtyOnHand = rst.getInt(4);
        }
        return allItem;
    }
    //delete Items
    public boolean deleteItems(String code) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
    }

    //save items
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    //update items
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    //is items exists
    public boolean isItemExists(String code) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
    }

    //generate ID
    public String generateID() throws SQLException, ClassNotFoundException {
        //Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

}
