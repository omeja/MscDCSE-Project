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
public class Incomebean {

    private String itemno;
    private String description;
    private String incometype;
    private String frequency;
    private String amount;
    private String casecode;
    private Date timestamp6;
//

    public Date getTimestamp6() {
        return timestamp6;
    }

    public void setTimestamp6(Long timestamp6) {
        this.timestamp6 = new Date(timestamp6);
    }

    public Incomebean(String itemno, String description, String incometype, String frequency, String amount, String casecode) {
        this.itemno = itemno;
        this.description = description;
        this.incometype = incometype;
        this.frequency = frequency;
        this.amount = amount;
        this.casecode = casecode;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncometype() {
        return incometype;
    }

    public void setIncometype(String incometype) {
        this.incometype = incometype;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }
}
