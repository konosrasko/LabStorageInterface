package org.example;

import java.util.ArrayList;
import java.util.List;

public class Slip {
    private List<Product> productList = new ArrayList<>();

    public void addProductList(int productId, Enum type, String desc, String quantityMes, int quantity){
        productList.add(new Product(productId, type,  desc,  quantityMes,  quantity));
    }

    public List<Product> getProductList() {
        return productList;
    }


}
