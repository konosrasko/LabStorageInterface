package org.example;
import java.util.*;


public class Storage {
    private int storageID;
    private String storageName;
    private List<Spot> spotList = new ArrayList<>();
    private List<StoreKeeper> storeKeeperList = new ArrayList<>();
    private List<Product> sortedProductList = new ArrayList<>();

    public Storage(){}

    public Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int spotID ,int corridor, int shelf){
        spotList.add(new Spot(spotID,corridor,shelf));
    }

    public void addStoreKeeper(int employeeId ,String employeeName){
        storeKeeperList.add(new StoreKeeper(employeeName,employeeId));
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public List<Product> getSortedProductList() {
        return sortedProductList;
    }

    public int getStorageID() {
        return storageID;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public void setStoreKeeperList(List<StoreKeeper> storeKeeperList) {
        this.storeKeeperList = storeKeeperList;
    }

    public void setSortedProductList(List<Product> sortedProductList) {
        this.sortedProductList = sortedProductList;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public List<StoreKeeper> getStoreKeeperList() {
        return storeKeeperList;
    }

}
