package org.example;

import org.junit.jupiter.api.Test;

class StorageTest {
    Storage s1 = new Storage();
    @Test
    void storage(){
        s1.setStorageName("ena");
        s1.setStorageID(1);

    }

    @Test
    void addSpots() {
        s1.addSpots(1,1,1);
        s1.addSpots(2,1,2);

    }

    @Test
    void addStoreKeeper() {
        s1.addStoreKeeper(1,"ta");
    }

    @Test
    void getSpotsList() {
        s1.getSpotsList();
    }

    @Test
    void setEntrySlips() {
        s1.setStorageName("ena");
        s1.setStorageID(1);
        s1.addStoreKeeper(1,"takhs");
        s1.addSpots(0,1,1);
        s1.addSpots(1,1,2);
        EntrySlip eS = new EntrySlip();
        eS.addProduct(1,ProductCategory.FIFO,"Tipo");
        eS.addProduct(2,ProductCategory.FIFO,"Tipo");
        Assign assign = new Assign();
        StoreKeeper storeKeeper = new StoreKeeper();
        storeKeeper.addSlip(eS);
        assign.setProductList(eS);
        assign.assignProduct(s1.getSpotsList());
    }

    @Test
    void getEntrySlips() {
        s1.getEntrySlips();
    }

    @Test
    void emptySpots() {
    }

    @Test
    void getStorageID() {
    }

    @Test
    void getStorageName() {
    }
}