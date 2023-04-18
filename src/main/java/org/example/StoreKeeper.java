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

    public void setSlipList(int id){
        Slip slip = new Slip();
        slip.setSlipId(id);
        slipList.add(new Slip(id));
    }



    public void setProductList1(List<Product> productList1) {
        for (int i=0; i<=slipList.size(); i++){
            if (slipList.get(i).getProductList().get(i).getType() == ProductType.FIFO){
                productList1.add(slipList.get(i).getProductList().get(i));
            }else productList2.add(slipList.get(i).getProductList().get(i));
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
