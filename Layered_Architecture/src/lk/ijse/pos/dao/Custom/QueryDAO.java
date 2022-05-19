package lk.ijse.pos.dao.Custom;

import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dto.CustomDTO;
import lk.ijse.pos.entity.CustomEntity;
import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
     ArrayList<CustomEntity> searchOrderByOrderID(String ID) throws SQLException, ClassNotFoundException;
}
