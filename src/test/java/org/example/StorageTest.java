package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {

    Storage storage = new Storage();
   /* @Test
    void EntryAssign() {


        storage.setStorageName("ena");
        storage.setStorageID(1);
        storage.addStoreKeeper(1,"takhs");
        storage.addSpots(0,1,1);
        storage.addSpots(1,1,2);

        Slip eS = new Slip();
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
        Slip slip = new Slip();
        Search search = new Search();

        slip.addProduct(1,"test",ProductCategory.LIFO,"test");
        slip.addProduct(2,"test",ProductCategory.LIFO,"test");
        slip.addProduct(3,"test",ProductCategory.LIFO,"test");

        storeKeeper.addSlip(slip);

            Assign assign = new Assign();
        assign.setProductList(slip);
        assign.assignProduct(storage.getSpotsList());


            storage.addStoreKeeper(1,"test");
            storage.addStoreKeeper(2,"test");
            storage.addStoreKeeper(3,"test");
            storage.addStoreKeeper(4,"test");

            storeKeeper.addSlip(slip);

            search.searchOfProduct(1, storage.getStoreKeeperList(),storeKeeper.getEntrySlipList());
            assertEquals("test",search.searchOfProduct(1, storage.getStoreKeeperList(),storeKeeper.getEntrySlipList()));



        assertEquals(1, storage.getStorageID());
        Exit exit = new Exit();

        exit.exitSlip(1, storage.getSpotsList(), slip.getProductList());
        assertEquals(1,exit.getExitSlipList().size());

        }




        @Test
    void allaround(){
            Storage storage = new Storage();

            this.storage.setStorageName("ena");
            this.storage.setStorageID(1);


            StoreKeeper storeKeeper = new StoreKeeper();
            StoreKeeper storeKeeper1 = new StoreKeeper();

            this.storage.addStoreKeeper(1,"ena");
            this.storage.addStoreKeeper(2,"duo");


            this.storage.addSpots(1,2,3);
            this.storage.addSpots(2,2,3);
            this.storage.addSpots(3,2,3);
            this.storage.addSpots(4,2,3);
            this.storage.addSpots(5,1,2);
            this.storage.addSpots(6,1,2);
            this.storage.addSpots(7,1,2);
            this.storage.addSpots(8,1,2);
            this.storage.addSpots(9,1,2);

            Slip slip = new Slip();
            Slip slip2 = new Slip();

            slip.addProduct(1,"test1",ProductCategory.FIFO,"ena");
            slip.addProduct(2,"test2",ProductCategory.LIFO,"duo");
            slip.addProduct(3,"test3",ProductCategory.LIFO,"tria");
            slip.addProduct(4,"test4",ProductCategory.FIFO,"tessera");
            slip.addProduct(5,"test5",ProductCategory.FIFO,"pente");
            slip.addProduct(6,"test6",ProductCategory.LIFO,"exi");
            slip.addProduct(7,"test7",ProductCategory.FIFO,"efta");

            storeKeeper.addSlip(slip);
            storage.getStoreKeeperList().get(0).addSlip(slip);



            Assign assign = new Assign();

            assign.setProductList(slip);
            assign.assignProduct(this.storage.getSpotsList());


            //Search
            Search search = new Search();
            search.searchOfProduct(6, this.storage.getStoreKeeperList(),storeKeeper.getEntrySlipList());
            assertEquals("ena",search.searchOfProduct(1, this.storage.getStoreKeeperList(),storeKeeper.getEntrySlipList()));

             slip.print();
            Exit exit = new Exit();
            exit.exitSlip(1, this.storage.getSpotsList(), slip.getProductList());
            exit.exitSlip(2, this.storage.getSpotsList(), slip.getProductList());
            assertEquals(2,exit.getExitSlipList().size());

            for (Product product : slip.getProductList()) {
                System.out.print(product.getProductId());
                System.out.println(product.getCategory());
                }
            }*/


    @Test
    void testing(){
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

        slip.addProduct(1,"test1",ProductCategory.FIFO,"ena");
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

        for (int i=1; i<storage.getStoreKeeperList().get(1).getEntrySlipList().get(1).getProductList().size(); i++ ) {
            for (int j = 0; j < storage.getStoreKeeperList().get(1).getEntrySlipList().get(1).getProductList().size(); j++) {
                System.out.println(storage.getStoreKeeperList().get(1).getEntrySlipList().get(i).getProductList().get(j).getProductId());
            }
        }


    }




}