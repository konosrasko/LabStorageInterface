package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                    productListAll.add(product);
            }
        }
    }

    public List<Product> getProductListAll() {
        return productListAll;
    }

    public List assignProduct(int id, int pid, List<Spots> spotsList){
        for (Spots spot : spotsList){
            if ((spot.getSpotID() == id) && (spot.getProductId()==0)) {
                spot.setProductId(pid);
                //spot.setQnty();
            }
        }
        return spotsList;
    }

    public List removeProduct(int pid, List<Spots> spotsList){
        for(Product product : productListAll){
            if (product.getType()== ProductCategory.FIFO){
                
                for(Product product1 : sortedFIFO()) {
                    if (product1.getProductId() == pid) {
                        productListAll.remove(product1);
                        return spotsList;
                    }
                }
            } else {
                for (Product product1 : sortedLIFO()){
                    if (product1.getProductId() == pid){
                        productListAll.remove(product1);
                        return spotsList;
                    }
                }
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

    public List<Product> sortedFIFO(){
        List<Product> sortedFIFO = productListAll.stream()
                .filter(product -> product.getType().equals(ProductCategory.FIFO))
                .collect(Collectors.toList());
        return sortedFIFO;
    }

    public List<Product> sortedLIFO(){
        List<Product> sortedLIFO = productListAll.stream()
                .filter(product -> product.getType().equals(ProductCategory.LIFO))
                .collect(Collectors.toList());
        return sortedLIFO;
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
