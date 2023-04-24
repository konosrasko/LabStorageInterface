package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void productDateTest(){
        EntrySlip entrySlip1 = new EntrySlip();
        EntrySlip entrySlip2 = new EntrySlip();
        Product product = new Product();


        entrySlip1.addProduct(1,ProductCategory.LIFO,"test");
        entrySlip1.addProduct(2,ProductCategory.LIFO,"test");

        entrySlip2.addProduct(3,ProductCategory.LIFO,"test");
        entrySlip2.addProduct(4,ProductCategory.FIFO,"test");

        System.out.println(product.getEntryDate() +"   "+entrySlip1.getEntryDate());
    }

}