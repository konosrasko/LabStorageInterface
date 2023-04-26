package org.example;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void productDateTest(){
        Slip slip1 = new Slip();
        Slip slip2 = new Slip();
        Product product = new Product();


        slip1.addProduct(1,"test",ProductCategory.LIFO,"test");
        slip1.addProduct(2,"test",ProductCategory.LIFO,"test");

        slip2.addProduct(3,"test",ProductCategory.LIFO,"test");
        slip2.addProduct(4,"test",ProductCategory.FIFO,"test");

        System.out.println(product.getEntryDate() +"   "+ slip1.getEntryDate());
    }

}