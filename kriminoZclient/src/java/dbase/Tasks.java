/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t"),
    @NamedQuery(name = "Tasks.findByTaskCode", query = "SELECT t FROM Tasks t WHERE t.taskCode = :taskCode"),
    @NamedQuery(name = "Tasks.findByTaskName", query = "SELECT t FROM Tasks t WHERE t.taskName = :taskName"),
    @NamedQuery(name = "Tasks.findByCasecode", query = "SELECT abc FROM Tasks abc WHERE abc.casecode.caseCode = :caseCode"),
    @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status"),
    @NamedQuery(name = "Tasks.findByContractcode", query = "SELECT t FROM Tasks t WHERE t.contractcode = :contractcode")})
public class Tasks implements Serializable {
    @Column(name = "timestamp10")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp10;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TaskCode")
    private String taskCode;
    @Size(max = 45)
    @Column(name = "TaskName")
    private String taskName;
    @Size(max = 45)
    @Column(name = "Status")
    private String status;
    @Size(max = 45)
    @Column(name = "contractcode")
    private String contractcode;
    @OneToMany(mappedBy = "taskid")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;

    public Tasks() {
    }

    public Tasks(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContractcode() {
        return contractcode;
    }

    public void setContractcode(String contractcode) {
        this.contractcode = contractcode;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public Cases getCasecode() {
        return casecode;
    }

    public void setCasecode(Cases casecode) {
        this.casecode = casecode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskCode != null ? taskCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.taskCode == null && other.taskCode != null) || (this.taskCode != null && !this.taskCode.equals(other.taskCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Tasks[ taskCode=" + taskCode + " ]";
    }

    public Date getTimestamp10() {
        return timestamp10;
    }

    public void setTimestamp10(Date timestamp10) {
        this.timestamp10 = timestamp10;
    }
    
}
