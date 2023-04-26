package org.example;
import java.util.List;


public class Search {


    public Search(){}

    public String searchOfProduct(int ProductCode,List<StoreKeeper> storeKeepersList, List<EntrySlip> entrySlipList){
        String searchOfProductResult = "";
        int i =0;
        for(StoreKeeper storeKeeper : storeKeepersList){
            for (EntrySlip entrySlip : entrySlipList){
                if (entrySlip.getProductList().get(i).getProductId()== ProductCode){
                    searchOfProductResult = storeKeeper.getKeeperName();

                    i++;
                }
            }
        }

        return searchOfProductResult;
    }


}
