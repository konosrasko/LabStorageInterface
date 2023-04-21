package org.example;

import org.junit.jupiter.api.Test;

class StorageTest {
    Storage storage = new Storage();
    Spot spots = new Spot();

    StoreKeeper st1 = new StoreKeeper();
    Slip s1 = new Slip();


    @Test
    void assignProduct() {
        s1.addProductList(1, ProductCategory.FIFO,"test","kg",2);
        s1.addProductList(2, ProductCategory.FIFO,"test","kg",2);
        s1.addProductList(3, ProductCategory.LIFO,"test","kg",2);

        st1.addSlip(s1);
        System.out.println(st1);
        st1.setProductList();
        storage.addSpots(0,0,0,0);
        storage.addSpots(0,0,0,1);
        storage.addSpots(0,0,0,2);

    }

    @Test
    void emptySpots(){

        s1.addProductList(0,ProductType.LIFO,"test","kilos",10);


        storage.addSpots(0,0,0,1);
        storage.addSpots(0,0,0,30);
        storage.addSpots(0,0,0,10);
        storage.addSpots(0,0,0,20);
        st1.assignProduct(10,1,storage.getSpotsList());
        st1.assignProduct(20,2,storage.getSpotsList());
        st1.assignProduct(30,3,storage.getSpotsList());
        


        assertEquals(1,storage.emptySpots());


    }

}