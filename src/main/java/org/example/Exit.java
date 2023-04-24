package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Exit {
    private int ExitSlip;
    private String ExitDesc;
    private LocalTime exitDate;
    List exitSlipList = new ArrayList();

    public Exit(int ExitSlip, String ExitDesc){
        this.ExitSlip=ExitSlip;
        this.ExitDesc=ExitDesc;
        this.exitDate = LocalTime.now();
    }

    public List exitSlip(int pid, @NotNull List<Spot> spotList){
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


    public LocalTime getExitDate() {
        return exitDate;
    }
}
