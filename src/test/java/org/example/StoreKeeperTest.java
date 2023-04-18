package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreKeeperTest {
    Storage storage = new Storage();
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
    void SearchProduct(){
        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);

        st1.addSlip(s1);

        s2.addProductList(4,ProductType.LIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        st2.addSlip(s2);



        assertEquals(1,st1.searchProduct(1,s1.getProductList()));

    }
    @Test
    void searchSpot(){
        Storage storage1= new Storage();
        storage1.addSpots(0,0,0,0);
        storage1.addSpots(0,0,0,1);
        storage1.addSpots(0,0,0,2);

        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);

        st1.addSlip(s1);

        s2.addProductList(4,ProductType.LIFO,"test","kg",2);
        s2.addProductList(5,ProductType.FIFO,"test","kg",2);
        s2.addProductList(6,ProductType.FIFO,"test","kg",2);
        st2.addSlip(s2);



        assertEquals(1,st1.searchSpots(1,storage1.getSpotsList()));
    }

    @Test
    void assignProduct() {
        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);
        storage.addSpots(0,0,0,0);
        storage.addSpots(0,0,0,1);
        storage.addSpots(0,0,0,2);
        st1.addSlip(s1);
        st1.assignProduct(0,1,storage.getSpotsList());
        assertEquals(storage.getSpotsList().get(0).getProductId(),1);
    }


    @Test
    void removeProduct() {
        s1.addProductList(1,ProductType.FIFO,"test","kg",2);
        s1.addProductList(2,ProductType.FIFO,"test","kg",2);
        s1.addProductList(3,ProductType.LIFO,"test","kg",2);
        storage.addSpots(0,0,0,0);
        storage.addSpots(0,0,0,1);
        storage.addSpots(0,0,0,2);
        st1.addSlip(s1);
        st1.assignProduct(0,1,storage.getSpotsList());
        st1.removeProduct(0,storage.getSpotsList());
        assertEquals(storage.getSpotsList().get(0).getProductId(),0);
    }
}
