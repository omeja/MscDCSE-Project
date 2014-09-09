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
@Table(name = "contracts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contracts.findAll", query = "SELECT c FROM Contracts c"),
    @NamedQuery(name = "Contracts.findByContractID", query = "SELECT c FROM Contracts c WHERE c.contractID = :contractID"),
    @NamedQuery(name = "Contracts.findByContractAcct", query = "SELECT c FROM Contracts c WHERE c.contractAcct = :contractAcct"),
     @NamedQuery(name = "Contracts.findByCasecode", query = "SELECT abc FROM Contracts abc WHERE abc.casecode.caseCode = :caseCode"),
    @NamedQuery(name = "Contracts.findByContractAmt", query = "SELECT c FROM Contracts c WHERE c.contractAmt = :contractAmt"),
    @NamedQuery(name = "Contracts.findByContractor", query = "SELECT c FROM Contracts c WHERE c.contractor = :contractor")})
public class Contracts implements Serializable {
    @Column(name = "timestamp9")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp9;
    @OneToMany(mappedBy = "contractcode")
  //  private Collection<Tasks> tasksCollection;
   // @OneToMany(mappedBy = "contractcode")
   // private Collection<Tasks> tasksCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ContractID")
    private String contractID;
    @Size(max = 45)
    @Column(name = "ContractAcct")
    private String contractAcct;
    @Column(name = "ContractAmt")
    private Integer contractAmt;
    @Size(max = 45)
    @Column(name = "Contractor")
    private String contractor;
    @OneToMany(mappedBy = "contractid")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "WorkPlanID", referencedColumnName = "WorkPlanCode")
    @ManyToOne
    private Workplan workPlanID;
    @JoinColumn(name = "Casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;

    public Contracts() {
    }

    public Contracts(String contractID) {
        this.contractID = contractID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getContractAcct() {
        return contractAcct;
    }

    public void setContractAcct(String contractAcct) {
        this.contractAcct = contractAcct;
    }

    public Integer getContractAmt() {
        return contractAmt;
    }

    public void setContractAmt(Integer contractAmt) {
        this.contractAmt = contractAmt;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public Workplan getWorkPlanID() {
        return workPlanID;
    }

    public void setWorkPlanID(Workplan workPlanID) {
        this.workPlanID = workPlanID;
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
        hash += (contractID != null ? contractID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contracts)) {
            return false;
        }
        Contracts other = (Contracts) object;
        if ((this.contractID == null && other.contractID != null) || (this.contractID != null && !this.contractID.equals(other.contractID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Contracts[ contractID=" + contractID + " ]";
    }

  //  @XmlTransient
//    public Collection<Tasks> getTasksCollection() {
//        return tasksCollection;
//    }
//
//    public void setTasksCollection(Collection<Tasks> tasksCollection) {
//        this.tasksCollection = tasksCollection;
//    }
//    

    public Date getTimestamp9() {
        return timestamp9;
    }

    public void setTimestamp9(Date timestamp9) {
        this.timestamp9 = timestamp9;
    }

   // @XmlTransient
//    public Collection<Tasks> getTasksCollection() {
//        return tasksCollection;
//    }
//
//    public void setTasksCollection(Collection<Tasks> tasksCollection) {
//        this.tasksCollection = tasksCollection;
//    }
}
