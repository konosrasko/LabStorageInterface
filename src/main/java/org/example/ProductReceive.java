package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProductReceive {
    Map<StoreKeeper , Product> keeperProductMap = new HashMap<>();
    public ProductReceive(){

    }

    public Map<StoreKeeper, Product> getKeeperProductMap() {
        return keeperProductMap;
        }

}
