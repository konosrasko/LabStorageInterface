package org.example;

import java.util.List;

public class Entry {
    private List<Product> entrySlips;
    public Entry(){
    }




    public void setProductList(EntrySlip slip) {
        for (Product product : slip.getProductList() ) {
                entrySlips.add(product);
        }
    }

    public List assignProduct(int id,int pid,List<Spot> spotList) {
        for (Product product : entrySlips) {
            for(Spot spot : spotList) {
                if (spot.getSpotID() == id) {
                    spot.setProductId(pid);
                }
            }
        }
        return spotList;
    }


}

