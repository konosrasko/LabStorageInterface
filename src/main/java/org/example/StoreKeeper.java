package org.example;

import java.util.ArrayList;
import java.util.List;

public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<Slip> slipList = new ArrayList<>();
    private List<Product> productListFifo = new ArrayList<>();
    private List<Product> productListLifo = new ArrayList<>();

    public StoreKeeper(){

    }

    public StoreKeeper(int keeperId,String keeperName){
        this.keeperId = keeperId;
        this.keeperName = keeperName;
    }

    public void setSlipList(List<Slip> slipList) {
        this.slipList = slipList;
    }

    public void addSlip(Slip slip){
        this.slipList.add(slip);
    }



    public void setProductList(List<Product> productList) {
        for (Slip slipList : slipList) {
            for (int i=0; i<slipList.getProductList().size(); i++){
            if (slipList.getProductList().get(i).getType().equals(ProductType.FIFO)) {
                this.productListFifo.add(slipList.getProductList().get(i));
            }else {
                this.productListLifo.add(slipList.getProductList().get(i));
            }

        }
        }
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
