package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<Product> productList = new ArrayList<>();
    private List<Slip> slipList = new ArrayList<>();
    private List<Product> productListFifo = new ArrayList<>();
    private List<Product> productListLifo = new ArrayList<>();

    public StoreKeeper(){

    }

    public StoreKeeper(int keeperId,String keeperName){
        this.keeperId = keeperId;
        this.keeperName = keeperName;
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


    public void assignProduct(int id, int pid, @NotNull List<Spots> spotsList){
        for (int i=0; i<=spotsList.size(); i++){
            if (spotsList.get(id).getSpotID() == id){
                getKeeperName();
                getKeeperId();
                spotsList.get(id).setProductId(pid);
                break;
            }
        }
    }

    public void removeProduct(int id, @NotNull List<Spots> spotsList){
        for (int i=0; i<=spotsList.size(); i++){
            if (spotsList.get(id).getSpotID() == id){
                getKeeperName();
                getKeeperId();
                spotsList.get(id).setProductId(0);
                break;
            }
        }
    }

    public void searchPorduct(int pid, @NotNull List<Product> productList){
        for(int i=0; i<=productList.size(); i++){
            if (productList.get(i).getProductId() == pid){
                getKeeperId();
                getKeeperName();
                System.out.println(productList.get(i).getProductId()+getKeeperId()+getKeeperName());
                break;
            }
        }
    }

    public void searchSpots(int id, @NotNull List<Spots> spotsList){
        for (int i=0; i<=spotsList.size(); i++){
            if (spotsList.get(i).getSpotID()==id){
                getKeeperId();
                getKeeperName();
                System.out.println(spotsList.get(i).getSpotID()+getKeeperId()+getKeeperName());
                break;
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
    public void setSlipList(List<Slip> slipList) {
        this.slipList = slipList;
    }
}
