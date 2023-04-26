package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitTest {
    @Test
    void ExitTest() {
        Storage storage = new Storage();
        Spot spot = new Spot();

        storage.addSpots(1, 2, 3);
        storage.addSpots(2, 2, 3);
        storage.addSpots(3, 2, 3);
        storage.addSpots(4, 2, 3);

        Slip slip = new Slip();
        Search search = new Search();
        StoreKeeper storeKeeper = new StoreKeeper();

        slip.addProduct(1,"pills", ProductCategory.LIFO, "test");
        slip.addProduct(2,"pills",  ProductCategory.LIFO, "test");
        slip.addProduct(3,"pills",  ProductCategory.LIFO, "test");


        storage.addStoreKeeper(1, "test");
        storage.addStoreKeeper(2, "test");
        storage.addStoreKeeper(3, "test");
        storage.addStoreKeeper(4, "test");

        storeKeeper.addSlip(slip);

        Exit exit = new Exit(1,"exitTest");

        exit.exitSlip(1,storage.getSpotsList(), slip.getProductList());
        assertEquals(0,storage.getStorageID());

    }

    @Test
    void exitTest2(){

    }

}