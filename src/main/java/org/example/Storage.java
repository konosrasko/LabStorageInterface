package org.example;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private int storageID;
    private String storageName;
    private List<Spots> spotsList = new ArrayList<>();

    public void Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int corridor, int shelf, int qnty, int spotID){
        spotsList.add(new Spots(corridor,shelf,qnty,spotID));
    }
}
