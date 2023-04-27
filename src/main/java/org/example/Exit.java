package org.example;
import org.jetbrains.annotations.NotNull;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;




public class Exit {

    private int exitSlipId;
    private int productCategory;
    private String exitSlipDesc;
    private LocalTime exitSlipDate;
    private int quantity;
    private List<Integer> exitSlipList = new ArrayList();



    public Exit(){}

    public Exit(int exitSlipId, int productCategory, int quantity){
        this.exitSlipId = exitSlipId;
        this.productCategory = productCategory;
        this.quantity = quantity;
    }
    public List<Integer> getExitSlipList() {
        return exitSlipList;
    }

    public LocalTime getExitSlipDate() {
        return exitSlipDate;
    }


}
