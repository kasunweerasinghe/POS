package dao.Custom;

import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
     ArrayList<CustomDTO> searchOrderByOrderID(String ID) throws SQLException, ClassNotFoundException;
}
