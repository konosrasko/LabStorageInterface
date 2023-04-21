package org.example;

import java.util.List;

public class Spot {
    private int spotID, productId;
    private int corridor;
    private int shelf;
    private List<Product> products;

    public Spot(){}


    public Spot(int spotID, int corridor, int shelf){
        this.spotID=spotID;
        this.corridor = corridor;
        this.shelf = shelf;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }

    public void setCorridor(int corridor) {
        this.corridor = corridor;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getSpotID() {
        return spotID;
    }

    public int getCorridor() {
        return corridor;
    }

    public int getShelf() {
        return shelf;
    }

    public int getProductId() {
        return productId;
    }

}
