package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StoreKeeper{
    private String keeperName;
    private int keeperId;
    private List<Slip> slipList = new ArrayList<>();
    private List<Product> productListAll = new ArrayList<>();

    public StoreKeeper(){

    }

    public StoreKeeper(int keeperId,String keeperName){
        this.keeperId = keeperId;
        this.keeperName = keeperName;
    }


    public void addSlip(Slip slip){
        this.slipList.add(slip);
    }


    public void setProductList() {
        for (Slip slipList : slipList) {
            for(Product product : slipList.getProductList()){
                    productListAll.add(product);}
        }
    }


    public List assignProduct(int id, int pid, List<Spots> spotsList){
        for (Spots spot : spotsList) {
            if (spot.getSpotID() == id) {
                spot.setProductId(pid);
            }
        }
        return spotsList;
    }

    public List removeProduct(int pid, List<Spots> spotsList){
        List<Product> sorted = productListAll.stream()
                .filter(product -> product.getType().equals(ProductType.FIFO))
                .collect(toList());
        for(Product product : sorted){
            if (product.getProductId() == pid){
                break;
            }
        }
        for (Spots spot : spotsList){
            if (spot.getProductId() == pid){
                spot.setProductId(0);
                break;
            }
        }
        return spotsList;
    }

    public int searchProduct(int pid, @NotNull List<Product> productList){
        for(Product product : productList){
            if (product.getProductId() == pid){
                return product.getProductId();
            }
        }
        return 1;
    }

    public int searchSpots(int id, @NotNull List<Spots> spotsList){
        for (Spots spot : spotsList){
            if (spot.getSpotID()==id){
                return spot.getSpotID();
            }
        }
        return 1;
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
