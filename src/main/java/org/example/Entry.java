package org.example;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    private List<Product> products = new ArrayList<>();
    public Entry(){
    }


    public void setProductList(EntrySlip slip) {
        for (Product product : slip.getProductList() ) {
                products.add(product);
        }
    }

    public List assignProduct(List<Spot> spotList) {
        int i=0;
        for(Spot spot : spotList) {
                if (spot.getProductId() == 0) {
                    spot.setProductId(products.get(i).getProductId());
                    i++;
                }
        }
        products.clear();
        return spotList;
    }


}

