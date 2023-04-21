package org.example;

import java.util.ArrayList;
import java.util.List;

public class EntrySlip {

    private List<Product> productList = new ArrayList<>();
    public EntrySlip(){

    }

    public void addProduct(int productId, Enum type, String desc){
        productList.add(new Product(productId,type,desc));
    }

    public List<Product> getProductList() {
        return productList;
    }





}
