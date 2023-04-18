package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreKeeperTest {
    StoreKeeper st1 = new StoreKeeper(1,"1");
    StoreKeeper st2 = new StoreKeeper(2,"2");
    Slip s1 = new Slip();
    Slip s2 = new Slip();

    @Test
    void setSlipList() {

        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.FIFO,"test","kg",2);

        // st1.setSlipList(s1);

        s2.addProductList(4,ProductType.FIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        //st1.setSlipList(s2);
        System.out.println(st1);

    }

    @Test
    void ProductList(){

        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);

        st1.addSlip(s1);

        s2.addProductList(4,ProductType.LIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        st1.addSlip(s2);

        System.out.println(st1);
        st1.setProductList(s1.getProductList());

    }

    @Test
    void Search(){

        Storage storage = new Storage();

        storage.addSpots(1,1,1,1);
        storage.addSpots(1,1,1,2);
        storage.addSpots(1,1,1,3);
        storage.addSpots(1,1,1,4);

        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);

        st1.addSlip(s1);

        s2.addProductList(4,ProductType.LIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        st2.addSlip(s2);

        st1.searchPorduct(1,s1.getProductList());
        st2.searchPorduct(4,s2.getProductList());

        st1.searchSpots(1,storage.getSpotsList());
        st1.searchSpots(2,storage.getSpotsList());
    }
}
