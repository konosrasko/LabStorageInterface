package org.example;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.util.List;

public class Entry {




    public void setProductList(EntrySlip slip, List<Spot> spotList) {
        for (Product product : slip) {
            for(Spot spot : spotList){
                spotList.assignProduct(product);
            }
        }
    }
}
