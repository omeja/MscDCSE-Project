    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.Date;

/**
 *
 * @author Osbert
 */
public class Transferbean {

    private Date timestamp3;

    public Date getTimestamp3() {
        return timestamp3;
    }

    public void setTimestamp3(Long timestamp3) {
        this.timestamp3 = new Date(timestamp3);
    }
    private String tfid;
    private String ccode3;
    private String tdate;
    private int tamount;
    private String tfroacct;
    private String wkplanid;
    private int contrid;
    private String Taskid;

    public String getWkplanid() {
        return wkplanid;
    }

    public void setWkplanid(String wkplanid) {
        this.wkplanid = wkplanid;
    }

    public int getContrid() {
        return contrid;
    }

    public void setContrid(int contrid) {
        this.contrid = contrid;
    }

    public String getTaskid() {
        return Taskid;
    }

    public void setTaskid(String Taskid) {
        this.Taskid = Taskid;
    }

    public Transferbean(String tfid, String ccode3, String tdate, int tamount, String tfroacct, String ttoacct, String frobank, String ttobank,String wkplanid, int contrid, String Taskid) {
        this.tfid = tfid;
        this.ccode3 = ccode3;
        this.tdate = tdate;
        this.tamount = tamount;
        this.tfroacct = tfroacct;
        this.ttoacct = ttoacct;
        this.frobank = frobank;
        this.ttobank = ttobank;
        this.wkplanid = wkplanid;
        this.contrid = contrid;
        this.Taskid = Taskid;
    }

 

    public String getTfid() {
        return tfid;
    }

    public void setTfid(String tfid) {
        this.tfid = tfid;
    }

    public String getCcode3() {
        return ccode3;
    }

    public void setCcode3(String ccode3) {
        this.ccode3 = ccode3;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public int getTamount() {
        return tamount;
    }

    public void setTamount(int tamount) {
        this.tamount = tamount;
    }

    public String getTfroacct() {
        return tfroacct;
    }

    public void setTfroacct(String tfroacct) {
        this.tfroacct = tfroacct;
    }

    public String getTtoacct() {
        return ttoacct;
    }

    public void setTtoacct(String ttoacct) {
        this.ttoacct = ttoacct;
    }

    public String getFrobank() {
        return frobank;
    }

    public void setFrobank(String frobank) {
        this.frobank = frobank;
    }

    public String getTtobank() {
        return ttobank;
    }

    public void setTtobank(String ttobank) {
        this.ttobank = ttobank;
    }
    private String ttoacct;
    private String frobank;
    private String ttobank;
}
