package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {

    Storage storage = new Storage();
    @Test
    void EntryAssign() {


        storage.setStorageName("ena");
        storage.setStorageID(1);
        storage.addStoreKeeper(1,"takhs");
        storage.addSpots(0,1,1);
        storage.addSpots(1,1,2);

        EntrySlip eS = new EntrySlip();
        eS.addProduct(1,"τεστ",ProductCategory.FIFO,"Tipo");
        eS.addProduct(2,"τεστ",ProductCategory.FIFO,"Tipo");
        assertEquals(eS.getProductList().size(),2);

        Assign assign = new Assign();
        StoreKeeper storeKeeper = new StoreKeeper();
        storeKeeper.addSlip(eS);
        assign.setProductList(eS);
        assign.assignProduct(storage.getSpotsList());
        assertEquals(assign.assignProduct(storage.getSpotsList()).size(),2);

    }

    @Test
    void searchExit(){
            storage.setStorageName("ena");
            storage.setStorageID(1);

            storage.addSpots(1,2,3);
            storage.addSpots(2,2,3);
            storage.addSpots(3,2,3);
            storage.addSpots(4,2,3);

        StoreKeeper storeKeeper = new StoreKeeper();
        EntrySlip entrySlip = new EntrySlip();
        Search search = new Search();

        entrySlip.addProduct(1,"test",ProductCategory.LIFO,"test");
        entrySlip.addProduct(2,"test",ProductCategory.LIFO,"test");
        entrySlip.addProduct(3,"test",ProductCategory.LIFO,"test");

        storeKeeper.addSlip(entrySlip);

            Assign assign = new Assign();
        assign.setProductList(entrySlip);
        assign.assignProduct(storage.getSpotsList());


            storage.addStoreKeeper(1,"test");
            storage.addStoreKeeper(2,"test");
            storage.addStoreKeeper(3,"test");
            storage.addStoreKeeper(4,"test");

            storeKeeper.addSlip(entrySlip);

            search.searchOfProduct(1, storage.getStoreKeeperList(),storeKeeper.getSlipList());
            assertEquals("test",search.searchOfProduct(1, storage.getStoreKeeperList(),storeKeeper.getSlipList()));



        assertEquals(1, storage.getStorageID());
        Exit exit = new Exit();

        exit.exitSlip(1, storage.getSpotsList(),entrySlip.getProductList());
        exit.exitSlip(2, storage.getSpotsList(),entrySlip.getProductList());
        assertEquals(2,exit.getExitSlipList().size());

        }




        @Test
    void allaround(){
            Storage storage = new Storage();

            this.storage.setStorageName("ena");
            this.storage.setStorageID(1);


            StoreKeeper storeKeeper = new StoreKeeper();

            this.storage.addStoreKeeper(1,"ena");


            this.storage.addSpots(1,2,3);
            this.storage.addSpots(2,2,3);
            this.storage.addSpots(3,2,3);
            this.storage.addSpots(4,2,3);
            this.storage.addSpots(5,1,2);
            this.storage.addSpots(6,1,2);
            this.storage.addSpots(7,1,2);
            this.storage.addSpots(8,1,2);
            this.storage.addSpots(9,1,2);

            EntrySlip entrySlip = new EntrySlip();

            entrySlip.addProduct(1,"test1",ProductCategory.FIFO,"ena");
            entrySlip.addProduct(2,"test2",ProductCategory.LIFO,"duo");
            entrySlip.addProduct(2,"test3",ProductCategory.LIFO,"tria");
            entrySlip.addProduct(1,"test4",ProductCategory.FIFO,"tessera");
            entrySlip.addProduct(1,"test5",ProductCategory.FIFO,"pente");
            entrySlip.addProduct(2,"test6",ProductCategory.LIFO,"exi");
            entrySlip.addProduct(1,"test7",ProductCategory.FIFO,"efta");

            storeKeeper.addSlip(entrySlip);



            Assign assign = new Assign();

            assign.setProductList(entrySlip);
            assign.assignProduct(this.storage.getSpotsList());


            //Search
            Search search = new Search();
            search.searchOfProduct(6, this.storage.getStoreKeeperList(),storeKeeper.getSlipList());
            assertEquals("ena",search.searchOfProduct(1, this.storage.getStoreKeeperList(),storeKeeper.getSlipList()));


            Exit exit = new Exit();
            exit.exitSlip(1, this.storage.getSpotsList(),entrySlip.getProductList());
            exit.exitSlip(2, this.storage.getSpotsList(),entrySlip.getProductList());
            //assertEquals(1,exit.getExitSlipList().size());

            for (Product product : entrySlip.getProductList()) {
                System.out.print(product.getProductId());
                System.out.println(product.getCategory());
                }
            }
        }
