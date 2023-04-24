package org.example;

import java.time.LocalTime;

public class Product extends EntrySlip{
    private int productId, quantity;
    private Enum type;
    private String desc, quantityMes;
    private LocalTime date;

    public Product(){}

    public Product(int productId, Enum type, String desc){
        this.productId = productId;
        this.type = type;
        this.desc = desc;

        this.date = getDate();
    }




    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }




    public void setProductCategory(Enum type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQuantityMes() {
        return quantityMes;
    }

    public void setQuantityMes(String quantityMes) {
        this.quantityMes = quantityMes;
    }

}
