package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EntrySlip{

    private int generalId;
    private String entrySlipDesc;
    private int slipId;
    private Enum productCategory;
    private LocalDate localDate;
    private List<Product> productList = new ArrayList<>();


    public EntrySlip(){

    }

    public EntrySlip(int slipId, Enum productCategory, int generalId, String desc){
        this.slipId = slipId;
        this.productCategory = productCategory;
        this.generalId = generalId;
        this.entrySlipDesc = desc;
        this.localDate = LocalDate.now();
    }

    public void addProduct(int productId,int generalId, Enum type, String desc){
        productList.add(new Product(productId,generalId,type,desc));
    }

    public List<Product> getProductList() {
        return productList;
    }


    public int getSlipId() {
        return slipId;
    }

    public int getGeneralId() {
        return generalId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setSlipId(int slipId) {
        this.slipId = slipId;
    }

    public void setGeneralId(int generalId) {
        this.generalId = generalId;
    }

    public String getEntrySlipDesc() {
        return entrySlipDesc;
    }

    public void setEntrySlipDesc(String entrySlipDesc) {
        this.entrySlipDesc = entrySlipDesc;
    }

    public Enum getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Enum productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
