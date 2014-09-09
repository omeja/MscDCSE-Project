/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author Admin
 */

public class Reps12 {
    private String ent;
    private String accno;
    private String per;
    private String src ;
    private int amt;

    public Reps12(String ent, String accno, String per, String src, int amt) {
        this.ent = ent;
        this.accno = accno;
        this.per = per;
        this.src = src;
        this.amt = amt;
    }

    public String getEnt() {
        return ent;
    }

    public void setEnt(String ent) {
        this.ent = ent;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }
}
