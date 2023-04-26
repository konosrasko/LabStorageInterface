package org.example;
import java.time.LocalDate;

public class Product extends EntrySlip{
    private int productId;
    private Enum productCategory;
    private String desc, quantityMes;
    private int category;
    private LocalDate productDate;



    public Product(){}

    public Product(int productId, int category, Enum productCategory, String desc){
        this.productId = productId;
        this.category = category;
        this.productCategory = productCategory;
        this.desc = desc;
        this.productDate = LocalDate.now();
    }


    public LocalDate getProductDate() {
        return productDate;
    }
    public int getProductId() {
        return productId;
    }
    public int getCategory() {
        return category;
    }
    public Enum getProductCategory() {
        return productCategory;
    }
    public String getDesc() {
        return desc;
    }
    public String getQuantityMes() {
        return quantityMes;
    }

}
