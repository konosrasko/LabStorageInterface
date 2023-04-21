package org.example;

import java.util.List;

import java.util.ArrayList;

public class Search {


    public Search(){}

    public List searchOfProduct(int ProductCode,List<StoreKeeper> storeKeepersList, List<EntrySlip> entrySlipList){
        List searchOfProductResult = new ArrayList();
        int i =0;
        for(StoreKeeper storeKeeper : storeKeepersList){
            for (EntrySlip entrySlip : entrySlipList){
                if (entrySlip.getProductList().get(i).getProductId()== ProductCode){
                    searchOfProductResult.add(storeKeeper);
                    searchOfProductResult.add(storeKeeper.getSlipList());
                    i++;
                }
            }
        }
        return searchOfProductResult;
    }


}
