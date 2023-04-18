package org.example;

import java.util.ArrayList;
import java.util.List;

public class db{

    private List<Slip> slipList = new ArrayList<>();
    private List<Product> productListFifo = new ArrayList<>();

    private List<Product> productListLifo = new ArrayList<>();




    public void setProductList(List slipList) {
        for (Slip slipList : slipList ) {
            for (int i=0; i<slipList.getProductList().size(); i++){
                if (slipList.getProductList().get(i).getType().equals(ProductType.FIFO)) {
                    this.productListFifo.add(slipList.getProductList().get(i));
                }else {
                    this.productListLifo.add(slipList.getProductList().get(i));
                }

            }
        }
    }


    public void setProductListFifo(List<Product> productListFifo) {
        this.productListFifo = productListFifo;
    }

    public void setProductListLifo(List<Product> productListLifo) {
        this.productListLifo = productListLifo;
    }



}
