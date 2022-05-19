package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custome.impl.CustomerBOImpl;
import lk.ijse.pos.bo.custome.impl.ItemBOImpl;
import lk.ijse.pos.bo.custome.impl.PurchaseOrderBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOType{
        ITEM,CUSTOMER,PURCHASEORDER
    }
    public SuperBO getBO(BOType type){
        switch (type){
            case ITEM:
                return new ItemBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case PURCHASEORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }


}
