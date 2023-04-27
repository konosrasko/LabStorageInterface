package org.example;

import java.util.List;

public interface StorageServices {

    public Storage findStorage(int id);


    public Spot findSpot(int id);

    void entrySlip(EntrySlip slip , int storekeeperId);

    public void assign(int id);

    public List exit(int exitSlipId, int generalId, int quantity);

    public StoreKeeper searchStorekeeper(int productId);

    public Spot searchSpot(int productId);

}
