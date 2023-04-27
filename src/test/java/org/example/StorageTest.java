package org.example;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorageTest {

    Storage storage = new Storage();
    StorageServicesImpl storageServices = new StorageServicesImpl();


    @Test
    void testingAssignExit(){
        storage.setStorageID(1);
        storage.setStorageName("Apothiki");

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

        slip.addProduct(0,0,ProductCategory.LIFO,"ena");
        slip.addProduct(1,0,ProductCategory.LIFO,"duo");
        slip.addProduct(2,0,ProductCategory.LIFO,"tria");
        slip.addProduct(3,1,ProductCategory.FIFO,"tessera");
        slip.addProduct(4,1,ProductCategory.FIFO,"pente");

        storageServices.entrySlip(storage,slip,1);
        storageServices.assign(storage,0,1);


        storageServices.exit(storage,1,1,0);
        assertEquals(4,storage.getSortedProductList().size());

        storageServices.exit(storage,1,0,0);
        assertEquals(3,storage.getSortedProductList().size());


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
        storageServices.entrySlip(storage,slip,1);
        storageServices.entrySlip(storage,slip2,1);


    }


}


