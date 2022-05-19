package bo;

import bo.custome.impl.CustomerBOImpl;
import bo.custome.impl.ItemBOImpl;
import bo.custome.impl.PurchaseOrderBOImpl;

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
