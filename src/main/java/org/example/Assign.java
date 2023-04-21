package org.example;

import java.util.List;

public class Assign {

    public List assignProduct(int id, int pid, List<Spot> spotList){
        for (Spot spot : spotList){
            if ((spot.getSpotID() == id) && (spot.getProductId()==0)) {
                spot.setProductId(pid);
            }
        }
        return spotList;
    }
}
