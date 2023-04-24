package org.example;

import java.util.ArrayList;
import java.util.List;

public class Assign {
    private List<Product> products = new ArrayList<>();
    public Assign(){
    }


    public void setProductList(EntrySlip slip) {
        for (Product product : slip.getProductList() ) {
                products.add(product);
        }
    }

    public List assignProduct(List<Spot> spotList) {
        for(Spot spot : spotList) {
                if (spot.getProductId() == 0) {
                    spot.setProductId(spot.getProductId());
                }
        }
        products.clear();
        return spotList;
    }


}

