package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        storage.getEntrySlips().add(slip);
        storage.getStoreKeeperList().get(storekeeperId).addSlip(slip);
        storage.getProductList().addAll(slip.getProductList());
    }


    @Override
    public void assign(Storage storage,int slipId) {
        for (Product product : storage.getEntrySlips().get(slipId).getProductList() ){
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
            Collections.sort(storage.getProductList(),Comparator.comparing(Product::getProductId));

            for (Spot spot : storage.getSpotList()) {
                while (quantity>=0) {
                    if (storage.getProductList().get(i).getGeneralId() == generalId) {
                        exit.getExitSlipList().add(storage.getProductList().get(i).getProductId());
                        spot.setProductId(0);
                        storage.getProductList().remove(i);
                        quantity--;
                    } else {
                        i++;
                    }

                }

            }
        } else {
            Collections.sort(storage.getProductList(),Comparator.comparing(Product::getProductId).reversed());
            for (Spot spot : storage.getSpotList()) {
                while (quantity>=0) {
                    if (storage.getProductList().get(i).getGeneralId() == generalId) {
                        exit.getExitSlipList().add(storage.getProductList().get(i).getProductId());
                        spot.setProductId(0);
                        storage.getProductList().remove(i);
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
