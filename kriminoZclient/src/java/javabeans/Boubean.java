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
public class Boubean {

    private String idbou;
    private String bdate;
    private String transfertype;
    private String debitacctno;
    private String debitacctname;
    private String debitamount;
    private String creditbank;
    private String creditacct;
    private String bankstaffid;
    private String govtstaffid;
    private String casecode;
    private String budgetamt;
    private String status;
    private String limits;
//
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLimit2() {
        return limits;
    }

    public void setLimit(String limit2) {
        this.limits = limit2;
    }
    private Date timestamp5;

    public Date getTimestamp5() {
        return timestamp5;
    }

    public void setTimestamp5(Long timestamp5) {
        this.timestamp5 = new Date(timestamp5);
    }

    public Boubean(String idbou, String bdate, String transfertype, String debitacctno, String debitacctname, String debitamount, String creditbank, String creditacct, String bankstaffid, String govtstaffid, String casecode, String budgetamt, String status, String limit) {
        this.idbou = idbou;
        this.bdate = bdate;
        this.transfertype = transfertype;
        this.debitacctno = debitacctno;
        this.debitacctname = debitacctname;
        this.debitamount = debitamount;
        this.creditbank = creditbank;
        this.creditacct = creditacct;
        this.bankstaffid = bankstaffid;
        this.govtstaffid = govtstaffid;
        this.casecode = casecode;
        this.budgetamt = budgetamt;
        this.status = status;
        this.limits = limit;
    }

    public String getIdbou() {
        return idbou;
    }

    public void setIdbou(String idbou) {
        this.idbou = idbou;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getTransfertype() {
        return transfertype;
    }

    public void setTransfertype(String transfertype) {
        this.transfertype = transfertype;
    }

    public String getDebitacctno() {
        return debitacctno;
    }

    public void setDebitacctno(String debitacctno) {
        this.debitacctno = debitacctno;
    }

    public String getDebitacctname() {
        return debitacctname;
    }

    public void setDebitacctname(String debitacctname) {
        this.debitacctname = debitacctname;
    }

    public String getDebitamount() {
        return debitamount;
    }

    public void setDebitamount(String debitamount) {
        this.debitamount = debitamount;
    }

    public String getCreditbank() {
        return creditbank;
    }

    public void setCreditbank(String creditbank) {
        this.creditbank = creditbank;
    }

    public String getCreditacct() {
        return creditacct;
    }

    public void setCreditacct(String creditacct) {
        this.creditacct = creditacct;
    }

    public String getBankstaffid() {
        return bankstaffid;
    }

    public void setBankstaffid(String bankstaffid) {
        this.bankstaffid = bankstaffid;
    }

    public String getGovtstaffid() {
        return govtstaffid;
    }

    public void setGovtstaffid(String govtstaffid) {
        this.govtstaffid = govtstaffid;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getBudgetamt() {
        return budgetamt;
    }

    public void setBudgetamt(String budgetamt) {
        this.budgetamt = budgetamt;
    }
}
