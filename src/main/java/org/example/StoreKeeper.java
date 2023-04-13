package org.example;

import java.util.ArrayList;
import java.util.List;

public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<Slip> slipList = new ArrayList<>();
    private List<Product> productList1 = new ArrayList<>();
    private List<Product> productList2 = new ArrayList<>();

    public StoreKeeper(){

    }

    public StoreKeeper(int keeperId,String keeperName){
        this.keeperId = keeperId;
        this.keeperName = keeperName;
    }

    public void setSlipList(Slip productList){
        slipList.add(productList);
    }

//    public void setProductList1(){
//        for (Slip slipList:slipList){
//            if (slipList.)
//        }
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
