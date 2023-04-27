package org.example;

import java.util.ArrayList;
import java.util.List;


public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<EntrySlip> entrySlipList = new ArrayList<>();



    public StoreKeeper(){

    }

    public StoreKeeper(String keeperName, int keeperId){
        this.keeperName = keeperName;
        this.keeperId = keeperId;
    }

    public void addSlip(EntrySlip slip){
        entrySlipList.add(slip);
    }


    public List<EntrySlip> getEntrySlipList() {
        return entrySlipList;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public int getKeeperId() {
        return keeperId;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public void setKeeperId(int keeperId) {
        this.keeperId = keeperId;
    }

    public void setEntrySlipList(List<EntrySlip> entrySlipList) {
        this.entrySlipList = entrySlipList;
    }
}
