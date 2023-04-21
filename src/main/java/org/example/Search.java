package org.example;

import java.util.List;

import java.util.ArrayList;

public class Search {
    private List<Spot> spotList = new ArrayList<>();
    private List<StoreKeeper> storeKeepersList = new ArrayList<>();
    private List<Slip> slipList = new ArrayList<>();


    public Search(){}

    public List searchOfProduct(int ProductCode){
        List searchOfProductResult = new ArrayList();
        for(StoreKeeper storeKeeper : storeKeepersList){
            if (storeKeeper.getEntrySlipList
        }

        return searchOfProductResult;
    }


}
