/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author pc
 */
public class Reps2 {
private String dacct;
private String acctname;
private String bdate;
private String debitamt;
private String transfertype;
private String creditacct;
private String limit;

    public String getDacct() {
        return dacct;
    }

    public void setDacct(String dacct) {
        this.dacct = dacct;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
private String status;
private String staff2;

    public String getStaff2() {
        return staff2;
    }

    public void setStaff2(String staff2) {
        this.staff2 = staff2;
    }
    public Reps2(String bdate,String transfertype, String debitamt, String dacct, String creditacct, String limit,String status,String staff2) {
        this.limit = limit;
        this.dacct = dacct;
        this.bdate = bdate;
        this.debitamt = debitamt;
        this.transfertype = transfertype;
        this.creditacct = creditacct;
        this.status = status;
        this.staff2 = staff2;
    }

 

    public String getAcctname() {
        return acctname;
    }

    public void setAcctname(String acctname) {
        this.acctname = acctname;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getDebitamt() {
        return debitamt;
    }

    public void setDebitamt(String debitamt) {
        this.debitamt = debitamt;
    }

    public String getTransfertype() {
        return transfertype;
    }

    public void setTransfertype(String transfertype) {
        this.transfertype = transfertype;
    }

    public String getCreditacct() {
        return creditacct;
    }

    public void setCreditacct(String creditacct) {
        this.creditacct = creditacct;
    }

  


    
}
