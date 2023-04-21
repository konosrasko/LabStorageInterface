package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest1 {
    Storage s1 = new Storage();
    StoreKeeper st1 = new StoreKeeper();
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
        s1.addSpots(0,1,1);
        s1.addSpots(1,1,2);
        s1.addStoreKeeper(1,"ta");
        EntrySlip eS = new EntrySlip();
        eS.addProduct(1,ProductCategory.FIFO,"Tipo");
        eS.addProduct(2,ProductCategory.FIFO,"Tipo");
        Entry entry = new Entry();
        entry.setProductList(eS);
        entry.assignProduct(s1.getSpotsList());
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