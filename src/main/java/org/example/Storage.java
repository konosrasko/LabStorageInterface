package org.example;
import java.nio.file.attribute.AclEntryType;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class Storage {
    private int storageID;
    private String storageName;
    private List<Spot> spotsList = new ArrayList<>();
    private List<StoreKeeper> storeKeeperList = new ArrayList<>();
    private List<EntrySlip> entrySlips = new ArrayList<>();

    public void Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int spotID ,int corridor, int shelf){
        spotsList.add(new Spot(spotID,corridor,shelf));
    }

    public void addStoreKeeper(int employeeId ,String employeeName){
        storeKeeperList.add(new StoreKeeper(employeeName,employeeId));
    }

    public List<Spot> getSpotsList() {
        return spotsList;
    }

    public int getStorageID() {
        return storageID;
    }

    public String getStorageName() {
        return storageName;
    }

    public int emptySpots(){
        int s = 0;
        for (Spot spot : spotsList){
            if (spot.getProductId()==0){
                s +=1;
            }
        }
        return s;
    }

    public List<EntrySlip> getEntrySlips() {
        return entrySlips;
    }
}
