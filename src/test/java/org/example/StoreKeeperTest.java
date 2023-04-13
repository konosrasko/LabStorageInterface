package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

class StoreKeeperTest {
    @Test
    void storekeeperTest(){
        Slip slip1 = new Slip();
        StoreKeeper keeper = new StoreKeeper(1,"kostas");
        slip1.addProductList(1,type.LIFO,"test1","10",10);
        keeper.setProductListSlip(slip1.getProductList());
        System.out.println(keeper);
    }

}