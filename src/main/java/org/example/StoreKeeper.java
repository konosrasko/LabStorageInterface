package org.example;

import java.util.ArrayList;
import java.util.List;


public class StoreKeeper {
    private String keeperName;
    private int keeperId;
    private List<EntrySlip> slipList = new ArrayList<>();

    public StoreKeeper(){

    }

    public StoreKeeper(String keeperName, int keeperId){
        this.keeperName = keeperName;
        this.keeperId = keeperId;
    }


    public void addSlip(EntrySlip slip){
        this.slipList.add(slip);
    }

    public List<EntrySlip> getSlipList() {
        return slipList;
    }

    public void setSlipList(List<EntrySlip> slipList) {
        this.slipList = slipList;
    }
}
