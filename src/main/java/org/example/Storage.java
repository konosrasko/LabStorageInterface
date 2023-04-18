package org.example;
import java.util.ArrayList;
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

    /*
    public void assignProduct(int id,int pid){
        for(Spots spotsList : spotsList){
            if (spotsList.getSpotID()== id){
                spotsList.setProductId(pid);
                break;
            }
        }
    }
    */


    public int getStorageID() {
        return storageID;
    }

    public String getStorageName() {
        return storageName;
    }

    public List<Spots> getSpotsList() {
        return spotsList;
    }
}
