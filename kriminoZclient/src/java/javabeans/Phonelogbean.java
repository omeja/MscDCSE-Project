/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import com.espertech.esper.client.util.DateTime;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Osbert
 */
@ManagedBean
public class Phonelogbean {

    private String callid;
    private String ccode1;
    private String calldate;
    private String frono;
    private String tono;

    public String getReqid() {
        return reqid;
    }

    public void setReqid(String reqid) {
        this.reqid = reqid;
    }
    private String reqid;
     private Long timestamp1;

    public Long getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(Long timestamp1) {
        this.timestamp1 = timestamp1;
    }

    public Phonelogbean(String callid, String ccode1, String calldate, String frono, String tono,String reqid,Long timestamp1) {
        this.callid = callid;
        this.ccode1 = ccode1;
        this.calldate = calldate;
        this.frono = frono;
        this.tono = tono;
        this.reqid = reqid;
        this.timestamp1 = timestamp1;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getCcode1() {
        return ccode1;
    }

    public void setCcode1(String ccode1) {
        this.ccode1 = ccode1;
    }

    public String getCalldate() {
        return calldate;
    }

    public void setCalldate(String calldate) {
        this.calldate = calldate;
    }

    public String getFrono() {
        return frono;
    }

    public void setFrono(String frono) {
        this.frono = frono;
    }

    public String getTono() {
        return tono;
    }

    public void setTono(String tono) {
        this.tono = tono;
    }

    @Override
    public String toString() {
        System.out.print("testing");
        return "Phonelogbean{" + "callid=" + callid + ", ccode1=" + ccode1 + ", calldate=" + calldate + ", frono=" + frono + ", tono=" + tono + '}';

    }
}
