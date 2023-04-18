package org.example;

public class Spots {
    private int spotID, productId;
    private int corridor;
    private int shelf;
    private int qnty, prodQnty;

    public Spots(){}
    public Spots(int corridor, int shelf, int qnty, int spotID){
        this.corridor = corridor;
        this.shelf = shelf;
        this.qnty = qnty;
        this.spotID=spotID;
    }

    public Spots(int corridor, int shelf, int qnty, int spotID, int productId){
        this.corridor = corridor;
        this.shelf = shelf;
        this.qnty = qnty;
        this.spotID=spotID;
        this.productId=productId;
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

    public void setQnty(int qnty) {
        this.qnty = qnty;
    }

    public void setProdQnty(int prodQnty) {
        this.prodQnty = prodQnty;
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

    public int getQnty() {
        return qnty;
    }
}
