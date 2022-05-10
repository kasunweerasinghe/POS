package dao.Custom;

import java.sql.SQLException;

public interface QueryDAO {
     void searchOrderByOrderID(String ID) throws SQLException, ClassNotFoundException;
}
