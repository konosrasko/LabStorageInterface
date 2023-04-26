package org.example;

import org.junit.jupiter.api.Test;

class AssignTest {
    @Test
    void assignTest(){
        Storage storage = new Storage();

        storage.addSpots(1,1,1);
        storage.addSpots(2,1,1);
        storage.addSpots(3,1,1);
        Spot spot = new Spot();

        Slip slip1 = new Slip();
        slip1.addProduct(1,"test",ProductCategory.LIFO,"test");
        slip1.addProduct(2,"test",ProductCategory.LIFO,"test");

        Assign assign = new Assign();
        assign.setProductList(slip1);
        assign.assignProduct(storage.getSpotsList());


    }

}