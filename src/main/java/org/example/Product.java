package org.example;
import java.time.LocalTime;

public class Product extends Slip {
    private int productId, quantity;
    private Enum productCategory;
    private String desc, quantityMes, category;
    private LocalTime productDate;



    public Product(){}

    public Product(int productId, String category, Enum productCategory, String desc){
        this.productId = productId;
        this.category = category;
        this.productCategory = productCategory;
        this.desc = desc;

        this.productDate = getEntryDate();
    }


    public LocalTime getProductDate() {
        return productDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setProductCategory(Enum type) {
        this.productCategory = type;
    }

    public Enum getProductCategory() {
        return productCategory;
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
