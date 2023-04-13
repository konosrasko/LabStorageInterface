package org.example;

public class Product {
    private int productId, quantity;
    private Enum type;
    private String desc, quantityMes;

    public Product(){

    }

    public Product(int productId, Enum type, String desc, String quantityMes, int quantity){
        this.productId = productId;
        this.type = type;
        this.desc = desc;
        this.quantityMes = quantityMes;
        this.quantity = quantity;
    }




    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
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
