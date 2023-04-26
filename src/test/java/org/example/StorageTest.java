package org.example;

import org.junit.jupiter.api.Test;

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

        slip.addProduct(0,0,ProductCategory.FIFO,"ena");
        slip.addProduct(1,0,ProductCategory.FIFO,"duo");
        slip.addProduct(2,0,ProductCategory.FIFO,"tria");
        slip.addProduct(3,1,ProductCategory.LIFO,"tessera");
        slip.addProduct(4,1,ProductCategory.LIFO,"pente");

        storage.entrySlip(slip,1);
        storage.assign(0);

        storage.exit(1,1,0);

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

        slip.addProduct(1,1,ProductCategory.FIFO,"ena");
        slip.addProduct(2,2,ProductCategory.FIFO,"ena");
        slip.addProduct(3,2,ProductCategory.FIFO,"ena");
        slip.addProduct(4,1,ProductCategory.FIFO,"ena");
        slip.addProduct(5,3,ProductCategory.FIFO,"ena");


        EntrySlip slip2 = new EntrySlip();

        slip2.addProduct(1,1,ProductCategory.FIFO,"ena");
        slip2.addProduct(2,3,ProductCategory.FIFO,"ena");
        slip2.addProduct(3,2,ProductCategory.FIFO,"ena");
        slip2.addProduct(4,1,ProductCategory.FIFO,"ena");
        storage.entrySlip(slip,1);
        storage.entrySlip(slip2,1);

//        System.out.println(storage.getStoreKeeperList().get(1).getEntrySlipList().size());
//        System.out.println(storage.getStoreKeeperList().get(2).getEntrySlipList().size());


    }
}







