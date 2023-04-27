package org.example;
import java.time.LocalDate;

public class Product extends EntrySlip{
    private int productId;
    private Enum productCategory;
    private String desc, quantityMes;
    private int generalId;
    private LocalDate productDate;



    public Product(){}

    public Product(int productId, int generalId, Enum productCategory, String desc){
        this.productId = productId;
        this.generalId = generalId;
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
    public int getGeneralId() {
        return generalId;
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

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public void setProductCategory(Enum productCategory) {
        this.productCategory = productCategory;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQuantityMes(String quantityMes) {
        this.quantityMes = quantityMes;
    }

    @Override
    public void setGeneralId(int generalId) {
        this.generalId = generalId;
    }

    public void setProductDate(LocalDate productDate) {
        this.productDate = productDate;
    }
}
