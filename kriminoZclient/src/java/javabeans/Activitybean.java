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
public class Activitybean {

    private String Taskcode;
    private String Taskname;
    private String Status;
    private String ccode12;
    private String Contractcode;
    private Long Timestamp10;

    public Activitybean(String Taskcode, String Taskname, String Status, String ccode12, String Contractcode) {
        this.Taskcode = Taskcode;
        this.Taskname = Taskname;
        this.Status = Status;
        this.ccode12 = ccode12;
        this.Contractcode = Contractcode;
     //   this.Timestamp10 = Timestamp10;
    }

    public String getTaskcode() {
        return Taskcode;
    }

    public void setTaskcode(String Taskcode) {
        this.Taskcode = Taskcode;
    }

    public String getTaskname() {
        return Taskname;
    }

    public void setTaskname(String Taskname) {
        this.Taskname = Taskname;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getCcode12() {
        return ccode12;
    }

    public void setCcode12(String ccode12) {
        this.ccode12 = ccode12;
    }

    public String getContractcode() {
        return Contractcode;
    }

    public void setContractcode(String Contractcode) {
        this.Contractcode = Contractcode;
    }

    public Long getTimestamp10() {
        return Timestamp10;
    }

    public void setTimestamp10(Long Timestamp10) {
        this.Timestamp10 = Timestamp10;
    }
}
