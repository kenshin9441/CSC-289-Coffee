/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeshop;

import java.math.BigDecimal;

/**
 *
 * @author Ghin
 */
public class Payment {
    private String method;
    private int transID;
    private BigDecimal payAmt;

    public Payment(String method, int transID, BigDecimal payAmt) {
        this.method = method;
        this.transID = transID;
        this.payAmt = payAmt;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }
    
}
