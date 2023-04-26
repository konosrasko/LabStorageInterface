package org.example;


import java.util.ArrayList;
import java.util.List;


public class EntrySlip extends Slip{

    private int productGeneralType;
    private String entrySlipDesc;
    private int slipId;
    private Enum type;
    private List<Product> productList = new ArrayList<>();


    public EntrySlip(){

    }
    public EntrySlip(int slipId,Enum type,int productGeneralType, String desc){
        this.slipId = slipId;
        this.type = type;
        this.productGeneralType = productGeneralType;
        this.entrySlipDesc = desc;
    }

    public void addProduct(int productId,String category, Enum type, String desc){
        productList.add(new Product(productId,category,type,desc));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getProductGeneralType() {
        return productGeneralType;
    }


    public String getEntrySlipDesc() {
        return entrySlipDesc;
    }




   /* public List print() {
        List<Product> pr = productList.stream()
                .sorted(Comparator.comparing(Product::getCategory))
                .collect(Collectors.toList());
        return pr;
    }*/
}
