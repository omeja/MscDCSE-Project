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
@Table(name = "workplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workplan.findAll", query = "SELECT w FROM Workplan w"),
    @NamedQuery(name = "Workplan.findByWorkPlanCode", query = "SELECT w FROM Workplan w WHERE w.workPlanCode = :workPlanCode"),
    @NamedQuery(name = "Workplan.findByAmount", query = "SELECT w FROM Workplan w WHERE w.amount = :amount"),
    @NamedQuery(name = "Workplan.findByCasecode", query = "SELECT abc FROM Workplan abc WHERE abc.casecode.caseCode = :caseCode"),
    @NamedQuery(name = "Workplan.findByDescription", query = "SELECT w FROM Workplan w WHERE w.description = :description"),
    @NamedQuery(name = "Workplan.findByStartDate", query = "SELECT w FROM Workplan w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "Workplan.findByEndDate", query = "SELECT w FROM Workplan w WHERE w.endDate = :endDate")})
public class Workplan implements Serializable {
    @Column(name = "timestamp8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp8;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "WorkPlanCode")
    private String workPlanCode;
    @Column(name = "Amount")
    private Integer amount;
    @Size(max = 45)
    @Column(name = "Description")
    private String description;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "Entitycd", referencedColumnName = "Code")
    @ManyToOne
    private Entities entitycd;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;
    @OneToMany(mappedBy = "wrkplanid")
    private Collection<Transfers> transfersCollection;
    @OneToMany(mappedBy = "workplnId")
    private Collection<Request> requestCollection;
    @OneToMany(mappedBy = "workPlanID")
    private Collection<Contracts> contractsCollection;

    public Workplan() {
    }

    public Workplan(String workPlanCode) {
        this.workPlanCode = workPlanCode;
    }

    public String getWorkPlanCode() {
        return workPlanCode;
    }

    public void setWorkPlanCode(String workPlanCode) {
        this.workPlanCode = workPlanCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Entities getEntitycd() {
        return entitycd;
    }

    public void setEntitycd(Entities entitycd) {
        this.entitycd = entitycd;
    }

    public Cases getCasecode() {
        return casecode;
    }

    public void setCasecode(Cases casecode) {
        this.casecode = casecode;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<Contracts> getContractsCollection() {
        return contractsCollection;
    }

    public void setContractsCollection(Collection<Contracts> contractsCollection) {
        this.contractsCollection = contractsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workPlanCode != null ? workPlanCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workplan)) {
            return false;
        }
        Workplan other = (Workplan) object;
        if ((this.workPlanCode == null && other.workPlanCode != null) || (this.workPlanCode != null && !this.workPlanCode.equals(other.workPlanCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Workplan[ workPlanCode=" + workPlanCode + " ]";
    }

    public Date getTimestamp8() {
        return timestamp8;
    }

    public void setTimestamp8(Date timestamp8) {
        this.timestamp8 = timestamp8;
    }
    
}
