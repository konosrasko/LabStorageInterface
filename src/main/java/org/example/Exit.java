package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.*;

import static org.example.ProductCategory.FIFO;

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

    public List exitSlip(int pid, @NotNull List<Spot> spotList, @NotNull List<Product> productList){

        if (productList.get(pid).getProductGeneralType().equals(FIFO)){


            String category = productList.get(pid).getCategory();
            String type = productList.get(pid).getProductGeneralType();
            Collections.sort(, Comparator.comparing(Date::getDate));



            for(Spot spot : spotList){
                if (spot.getProductId()==pid){
                exitSlipList.add(new Exit(spot.getProductId(),ExitDesc));
                spot.setProductId(0);

                }
            }

        }else {
            for(Spot spot : spotList){
                if (spot.getProductId()==pid){
                    exitSlipList.add(new Exit(spot.getProductId(),ExitDesc));
                    spot.setProductId(0);

                }
            }
        }

        return exitSlipList;
    }


    public LocalTime getExitDate() {
        return exitDate;
    }



    public void exitProduct(){
        Collections.sort(exitSlipList);
        for (Object exit : exitSlipList) {
            System.out.println(exit);
        }
    }
}
