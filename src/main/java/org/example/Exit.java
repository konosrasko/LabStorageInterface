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

    public int getExitSlipId() {
        return exitSlipId;
    }

    public void setExitSlipId(int exitSlipId) {
        this.exitSlipId = exitSlipId;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public String getExitSlipDesc() {
        return exitSlipDesc;
    }

    public void setExitSlipDesc(String exitSlipDesc) {
        this.exitSlipDesc = exitSlipDesc;
    }

    public void setExitSlipDate(LocalTime exitSlipDate) {
        this.exitSlipDate = exitSlipDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExitSlipList(List<Integer> exitSlipList) {
        this.exitSlipList = exitSlipList;
    }
}
