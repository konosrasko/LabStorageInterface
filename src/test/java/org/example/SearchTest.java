package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    @Test
    void searchTest(){
        Storage storage = new Storage();

        storage.addSpots(1,2,3);
        storage.addSpots(2,2,3);
        storage.addSpots(3,2,3);
        storage.addSpots(4,2,3);

        EntrySlip entrySlip = new EntrySlip();
        Search search = new Search();
        StoreKeeper storeKeeper = new StoreKeeper();

        entrySlip.addProduct(1,"test",ProductCategory.LIFO,"test");
        entrySlip.addProduct(2,"test",ProductCategory.LIFO,"test");
        entrySlip.addProduct(3,"test",ProductCategory.LIFO,"test");


        storage.addStoreKeeper(1,"test");
        storage.addStoreKeeper(1,"test");
        storage.addStoreKeeper(1,"test");
        storage.addStoreKeeper(1,"test");

        storeKeeper.addSlip(entrySlip);

        search.searchOfProduct(1,storage.getStoreKeeperList(),storeKeeper.getEntrySlipList());
        assertEquals("test",search.searchOfProduct(1,storage.getStoreKeeperList(),storeKeeper.getEntrySlipList()));

    }

}