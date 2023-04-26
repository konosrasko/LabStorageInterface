package org.example;
import java.util.List;


public class Search {


    public Search(){}

    public String searchOfProduct(int ProductCode,List<StoreKeeper> storeKeepersList, List<Slip> slipList){
        String searchOfProductResult = "";
        int i =0;
        for(StoreKeeper storeKeeper : storeKeepersList){
            for (Slip slip : slipList){
                if (slip.getProductList().get(i).getProductId()== ProductCode){
                    searchOfProductResult = storeKeeper.getKeeperName();

                    i++;
                }
            }
        }

        return searchOfProductResult;
    }


}
