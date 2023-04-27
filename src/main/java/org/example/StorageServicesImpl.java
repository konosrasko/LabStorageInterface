package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StorageServicesImpl implements StorageServices{
    @Override
    public Storage findStorage(int id) {
        return null;
    }

    @Override
    public Spot findSpot(Storage storage, int productId) {

        int spotId = storage.getSpotList().get(productId).getSpotID();
        return storage.getSpotList().get(spotId);
    }

    @Override
    public void entrySlip(Storage storage,EntrySlip slip, int storekeeperId) {
        entrySlips.add(slip);
        storeKeeperList.get(storekeeperId).addSlip(slip);
        productList.addAll(slip.getProductList());
    }


    @Override
    public void assign(Storage storage,int slipId) {
        for (Product product : entrySlips.get(slipId).getProductList() ){
            for (Spot spot : spotList){
                if (spot.getProductId() == 0 ){
                    spot.setProductId(product.getProductId());
                    break;
                }
            }
        }
        //clear
    }

    @Override
    public List exit(Storage storage,int exitSlipId, int generalId, int quantity) {
        Exit exit = new Exit(exitSlipId, generalId, quantity);

        int i = 0;
        if (productList.get(generalId).getProductCategory().equals(ProductCategory.FIFO)) {
            productList = productList.stream()
                    .sorted((Comparator.comparing(Product::getProductId)))
                    .collect(Collectors.toList());

            for (Spot spot : spotList) {
                while (quantity>=0) {
                    if (productList.get(i).getGeneralId() == generalId) {
                        exit.getExitSlipList().add(productList.get(i).getProductId());
                        spot.setProductId(0);
                        productList.remove(i);
                        quantity--;
                    } else {
                        i++;
                    }

                }

            }
        } else {
            productList = productList.stream()
                    .sorted((Comparator.comparing(Product::getProductId)).reversed())
                    .collect(Collectors.toList());
            for (Spot spot : spotList) {
                while (quantity>=0) {
                    if (productList.get(i).getGeneralId() == generalId) {
                        exit.getExitSlipList().add(productList.get(i).getProductId());
                        spot.setProductId(0);
                        productList.remove(i);
                        quantity--;
                    } else {
                        i++;
                    }
                }

            }
        }
        return exit.getExitSlipList();
    }


    @Override
    public StoreKeeper searchStorekeeper(Storage storage,int productId) {
        int keeperId = storeKeeperList.get(productId).getKeeperId();
        return storeKeeperList.get(keeperId);
    }

    @Override
    public Spot searchSpot(Storage storage,int productId) {
        for (Spot spot : spotList){
            if (spot.getProductId() == productId){
                int spotId = spot.getSpotID();
                return spotList.get(spotId);
            }
        }
        return null;
    }
}
