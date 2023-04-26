package org.example;




import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Slip {

    private String productGeneralType;
    private int entrySlipCode;
    private String entrySlipDesc;
    private LocalTime entryDate;
    private List<Product> productList = new ArrayList<>();

    public Slip(int entrySlipCode, String productGeneralType, String entrySlipDesc){
        this.entrySlipCode=entrySlipCode;
        this.productGeneralType=productGeneralType;
        this.entrySlipDesc=entrySlipDesc;
        this.entryDate = LocalTime.now();
    }

    public Slip(){
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


    public List print() {
        List<Product> pr = productList.stream()
                .sorted(Comparator.comparing(Product::getCategory))
                .collect(Collectors.toList());
        return pr;
    }
}
