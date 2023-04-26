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

}
