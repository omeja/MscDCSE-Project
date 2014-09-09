/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author Admin
 */
public class Reps7 {
      private Integer itemcode;
    private Integer quarter;
    private String description;
    private Integer amount;
    private String yearp;

    public Reps7(Integer itemcode, Integer quarter, String description, Integer amount, String yearp) {
        this.itemcode = itemcode;
        this.quarter = quarter;
        this.description = description;
        this.amount = amount;
        this.yearp = yearp;
    }

    public Integer getItemcode() {
        return itemcode;
    }

    public void setItemcode(Integer itemcode) {
        this.itemcode = itemcode;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getYearp() {
        return yearp;
    }

    public void setYearp(String yearp) {
        this.yearp = yearp;
    }
}
