package org.example;

import java.util.ArrayList;
import java.util.List;

public class Slip {
    private List<Product> productList = new ArrayList<>();

    public void addProductList(){
        productList.add(new Product());
    }

    public List<Product> getProductList() {
        return productList;
    }


}
