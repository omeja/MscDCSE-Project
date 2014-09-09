/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import com.espertech.esper.client.util.DateTime;
import java.util.Date;

/**
 *
 * @author Osbert
 */
public class Transactionbean {
    private Date timestamp2;

    public Date getTimestamp2() {
        return timestamp2;
    }

    public void setTimestamp2(Long timestamp2) {
        this.timestamp2 = new Date(timestamp2);
    }
    private String tranid;
    private String ccode2;
    private String transdate;
    private String transcode ;
    private String transamount;
    private String transtype;
    private String tansaccount;

    public Transactionbean(String tranid, String ccode2, String transdate, String transcode, String transamount, String transtype, String tansaccount) {
        this.tranid = tranid;
        this.ccode2 = ccode2;
        this.transdate = transdate;
        this.transcode = transcode;
        this.transamount = transamount;
        this.transtype = transtype;
        this.tansaccount = tansaccount;
    }

    public String getTranid() {
        return tranid;
    }

    public void setTranid(String tranid) {
        this.tranid = tranid;
    }

    public String getCcode2() {
        return ccode2;
    }

    public void setCcode2(String ccode2) {
        this.ccode2 = ccode2;
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }

    public String getTransamount() {
        return transamount;
    }

    public void setTransamount(String transamount) {
        this.transamount = transamount;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getTansaccount() {
        return tansaccount;
    }

    public void setTansaccount(String tansaccount) {
        this.tansaccount = tansaccount;
    }
    
}
