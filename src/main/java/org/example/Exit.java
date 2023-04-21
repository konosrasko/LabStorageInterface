package org.example;

import java.util.ArrayList;
import java.util.List;
public class Exit {
    private int ExitSlip;
    private String ExitDesc;
    List exitSlipList = new ArrayList();

    public Exit(int ExitSlip, String ExitDesc){
        this.ExitSlip=ExitSlip;
        this.ExitDesc=ExitDesc;
    }

    public List exitSlip(int pid,List<Spot> spotList){
        int i=0;
        for(Spot spot : spotList){
            if (spotList.get(i).getProductId()==pid){
                exitSlipList.add(new Exit(spotList.get(i).getProductId(),ExitDesc));
                spot.setProductId(0);

            }
            i++;
        }
        return exitSlipList;
    }


}
