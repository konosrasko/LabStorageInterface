package org.example;

import java.util.ArrayList;
import java.util.List;

public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<Product> productList = new ArrayList<>();
    private List<Product> productList1 = new ArrayList<>();
    private List<Product> productList2 = new ArrayList<>();
    public StoreKeeper(){

    }

    public StoreKeeper(int keeperId,String keeperName){
        this.keeperId = keeperId;
        this.keeperName = keeperName;
    }


    public void addProductList(int productId, Enum type, String desc, String quantityMes, int quantity){
        productList.add(new Product(productId,  type,  desc,  quantityMes,  quantity));
    }
    public void addSlipToStoreKeeper(int slipID){
        for (int i=0; i<=productList.size();i++);

    }

//    public void setProductList1(int slipId){
//        productList1.add();
//    }

    public String getKeeperName() {
        return keeperName;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public int getKeeperId() {
        return keeperId;
    }

    public void setKeeperId(int keeperId) {
        this.keeperId = keeperId;
    }
}
