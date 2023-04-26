package org.example;

import java.util.ArrayList;
import java.util.List;

public class Assign {
    private List<Product> products = new ArrayList<>();
    public Assign(){
    }


    public void setProductList(Slip slip) {
        for (Product product : slip.getProductList() ) {
                products.add(product);
        }
    }

    public List assignProduct(List<Spot> spotList) {
        int i=0;
        for(Spot spot : spotList) {
                if (spot.getProductId() == 0) {
                    while(i<products.size()) {
                        spot.setProductId(products.get(i).getProductId());
                        i++;
                        break;
                    }
                }

        }
        products.clear();
        return spotList;
    }


}

