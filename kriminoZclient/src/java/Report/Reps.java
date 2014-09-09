/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author pc
 */
public class Reps {
private String acct;
private String transdate;
private String trantype;

//

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getTrantype() {
        return trantype;
    }

    public void setTrantype(String trantype) {
        this.trantype = trantype;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }
private int amt;
//
    public Reps(String act,int at,String transdate, String trantype) {
        
        this.acct = act;
        this.amt = at;
        this.transdate = transdate;
        this.trantype = trantype;
        
        
    }
    
}
