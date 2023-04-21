package org.example;

import java.util.ArrayList;
import java.util.List;

public class Slip{

    private List<Product> productList = new ArrayList<>();
    private String generalType;
    private int slipEntryCode;
    private String slipEntryDesc;
    private String mesUnit;
    private int qnty;
    public Slip(){

    }
    public Slip(int slipEntryCode, String generalType,String slipEntryDesc,String mesUnit,int qnty){
        this.slipEntryCode=slipEntryCode;
        this.generalType=generalType;
        this.slipEntryDesc =slipEntryDesc;
        this.mesUnit=mesUnit;
        this.qnty=qnty;
    }

    public void addProductList(int productId, Enum type, String desc, String quantityMes, int quantity){
        productList.add(new Product(productId,type,desc,quantityMes,quantity));
    }

    public List<Product> getProductList() {
        return productList;
    }





}
