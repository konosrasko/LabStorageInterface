package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {

    Storage s1 = new Storage();
    @Test
    void EntryAssign() {


        s1.setStorageName("ena");
        s1.setStorageID(1);
        s1.addStoreKeeper(1,"takhs");
        s1.addSpots(0,1,1);
        s1.addSpots(1,1,2);

        EntrySlip eS = new EntrySlip();
        eS.addProduct(1,"τεστ",ProductCategory.FIFO,"Tipo");
        eS.addProduct(2,"τεστ",ProductCategory.FIFO,"Tipo");
        assertEquals(eS.getProductList().size(),2);

        Assign assign = new Assign();
        StoreKeeper storeKeeper = new StoreKeeper();
        storeKeeper.addSlip(eS);
        assign.setProductList(eS);
        assign.assignProduct(s1.getSpotsList());
        assertEquals(assign.assignProduct(s1.getSpotsList()).size(),2);

    }

    @Test
    void searchExit(){

            s1.addSpots(1,2,3);
            s1.addSpots(2,2,3);
            s1.addSpots(3,2,3);
            s1.addSpots(4,2,3);

            EntrySlip entrySlip = new EntrySlip();
            Search search = new Search();
            StoreKeeper storeKeeper = new StoreKeeper();

            entrySlip.addProduct(1,"test",ProductCategory.LIFO,"test");
            entrySlip.addProduct(2,"test",ProductCategory.LIFO,"test");
            entrySlip.addProduct(3,"test",ProductCategory.LIFO,"test");


            s1.addStoreKeeper(1,"test");
            s1.addStoreKeeper(2,"test");
            s1.addStoreKeeper(3,"test");
            s1.addStoreKeeper(4,"test");

            storeKeeper.addSlip(entrySlip);

            search.searchOfProduct(1,s1.getStoreKeeperList(),storeKeeper.getSlipList());
            assertEquals("test",search.searchOfProduct(1,s1.getStoreKeeperList(),storeKeeper.getSlipList()));



            Exit exit = new Exit(1,"exitTest");

            exit.exitSlip(1,s1.getSpotsList(),entrySlip.getProductList());
            assertEquals(0,s1.getStorageID());

            exit.exitSlip(3,s1.getSpotsList(),entrySlip.getProductList());


        }

        @Test
        void lifoFifo(){

        }

    }
