package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudDAO<T,ID> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    T search(ID id) throws SQLException, ClassNotFoundException;

    boolean isExists(ID id) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    String generateID() throws SQLException, ClassNotFoundException;

}
