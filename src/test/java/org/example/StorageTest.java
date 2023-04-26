package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {

    Storage storage = new Storage();

    @Test
    void testingAssignExit(){

        storage.addSpots(0,1,1);
        storage.addSpots(1,1,1);
        storage.addSpots(2,1,1);
        storage.addSpots(3,1,1);

        storage.addStoreKeeper(0,"ena");
        storage.addStoreKeeper(1,"duo");
        storage.addStoreKeeper(2,"tria");
        storage.addStoreKeeper(3,"tessera");
        storage.addStoreKeeper(4,"pente");

        EntrySlip slip = new EntrySlip();
        slip.setSlipId(1);

        slip.addProduct(0,1,ProductCategory.FIFO,"ena");
        slip.addProduct(1,1,ProductCategory.FIFO,"ena");
        slip.addProduct(2,1,ProductCategory.FIFO,"ena");
        slip.addProduct(3,2,ProductCategory.FIFO,"ena");
        slip.addProduct(4,2,ProductCategory.FIFO,"ena");

        storage.entrySlip(slip,1);
        storage.assign(0);

        storage.exit(1,1,3);

    }

    @Test
    void testingEntrySlip(){
        storage.setStorageID(1);
        storage.addStoreKeeper(1,"ena");
        storage.addStoreKeeper(2,"ena");
        storage.addStoreKeeper(3,"ena");
        storage.addStoreKeeper(4,"ena");
        storage.addStoreKeeper(5,"ena");

        storage.addSpots(1,1,1);
        storage.addSpots(2,1,1);
        storage.addSpots(3,1,1);
        storage.addSpots(4,1,1);


        EntrySlip slip = new EntrySlip();

        /*slip.addProduct(1,"test1",ProductCategory.FIFO,"ena");
        slip.addProduct(2,"test1",ProductCategory.FIFO,"ena");
        slip.addProduct(3,"test1",ProductCategory.FIFO,"ena");
        slip.addProduct(4,"test1",ProductCategory.FIFO,"ena");
        slip.addProduct(5,"test1",ProductCategory.FIFO,"ena");


        EntrySlip slip2 = new EntrySlip();

        slip2.addProduct(1,"test1",ProductCategory.FIFO,"ena");
        slip2.addProduct(2,"test1",ProductCategory.FIFO,"ena");
        slip2.addProduct(3,"test1",ProductCategory.FIFO,"ena");
        slip2.addProduct(4,"test1",ProductCategory.FIFO,"ena");
        storage.entrySlip(slip,1);
        storage.entrySlip(slip2,1);

//        System.out.println(storage.getStoreKeeperList().get(1).getEntrySlipList().size());
//        System.out.println(storage.getStoreKeeperList().get(2).getEntrySlipList().size());

*/
    }
}







