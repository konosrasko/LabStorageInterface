package org.example;

import java.util.ArrayList;
import java.util.List;


public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<Slip> slipList = new ArrayList<>();



    public StoreKeeper(){

    }

    public StoreKeeper(String keeperName, int keeperId){
        this.keeperName = keeperName;
        this.keeperId = keeperId;
    }


    public void addSlip(Slip slip){
        this.slipList.add(slip);
    }

    public List<Slip> getEntrySlipList() {
        return slipList;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public int getKeeperId() {
        return keeperId;
    }


    public void setEntrySlipList(List<EntrySlip> entrySlipList) {
        this.entrySlipList = entrySlipList;
    }
}
