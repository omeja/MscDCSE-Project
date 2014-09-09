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
public class Emailbean {

    private String Emailid;
    private String Emaildate;
    private String sourceadd;
    private String destadd;
    private String requestId;
    private String ccode10;
    private Date Timestamp11;

    public Emailbean(String Emailid, String Emaildate, String sourceadd, String destadd, String requestId, String ccode10) {
        this.Emailid = Emailid;
        this.Emaildate = Emaildate;
        this.sourceadd = sourceadd;
        this.destadd = destadd;
        this.requestId = requestId;
        this.ccode10 = ccode10;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String Emailid) {
        this.Emailid = Emailid;
    }

    public String getEmaildate() {
        return Emaildate;
    }

    public void setEmaildate(String Emaildate) {
        this.Emaildate = Emaildate;
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCcode10() {
        return ccode10;
    }

    public void setCcode10(String ccode10) {
        this.ccode10 = ccode10;
    }

    public Date getTimestamp11() {
        return Timestamp11;
    }

    public void setTimestamp11(Long Timestamp12) {
        this.Timestamp11 = new Date(Timestamp12);
    }
}
