package org.example;

import com.google.inject.internal.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntrySlip {

    private String productGeneralType;
    private int entrySlipCode;
    private String entrySlipDesc;
    private LocalTime entryDate;
    private List<Product> productList = new ArrayList<>();

    public EntrySlip(int entrySlipCode,String productGeneralType,String entrySlipDesc){
        this.entrySlipCode=entrySlipCode;
        this.productGeneralType=productGeneralType;
        this.entrySlipDesc=entrySlipDesc;
        this.entryDate = LocalTime.now();
    }

    public EntrySlip(){
        this.entryDate = LocalTime.now();
    }

    public void addProduct(int productId,String category, Enum type, String desc){
        productList.add(new Product(productId,category,type,desc));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getProductGeneralType() {
        return productGeneralType;
    }

    public int getEntrySlipCode() {
        return entrySlipCode;
    }

    public String getEntrySlipDesc() {
        return entrySlipDesc;
    }

    public LocalTime getEntryDate() {
        return entryDate;
    }
}
