package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class Storage {
    private int storageID;
    private String storageName;
    private List<Spots> spotsList = new ArrayList<>();
    private List<StoreKeeper> storeKeeperList = new ArrayList<>();

    public void Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int corridor, int shelf, int qnty, int spotID){
        spotsList.add(new Spots(corridor,shelf,qnty,spotID));
    }

    public void addStoreKeeper(int keeperId ,String keeperName){
        storeKeeperList.add(new StoreKeeper(keeperId,keeperName));
    }

    public List<Spots> getSpotsList() {
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
        for (Spots spot : spotsList){
            if (spot.getProductId()==0){
                s +=1;
            }
        }
        return s;
    }
}
