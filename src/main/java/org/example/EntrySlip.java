package org.example;




import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EntrySlip extends Slip{

    private String productGeneralType;
    private String entrySlipDesc;
    private List<Product> productList = new ArrayList<>();

    public EntrySlip(String productGeneralType, String entrySlipDesc){
        super();
        this.productGeneralType = productGeneralType;
        this.entrySlipDesc = entrySlipDesc;
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


    public String getEntrySlipDesc() {
        return entrySlipDesc;
    }




    public List print() {
        List<Product> pr = productList.stream()
                .sorted(Comparator.comparing(Product::getCategory))
                .collect(Collectors.toList());
        return pr;
    }
}
