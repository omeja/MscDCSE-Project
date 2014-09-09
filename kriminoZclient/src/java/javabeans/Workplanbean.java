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
public class Workplanbean {

    private String Workplancode;
    private int Amount;
    private String ccode13;
    private String Desc;
    private String sdate;
    private String edate;
    private Date Timestamp8;
    private String Entcd;

    public String getEntcd() {
        return Entcd;
    }

    public void setEntcd(String Entcd) {
        this.Entcd = Entcd;
    }

    public Workplanbean(String Workplancode, int Amount, String ccode13, String Desc, String sdate,String edate,String Entcd) {
        this.Workplancode = Workplancode;
        this.Amount = Amount;
        this.ccode13 = ccode13;
        this.Desc = Desc;
        this.sdate = sdate;
        this.edate = edate;
        this.Entcd = Entcd;
    }

    public Date getTimestamp8() {
        return Timestamp8;
    }

    public void setTimestamp7(Long Timestamp8) {
        this.Timestamp8 = new Date (Timestamp8);
    }

    public String getWorkplancode() {
        return Workplancode;
    }

    public void setWorkplancode(String Workplancode) {
        this.Workplancode = Workplancode;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getCcode13() {
        return ccode13;
    }

    public void setCcode13(String ccode13) {
        this.ccode13 = ccode13;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }
}
