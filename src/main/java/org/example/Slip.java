package org.example;

import java.time.LocalTime;

public class Slip {
    private int slipId;
    private LocalTime receiveDate, exitDate;

    public Slip(){
        this.receiveDate=LocalTime.now();
    }





    public void setSlipId(int slipId) {
        this.slipId = slipId;
    }

    public int getSlipId() {
        return slipId;
    }

    public LocalTime getReceiveDate() {
        return receiveDate;
    }
}
