package org.example;

import java.util.List;

import java.util.ArrayList;

public class Search {
    private List<Spot> spotList = new ArrayList<>();
    private List<StoreKeeper> storeKeepersList = new ArrayList<>();
    private List<EntrySlip> entrySlipList = new ArrayList<>();


    public Search(){}

    public List searchOfProduct(int ProductCode){
        List searchOfProductResult = new ArrayList();
        int i =0;
        for(StoreKeeper storeKeeper : storeKeepersList){
            for (EntrySlip entrySlip : entrySlipList){
                if (entrySlip.getProductList().get(i).getProductId()== ProductCode){
                    searchOfProductResult.add(storeKeeper);
                    searchOfProductResult.add(storeKeeper.getSlipList());
                }
            }
        }
        return searchOfProductResult;
    }


}
