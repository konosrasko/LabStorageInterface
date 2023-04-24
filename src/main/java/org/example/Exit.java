package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;



public class Exit {
    private int exitSlipId;
    private String exitSlipDesc;
    private LocalTime exitSlipDate;
    private List exitSlipList = new ArrayList();

    public Exit(){}

    public Exit(int ExitSlipId, String exitSlipDesc){
        this.exitSlipId = ExitSlipId;
        this.exitSlipDesc = exitSlipDesc;
        this.exitSlipDate = LocalTime.now();
    }

    public List exitSlip(int pid, @NotNull List<Spot> spotList, @NotNull List<Product> productList){


        String category = productList.get(pid).getCategory();
//        String type = productList.get(pid).getProductGeneralType();
//        Collections.sort(productList,Comparator.comparing(Product::getProductDate));



            if (productList.get(pid).getType().equals(ProductCategory.FIFO)){

                productList.stream()
                        .filter(product -> product.getCategory().equals(category))
                        .sorted(Comparator.comparing(Product::getProductDate).reversed())
                        .collect(Collectors.toList());

                for (Spot spot: spotList){
                    if (spot.getProductId() == pid){
                        productList.remove(productList.get(pid).getProductId());
                        exitSlipList.add(new Exit(spot.getProductId(), exitSlipDesc));
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
                        exitSlipList.add(new Exit(spot.getProductId(), exitSlipDesc));
                        spot.setProductId(0);
                        productList.remove(productList.get(pid).getProductId());
                    }
                }
            }


        return exitSlipList;
    }

    public List<Exit> getExitSlipList() {
        return exitSlipList;
    }

    public LocalTime getExitSlipDate() {
        return exitSlipDate;
    }


}
