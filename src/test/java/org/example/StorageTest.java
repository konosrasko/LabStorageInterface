package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    Storage storage = new Storage();
    Spots spots = new Spots();

    StoreKeeper st1 = new StoreKeeper();
    Slip s1 = new Slip();

    @Test
    void storage() {

    }

    @Test
    void addSpots() {


    }

    @Test
    void addStoreKeeper() {
    }

    @Test
    void assignProduct() {
        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);

        st1.addSlip(s1);
        System.out.println(st1);
        st1.setProductList();
        storage.addSpots(0,0,0,0);
        storage.addSpots(0,0,0,1);
        storage.addSpots(0,0,0,2);

       // storage.assignProduct(0,1);
    }

    @Test
    void getStorageID() {
    }

    @Test
    void getStorageName() {
    }
}