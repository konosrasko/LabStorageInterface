package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StorageServicesImpl implements StorageServices{


    @Override
    public int findSpot(@NotNull Storage storage, int productId) {
        if (productId >= storage.getSpotList().size() || productId < 0) {
            throw new IndexOutOfBoundsException("Invalid product ID: " + productId);
        }
        return storage.getSpotList().get(productId).getSpotID();
    }
    @Override
    public void entrySlip(@NotNull Storage storage, EntrySlip slip, int storekeeperId) {
        if (slip == null) {
            throw new NullPointerException("Entry slip cannot be null");
        }
        storage.getStoreKeeperList().get(storekeeperId).addSlip(slip);
        storage.getSortedProductList().addAll(slip.getProductList());
    }

    @Override
    public void assign(@NotNull Storage storage, int slipId, int storeKeeperId) {
        List<Product> productList = storage.getStoreKeeperList().get(storeKeeperId).getEntrySlipList().get(slipId).getProductList();
        List<Spot> spotList = storage.getSpotList();


        if (spotList == null || spotList.isEmpty()) {
            throw new RuntimeException("No spots available to assign products to");
        }


        for (Product product : productList) {
            boolean assigned = false;
            for (Spot spot : spotList) {
                if (spot.getProductId() == 0) {
                    spot.setProductId(product.getProductId());
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                throw new RuntimeException("No spots available to assign products to");
            }
        }
    }

    @Override
    public List exit(@NotNull Storage storage, int exitSlipId, int generalId, int quantity) {
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
    public StoreKeeper searchStorekeeper(@NotNull Storage storage, int productId) {
        int keeperId = storage.getStoreKeeperList().get(productId).getKeeperId();
        return storage.getStoreKeeperList().get(keeperId);
    }


}
