package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.ProductCategory.FIFO;

public class Exit {
    private int ExitSlip;
    private String ExitDesc;
    private LocalTime exitDate;
    private List<Exit> exitSlipList = new ArrayList();

    public Exit(int ExitSlip, String ExitDesc){
        this.ExitSlip=ExitSlip;
        this.ExitDesc=ExitDesc;
        this.exitDate = LocalTime.now();
    }

    public List exitSlip(int pid, @NotNull List<Spot> spotList, @NotNull List<Product> productList){


        String category = productList.get(pid).getCategory();
//        String type = productList.get(pid).getProductGeneralType();
//        Collections.sort(productList,Comparator.comparing(Product::getProductDate));



            if (productList.get(pid).getProductGeneralType().equals(FIFO)){

                productList.stream()
                        .filter(product -> product.getCategory().equals(category))
                        .sorted(Comparator.comparing(Product::getProductDate).reversed())
                        .collect(Collectors.toList());

                for (Spot spot: spotList){
                    if (spot.getProductId() == pid){
                        productList.remove(productList.get(pid).getProductId());
                        exitSlipList.add(new Exit(spot.getProductId(),ExitDesc));
                        spot.setProductId(0);
                    }
                }


            }else {
                productList.stream()
                        .filter(product -> product.getCategory().equals(category))
                        .sorted(Comparator.comparing(Product::getProductDate))
                        .collect(Collectors.toList());

                for (Spot spot: spotList){
                    if (spot.getProductId() == pid){
                        productList.remove(productList.get(pid).getProductId());
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


}
