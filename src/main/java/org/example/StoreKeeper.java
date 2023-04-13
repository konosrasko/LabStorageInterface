package org.example;

import java.util.ArrayList;
import java.util.List;

public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<Product> productListSlip = new ArrayList<>();
    private List<Slip> slipList = new ArrayList<>();
    public StoreKeeper(){

    }

    public StoreKeeper(int keeperId,String keeperName){
        this.keeperId = keeperId;
        this.keeperName = keeperName;
    }

//
//    public void setSlipList(){
//        slipList.add();
//    }
    public void setProductListSlip(List<Product> productListSlip) {
        this.productListSlip = productListSlip;
    }

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
