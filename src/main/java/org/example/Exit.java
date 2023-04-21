package org.example;



import java.util.ArrayList;
import java.util.List;
public class Exit {
    private int slipExitSlip;
    private String slipExitDesc;
    private List<Spot> spotList = new ArrayList<>();

    public Exit(int slipExitSlip, String slipExitDesc){
        this.slipExitSlip=slipExitSlip;
        this.slipExitDesc=slipExitDesc;
    }

    public List exitSlip(int pid){
        List exitSlipList = new ArrayList();
        int i=0;
        for(Spot spot : spotList){
            if (spotList.get(i).getProductId()==pid){
                exitSlipList.add(spotList.get(i).getProductId());
                spot.setProductId(0);
            }
        }
        return exitSlipList;
    }


}
