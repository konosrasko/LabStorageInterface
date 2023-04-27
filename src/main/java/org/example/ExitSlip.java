package org.example;

import java.util.*;

public class ExitSlip {
    private String exitSlipDesc;
    private int exitSlipId;
    private List<Product> exitSlipList = new ArrayList();

    public ExitSlip(){}


    public ExitSlip(int exitSlipId, String exitSlipDesc){
        this.exitSlipId = exitSlipId;
        this.exitSlipDesc = exitSlipDesc;
    }

    public String getExitSlipDesc() {
        return exitSlipDesc;
    }

    public void setExitSlipDesc(String exitSlipDesc) {
        this.exitSlipDesc = exitSlipDesc;
    }

    public int getExitSlipId() {
        return exitSlipId;
    }

    public void setExitSlipId(int exitSlipId) {
        this.exitSlipId = exitSlipId;
    }

    public List<Product> getExitSlipList() {
        return exitSlipList;
    }

    public void setExitSlipList(List<Product> exitSlipList) {
        this.exitSlipList = exitSlipList;
    }
}
