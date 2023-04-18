package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreKeeperTest {
    StoreKeeper st1 = new StoreKeeper();
    Slip s1 = new Slip();
    Slip s2 = new Slip();

    @Test
    void setSlipList() {

        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.FIFO,"test","kg",2);

        //st1.setSlipList(s1);

        s2.addProductList(4,ProductType.FIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        //st1.setSlipList(s2);
        System.out.println(st1);

    }

    @Test
    void ProductList(){

        Storage storage = new Storage();
        Spots spots = new Spots();
        storage.addSpots(1,1,1,1);
        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);

        st1.addSlip(s1);

        s2.addProductList(4,ProductType.LIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        st1.addSlip(s2);

        storage.addSpots(0,0,0,0);
        storage.addSpots(0,0,0,1);
        storage.addSpots(0,0,0,2);

        st1.assignProduct(1,1,storage.getSpotsList(1));

    }

    @Test
    void getKeeperName() {
    }

    @Test
    void setKeeperName() {
    }

    @Test
    void getKeeperId() {
    }

    @Test
    void setKeeperId() {
    }
}