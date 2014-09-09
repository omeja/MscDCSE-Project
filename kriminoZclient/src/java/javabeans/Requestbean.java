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
public class Requestbean {

    private String filename;
    private String dbacct;
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
    private String ccode11;
    private String entcode;

    public Requestbean(String filename, String dbAcct, String cracct, String reqdate, String userid, String userlevel,String wrkid, String ccode11, String Entcode) {
        this.filename = filename;
        this.dbacct = dbAcct;
        this.cracct = cracct;
        this.reqdate = reqdate;
        this.userid = userid;
        this.wrkid = wrkid;
        this.ccode11 = ccode11;
        this.entcode = Entcode;
        this.userlevel = userlevel;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDbAcct() {
        return dbacct;
    }

    public void setDbAcct(String dbAcct) {
        this.dbacct = dbAcct;
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

    public String getCcode11() {
        return ccode11;
    }

    public void setCcode11(String ccode11) {
        this.ccode11 = ccode11;
    }

    public String getEntcode() {
        return entcode;
    }

    public void setEntcode(String Entcode) {
        this.entcode = Entcode;
    }

    public Date getTimestamp7() {
        return timestamp7;
    }

    public void setTimestamp7(Long timestamp7) {
        this.timestamp7 = new Date (timestamp7);
    }
    private Date timestamp7;
}
