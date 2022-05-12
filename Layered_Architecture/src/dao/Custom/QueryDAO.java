package dao.Custom;

import dao.SuperDAO;
import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
     ArrayList<CustomDTO> searchOrderByOrderID(String ID) throws SQLException, ClassNotFoundException;
}
