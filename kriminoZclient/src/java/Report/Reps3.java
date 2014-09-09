/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author pc
 */
public class Reps3 {
private String froacct;
private String tamount;
private String tstat;
private String toacct;
private String trdate;
private String wplan;

    public String getTstat() {
        return tstat;
    }

    public void setTstat(String tstat) {
        this.tstat = tstat;
    }

    public String getWplan() {
        return wplan;
    }

    public void setWplan(String wplan) {
        this.wplan = wplan;
    }

    public String getCamt() {
        return camt;
    }

    public void setCamt(String camt) {
        this.camt = camt;
    }
private String camt;

    public Reps3(String froacct, String tamount, String tstat, String toacct, String trdate, String wplan,String camt) {
        this.froacct = froacct;
        this.tamount = tamount;
        this.tstat = tstat;
        this.toacct = toacct;
        this.trdate = trdate;
        this.wplan = wplan;
        this.camt = camt;
    }

    public String getFroacct() {
        return froacct;
    }

    public void setFroacct(String froacct) {
        this.froacct = froacct;
    }

    public String getTamount() {
        return tamount;
    }

    public void setTamount(String tamount) {
        this.tamount = tamount;
    }

   

    public String getToacct() {
        return toacct;
    }

    public void setToacct(String toacct) {
        this.toacct = toacct;
    }

    public String getTrdate() {
        return trdate;
    }

    public void setTrdate(String trdate) {
        this.trdate = trdate;
    }

   

   
    
}
