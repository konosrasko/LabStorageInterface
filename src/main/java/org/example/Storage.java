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


    public void Storage(int storageID, String storageName){
        this.storageID=storageID;
        this.storageName=storageName;
    }

    public void addSpots(int spotID ,int corridor, int shelf){
        spotList.add(new Spot(spotID,corridor,shelf));
    }

    public void addStoreKeeper(int employeeId ,String employeeName){
        storeKeeperList.add(new StoreKeeper(employeeName,employeeId));
    }

    public List<Spot> getSpotsList() {
        return spotList;
    }

    public List<EntrySlip> getEntrySlips() {
        return entrySlips;
    }

    public int emptySpots(){
        int s = 0;
        for (Spot spot : spotList){
            if (spot.getProductId()==0){
                s +=1;
            }
        }
        return s;
    }

    public int getStorageID() {
        return storageID;
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageName() {
        return storageName;
    }

    public List<StoreKeeper> getStoreKeeperList() {
        return storeKeeperList;
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
    public void exit(int exitSlipId,int generalId, int quantity) {
        Exit exit = new Exit(exitSlipId, generalId, quantity);
        if (productList.get(generalId).getProductCategory().equals(ProductCategory.LIFO)){
        productList = productList.stream()
                .sorted((Comparator.comparing(Product::getCategory)))
                .collect(Collectors.toList());
        int i=0;
        for (Spot spot : spotList) {

            if (productList.get(i).getCategory() == generalId) {
                spot.setProductId(0);
                //+ lista gia ektypwsh
                productList.remove(i);

            } else {
                i++;
            }
        }
        }else{

        }
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
