package org.example;
import java.util.*;
import java.util.stream.Collectors;


public class Storage implements  StorageServices{
    private int storageID;
    private String storageName;
    private List<Spot> spotList = new ArrayList<>();
    private List<StoreKeeper> storeKeeperList = new ArrayList<>();
    private List<EntrySlip> entrySlips = new ArrayList<>();

    private List<Product> productList = new ArrayList<>();

    public Storage(){}


    public Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int spotID ,int corridor, int shelf){
        spotList.add(new Spot(spotID,corridor,shelf));
    }

    public void addStoreKeeper(int employeeId ,String employeeName){
        storeKeeperList.add(new StoreKeeper(employeeName,employeeId));
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public Storage findStorage(int id) {
        return null;
    }

    @Override
    public Spot findSpot(int productId) {
        int spotId = spotList.get(productId).getSpotID();
        return spotList.get(spotId);
    }

    @Override
    public void entrySlip(EntrySlip slip, int storekeeperId) {
        entrySlips.add(slip);
        storeKeeperList.get(storekeeperId).addSlip(slip);
        productList.addAll(slip.getProductList());
    }


    @Override
    public void assign(int slipId) {
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
    public List exit(int exitSlipId, int generalId, int quantity) {
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
    public StoreKeeper searchStorekeeper(int productId) {
        int keeperId = storeKeeperList.get(productId).getKeeperId();
        return storeKeeperList.get(keeperId);
    }

    @Override
    public Spot searchSpot(int productId) {
        for (Spot spot : spotList){
            if (spot.getProductId() == productId){
                int spotId = spot.getSpotID();
                return spotList.get(spotId);
            }
        }
        return null;
    }
}
