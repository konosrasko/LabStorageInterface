package org.example;

import java.util.List;

public interface StorageServices {

    public Storage findStorage(Storage storage,int storageId);


    public Spot findSpot(Storage storage,int productId);

    void entrySlip(Storage storage,EntrySlip slip , int storekeeperId);

    public void assign(Storage storage,int slipId);

    public List exit(Storage storage,int exitSlipId, int generalId, int quantity);

    public StoreKeeper searchStorekeeper(Storage storage,int productId);



}
