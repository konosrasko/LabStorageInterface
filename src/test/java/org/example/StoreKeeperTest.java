package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

class StoreKeeperTest {
    @Test
    void storekeeperTest(){
        Slip slip1 = new Slip();
        StoreKeeper keeper = new StoreKeeper(1,"kostas");
        keeper.addProductList(1,ProductType.LIFO,"test1","10",10);
        System.out.println(keeper);
    }

}