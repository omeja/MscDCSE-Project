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
public class Contractbean {

    private String contractid ;
    private String workplanid ;
    private String contractacct ;
    private int contractamt ;
    private String contractor;
    private String ccode9;
    private Date Timestamp9;

    public Contractbean(String contractid, String workplanid, String contractacct, int contractamt, String contractor, String ccode9) {
        this.contractid = contractid;
        this.workplanid = workplanid;
        this.contractacct = contractacct;
        this.contractamt = contractamt;
        this.contractor = contractor;
        this.ccode9 = ccode9;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getWorkplanid() {
        return workplanid;
    }

    public void setWorkplanid(String workplanid) {
        this.workplanid = workplanid;
    }

    public String getContractacct() {
        return contractacct;
    }

    public void setContractacct(String contractacct) {
        this.contractacct = contractacct;
    }

    public int getContractamt() {
        return contractamt;
    }

    public void setContractamt(int contractamt) {
        this.contractamt = contractamt;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getCcode9() {
        return ccode9;
    }

    public void setCcode9(String ccode9) {
        this.ccode9 = ccode9;
    }

    public Date getTimestamp9() {
        return Timestamp9;
    }

    public void setTimestamp9(Long Timestamp9) {
        this.Timestamp9 = new Date(Timestamp9);
    }
}
