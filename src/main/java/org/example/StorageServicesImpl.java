package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StorageServicesImpl implements StorageServices{
    @Override
    public Storage findStorage(Storage storage,int storageId) {
        return null;
    }

    @Override
    public Spot findSpot(Storage storage, int productId) {

        int spotId = storage.getSpotList().get(productId).getSpotID();
        return storage.getSpotList().get(spotId);
    }

    @Override
    public void entrySlip(Storage storage,EntrySlip slip, int storekeeperId) {
        storage.getStoreKeeperList().get(storekeeperId).addSlip(slip);
        storage.getSortedProductList().addAll(slip.getProductList());
    }


    @Override
    public void assign(Storage storage,int slipId, int storeKeeperId) {
        for (Product product : storage.getStoreKeeperList().get(storeKeeperId).getEntrySlipList().get(slipId).getProductList() ){
            for (Spot spot : storage.getSpotList()){
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
        if (storage.getStoreKeeperList().get(generalId).equals(ProductCategory.FIFO)) {
            Collections.sort(storage.getSortedProductList(),Comparator.comparing(Product::getProductId));

            for (Spot spot : storage.getSpotList()) {
                while (quantity>=0) {
                    if (storage.getSortedProductList().get(i).getGeneralId() == generalId) {
                        exit.getExitSlipList().add(storage.getSortedProductList().get(i).getProductId());
                        spot.setProductId(0);
                        storage.getSortedProductList().remove(i);
                        quantity--;
                    } else {
                        i++;
                    }

                }

            }
        } else {
            Collections.sort(storage.getSortedProductList(),Comparator.comparing(Product::getProductId).reversed());
            for (Spot spot : storage.getSpotList()) {
                while (quantity>=0) {
                    if (storage.getSortedProductList().get(i).getGeneralId() == generalId) {
                        exit.getExitSlipList().add(storage.getSortedProductList().get(i).getProductId());
                        spot.setProductId(0);
                        storage.getSortedProductList().remove(i);
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
        int keeperId = storage.getStoreKeeperList().get(productId).getKeeperId();
        return storage.getStoreKeeperList().get(keeperId);
    }


}
