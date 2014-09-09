/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author pc
 */
public class Reps5 {
private String asstyp;
private String sof;
private int asscost;
private int assmakval;
private String acqdate;

    public Reps5(String asstyp, String sof, int asscost, int assmakval, String acqdate) {
        this.asstyp = asstyp;
        this.sof = sof;
        this.asscost = asscost;
        this.assmakval = assmakval;
        this.acqdate = acqdate;
    }

    public String getAsstyp() {
        return asstyp;
    }

    public void setAsstyp(String asstyp) {
        this.asstyp = asstyp;
    }

    public String getSof() {
        return sof;
    }

    public void setSof(String sof) {
        this.sof = sof;
    }

    public int getAsscost() {
        return asscost;
    }

    public void setAsscost(int asscost) {
        this.asscost = asscost;
    }

    public int getAssmakval() {
        return assmakval;
    }

    public void setAssmakval(int assmakval) {
        this.assmakval = assmakval;
    }

    public String getAcqdate() {
        return acqdate;
    }

    public void setAcqdate(String acqdate) {
        this.acqdate = acqdate;
    }


    
    
}
