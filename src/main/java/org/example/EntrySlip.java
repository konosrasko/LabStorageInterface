package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EntrySlip{

    private int productGeneralType;
    private String entrySlipDesc;
    private int slipId;
    private Enum type;
    private LocalDate localDate;
    private List<Product> productList = new ArrayList<>();


    public EntrySlip(){

    }

    public EntrySlip(int slipId,Enum type,int productGeneralType, String desc){
        this.slipId = slipId;
        this.type = type;
        this.productGeneralType = productGeneralType;
        this.entrySlipDesc = desc;
        this.localDate = LocalDate.now();
    }

    public void addProduct(int productId,String category, Enum type, String desc){
        productList.add(new Product(productId,category,type,desc));
    }

    public List<Product> getProductList() {
        return productList;
    }


    public int getSlipId() {
        return slipId;
    }

    public int getProductGeneralType() {
        return productGeneralType;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
