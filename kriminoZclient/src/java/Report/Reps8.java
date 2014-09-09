/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Reps8 {
    
     private String filename;
    private String dbAcct;
    private String cracct;
    private String reqdate;
    private String userid;
     private String userlevel;

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }
    private String wrkid;

    private String Entcode;

    public Reps8(String filename, String dbAcct, String cracct,String wrkid, String reqdate, String userid,String userlevel,String Entcode) {
        this.filename = filename;
        this.dbAcct = dbAcct;
        this.cracct = cracct;
        this.reqdate = reqdate;
        this.userid = userid;
        this.userlevel = userlevel;
        this.wrkid = wrkid;
     
        this.Entcode = Entcode;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDbAcct() {
        return dbAcct;
    }

    public void setDbAcct(String dbAcct) {
        this.dbAcct = dbAcct;
    }

    public String getCracct() {
        return cracct;
    }

    public void setCracct(String cracct) {
        this.cracct = cracct;
    }

    public String getReqdate() {
        return reqdate;
    }

    public void setReqdate(String reqdate) {
        this.reqdate = reqdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWrkid() {
        return wrkid;
    }

    public void setWrkid(String wrkid) {
        this.wrkid = wrkid;
    }

   

    public String getEntcode() {
        return Entcode;
    }

    public void setEntcode(String Entcode) {
        this.Entcode = Entcode;
    }

    public Date getTimestamp7() {
        return timestamp7;
    }

    public void setTimestamp7(Long timestamp7) {
        this.timestamp7 = new Date (timestamp7);
    }
    private Date timestamp7;
    
}
