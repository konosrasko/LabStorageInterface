package org.example;

public class Spots {
    private int spotID, productId;
    private int corridor;
    private int shelf;
    private int qnty, prodQnty;


    public Spots(int corridor, int shelf, int qnty, int spotID){
        this.corridor = corridor;
        this.shelf = shelf;
        this.qnty = qnty;
        this.spotID=spotID;
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
