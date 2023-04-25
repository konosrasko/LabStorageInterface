package org.example;

import jdk.jfr.Category;
import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


public class Exit {
    private int exitSlipId;
    private String exitSlipDesc;
    private LocalTime exitSlipDate;
    private List exitSlipList = new ArrayList();

    public Exit(){}

    public Exit(int exitSlipId, String exitSlipDesc){
        this.exitSlipId = exitSlipId;
        this.exitSlipDesc = exitSlipDesc;
        this.exitSlipDate = LocalTime.now();
    }

    public List exitSlip(int pid, @NotNull List<Spot> spotList, @NotNull List<Product> productList){


            if (productList.get(pid).getType().equals(ProductCategory.FIFO)){
                List<Product> pr = productList.stream()
                        .sorted(Comparator.comparing(Product::getCategory).reversed())
                        .collect(Collectors.toList());


                for (Spot spot: spotList){
                    if (spot.getProductId() == pid){
                        int index = pr.indexOf(pr.get(pid));
                        productList.remove(index);
                        exitSlipList.add(new Exit(spot.getProductId(), exitSlipDesc));
                        spot.setProductId(0);
                        break;
                    }
                }


            }else {

                for (Spot spot: spotList){
                    if (spot.getProductId() == pid){
                        List<Product> pr = productList.stream()
                                .sorted(Comparator.comparing(Product::getCategory))
                                .collect(Collectors.toList());
                        int index = pr.indexOf(pr.get(pid));
                        productList.remove(0);
                        exitSlipList.add(new Exit(spot.getProductId(), exitSlipDesc));
                        spot.setProductId(0);
                        break;
                    }
                }
            }


        return spotList;
    }

    public List<Exit> getExitSlipList() {
        return exitSlipList;
    }

    public LocalTime getExitSlipDate() {
        return exitSlipDate;
    }


}
