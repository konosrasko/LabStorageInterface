package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignTest {
    @Test
    void assignTest(){
        Storage storage = new Storage();

        storage.addSpots(1,1,1);
        storage.addSpots(2,1,1);
        storage.addSpots(3,1,1);
        Spot spot = new Spot();

        EntrySlip entrySlip1 = new EntrySlip();
        entrySlip1.addProduct(1,"test",ProductCategory.LIFO,"test");
        entrySlip1.addProduct(2,"test",ProductCategory.LIFO,"test");

        Assign assign = new Assign();
        assign.setProductList(entrySlip1);
        assign.assignProduct(storage.getSpotsList());


    }

}