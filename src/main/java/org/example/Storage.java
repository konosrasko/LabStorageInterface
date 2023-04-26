package org.example;
import java.util.ArrayList;
import java.util.List;


public class Storage {
    private int storageID;
    private String storageName;
    private List<Spot> spotList = new ArrayList<>();
    private List<StoreKeeper> storeKeeperList = new ArrayList<>();
    private List<EntrySlip> entrySlips = new ArrayList<>();


    public void Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int spotID ,int corridor, int shelf){
        spotList.add(new Spot(spotID,corridor,shelf));
    }

    public void addStoreKeeper(int employeeId ,String employeeName){
        storeKeeperList.add(new StoreKeeper(employeeName,employeeId));
    }

    public List<Spot> getSpotsList() {
        return spotList;
    }

    public List<EntrySlip> getEntrySlips() {
        return entrySlips;
    }

    public int emptySpots(){
        int s = 0;
        for (Spot spot : spotList){
            if (spot.getProductId()==0){
                s +=1;
            }
        }
        return s;
    }

    public int getStorageID() {
        return storageID;
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageName() {
        return storageName;
    }

    public List<StoreKeeper> getStoreKeeperList() {
        return storeKeeperList;
    }

}
