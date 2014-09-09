/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Budgetbean {

    private String entity;
    private String period;
    private String amount;
    private String source;
    private String accno;
    private String casecode;

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }
    private Date timestamp12;

    public Date getTimestamp12() {
        return timestamp12;
    }

    public void setTimestamp12(Long timestamp12) {
        this.timestamp12 = new Date(timestamp12);
    }

    public Budgetbean(String entity, String period, String amount, String source, String accno,String ccode) {
        this.entity = entity;
        this.period = period;
        this.amount = amount;
        this.source = source;
        this.accno = accno;
        this.casecode = ccode;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String account) {
        this.accno = account;
    }

   
    
}
