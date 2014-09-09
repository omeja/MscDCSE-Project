/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author Admin
 */
public class Reps11 {
    private String emaildate;
    private String requestid;
    private String emailid;
    private String sourceadd;
    private String destadd; 

    public Reps11(String emaildate, String requestid, String emailid, String sourceadd, String destadd) {
        this.emaildate = emaildate;
        this.requestid = requestid;
        this.emailid = emailid;
        this.sourceadd = sourceadd;
        this.destadd = destadd;
    }

    public String getEmaildate() {
        return emaildate;
    }

    public void setEmaildate(String emaildate) {
        this.emaildate = emaildate;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getSourceadd() {
        return sourceadd;
    }

    public void setSourceadd(String sourceadd) {
        this.sourceadd = sourceadd;
    }

    public String getDestadd() {
        return destadd;
    }

    public void setDestadd(String destadd) {
        this.destadd = destadd;
    }
}
