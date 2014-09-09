/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbase;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "cases")
@NamedQueries({
    @NamedQuery(name = "Cases.findAll", query = "SELECT c FROM Cases c"),
    @NamedQuery(name = "Cases.findByCaseCode", query = "SELECT c FROM Cases c WHERE c.caseCode = :caseCode"),
    @NamedQuery(name = "Cases.findByStation", query = "SELECT c FROM Cases c WHERE c.station = :station"),
    @NamedQuery(name = "Cases.findByDistrict", query = "SELECT c FROM Cases c WHERE c.district = :district")})
public class Cases implements Serializable {
    @OneToMany(mappedBy = "casecode")
    private Collection<Workplan> workplanCollection;
    @OneToMany(mappedBy = "csscode")
    private Collection<Accounts> accountsCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Tasks> tasksCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Request> requestCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Contracts> contractsCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Userrights> userrightsCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Emails> emailsCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Budget> budgetCollection;
    @JoinColumn(name = "EntityCode", referencedColumnName = "Code")
    @ManyToOne
    private Entities entityCode;
    @OneToMany(mappedBy = "casecode")
    private Collection<Assets> assetsCollection;
    @OneToMany(mappedBy = "casecode5")
    private Collection<Boutransfers> boutransfersCollection;
    @OneToMany(mappedBy = "casecode")
    private Collection<Income> incomeCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "caseCode")
    private String caseCode;
    @Column(name = "station")
    private String station;
    @Column(name = "district")
    private String district;
    @OneToMany(mappedBy = "caseCode")
    private Collection<Transfers> transfersCollection;
    @OneToMany(mappedBy = "caseCode")
    private Collection<Casetrans> casetransCollection;
    @OneToMany(mappedBy = "caseCode")
    private Collection<Phonelogs> phonelogsCollection;

    public Cases() {
    }

    public Cases(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public Collection<Casetrans> getCasetransCollection() {
        return casetransCollection;
    }

    public void setCasetransCollection(Collection<Casetrans> casetransCollection) {
        this.casetransCollection = casetransCollection;
    }

    public Collection<Phonelogs> getPhonelogsCollection() {
        return phonelogsCollection;
    }

    public void setPhonelogsCollection(Collection<Phonelogs> phonelogsCollection) {
        this.phonelogsCollection = phonelogsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caseCode != null ? caseCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cases)) {
            return false;
        }
        Cases other = (Cases) object;
        if ((this.caseCode == null && other.caseCode != null) || (this.caseCode != null && !this.caseCode.equals(other.caseCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Cases[caseCode=" + caseCode + "]";
    }

    @XmlTransient
    public Collection<Assets> getAssetsCollection() {
        return assetsCollection;
    }

    public void setAssetsCollection(Collection<Assets> assetsCollection) {
        this.assetsCollection = assetsCollection;
    }

    @XmlTransient
    public Collection<Boutransfers> getBoutransfersCollection() {
        return boutransfersCollection;
    }

    public void setBoutransfersCollection(Collection<Boutransfers> boutransfersCollection) {
        this.boutransfersCollection = boutransfersCollection;
    }

    @XmlTransient
    public Collection<Income> getIncomeCollection() {
        return incomeCollection;
    }

    public void setIncomeCollection(Collection<Income> incomeCollection) {
        this.incomeCollection = incomeCollection;
    }

    @XmlTransient
    public Collection<Budget> getBudgetCollection() {
        return budgetCollection;
    }

    public void setBudgetCollection(Collection<Budget> budgetCollection) {
        this.budgetCollection = budgetCollection;
    }

    public Entities getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(Entities entityCode) {
        this.entityCode = entityCode;
    }

    @XmlTransient
    public Collection<Emails> getEmailsCollection() {
        return emailsCollection;
    }

    public void setEmailsCollection(Collection<Emails> emailsCollection) {
        this.emailsCollection = emailsCollection;
    }

    @XmlTransient
    public Collection<Workplan> getWorkplanCollection() {
        return workplanCollection;
    }

    public void setWorkplanCollection(Collection<Workplan> workplanCollection) {
        this.workplanCollection = workplanCollection;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<Tasks> getTasksCollection() {
        return tasksCollection;
    }

    public void setTasksCollection(Collection<Tasks> tasksCollection) {
        this.tasksCollection = tasksCollection;
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

    @XmlTransient
    public Collection<Userrights> getUserrightsCollection() {
        return userrightsCollection;
    }

    public void setUserrightsCollection(Collection<Userrights> userrightsCollection) {
        this.userrightsCollection = userrightsCollection;
    }

}
