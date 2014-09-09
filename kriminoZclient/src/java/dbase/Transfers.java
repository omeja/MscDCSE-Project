/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbase;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "transfers")
@NamedQueries({
    @NamedQuery(name = "Transfers.findAll", query = "SELECT t FROM Transfers t"),
    @NamedQuery(name = "Transfers.findById", query = "SELECT t FROM Transfers t WHERE t.id = :id"),
    @NamedQuery(name = "Transfers.findByTdate", query = "SELECT t FROM Transfers t WHERE t.tdate = :tdate"),
     @NamedQuery(name = "Transfers.findByCasecode", query = "SELECT t from Transfers t where t.caseCode.caseCode =:caseCode"),
    @NamedQuery(name = "Transfers.findByTamount", query = "SELECT t FROM Transfers t WHERE t.tamount = :tamount"),
    @NamedQuery(name = "Transfers.findByFroaccount", query = "SELECT t FROM Transfers t WHERE t.froaccount = :froaccount"),
    @NamedQuery(name = "Transfers.findByToaccount", query = "SELECT t FROM Transfers t WHERE t.toaccount = :toaccount"),
    @NamedQuery(name = "Transfers.findByFrobank", query = "SELECT t FROM Transfers t WHERE t.frobank = :frobank"),
    @NamedQuery(name = "Transfers.findByTobank", query = "SELECT t FROM Transfers t WHERE t.tobank = :tobank")})
public class Transfers implements Serializable {
    @Column(name = "timestamp3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp3;
    @JoinColumn(name = "wrkplanid", referencedColumnName = "WorkPlanCode")
    @ManyToOne
    private Workplan wrkplanid;
    @JoinColumn(name = "Taskid", referencedColumnName = "TaskCode")
    @ManyToOne
    private Tasks taskid;
    @JoinColumn(name = "contractid", referencedColumnName = "ContractID")
    @ManyToOne
    private Contracts contractid;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tdate;
    @Column(name = "tamount")
    private Integer tamount;
    @Column(name = "froaccount")
    private String froaccount;
    @Column(name = "toaccount")
    private String toaccount;
    @Column(name = "frobank")
    private String frobank;
    @Column(name = "tobank")
    private String tobank;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases caseCode;

    public Transfers() {
    }

    public Transfers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public Integer getTamount() {
        return tamount;
    }

    public void setTamount(Integer tamount) {
        this.tamount = tamount;
    }

    public String getFroaccount() {
        return froaccount;
    }

    public void setFroaccount(String froaccount) {
        this.froaccount = froaccount;
    }

    public String getToaccount() {
        return toaccount;
    }

    public void setToaccount(String toaccount) {
        this.toaccount = toaccount;
    }

    public String getFrobank() {
        return frobank;
    }

    public void setFrobank(String frobank) {
        this.frobank = frobank;
    }

    public String getTobank() {
        return tobank;
    }

    public void setTobank(String tobank) {
        this.tobank = tobank;
    }

    public Cases getCases() {
        return caseCode;
    }

    public void setCases(Cases caseCode) {
        this.caseCode = caseCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfers)) {
            return false;
        }
        Transfers other = (Transfers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Transfers[id=" + id + "]";
    }

    public Workplan getWrkplanid() {
        return wrkplanid;
    }

    public void setWrkplanid(Workplan wrkplanid) {
        this.wrkplanid = wrkplanid;
    }

    public Tasks getTaskid() {
        return taskid;
    }

    public void setTaskid(Tasks taskid) {
        this.taskid = taskid;
    }

    public Contracts getContractid() {
        return contractid;
    }

    public void setContractid(Contracts contractid) {
        this.contractid = contractid;
    }

    public Date getTimestamp3() {
        return timestamp3;
    }

    public void setTimestamp3(Date timestamp3) {
        this.timestamp3 = timestamp3;
    }

}
