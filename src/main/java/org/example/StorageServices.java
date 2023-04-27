package org.example;

import java.util.List;

public interface StorageServices {

    public Spot findSpot(Storage storage,int productId);

    public void entrySlip(Storage storage,EntrySlip slip , int storekeeperId);

    public void assign(Storage storage,int slipId, int storeKeeperId);

    public List exit(Storage storage,int exitSlipId, int generalId, int quantity);

    public StoreKeeper searchStorekeeper(Storage storage,int productId);



}
