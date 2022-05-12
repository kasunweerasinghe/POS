package dao;

import dao.Custom.CustomerDAO;
import dao.Custom.Impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDAOFactory(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOType{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUERYDAO
    }

    public SuperDAO getDAO(DAOType type){
        switch (type){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new PlaceOrderDAOImpl();
            case ORDERDETAILS:
                return new PlaceOrderDetailDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
