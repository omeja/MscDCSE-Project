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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "entities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entities.findAll", query = "SELECT e FROM Entities e"),
    @NamedQuery(name = "Entities.findByCode", query = "SELECT e FROM Entities e WHERE e.code = :code"),
    @NamedQuery(name = "Entities.findByDescription", query = "SELECT e FROM Entities e WHERE e.description = :description")})
public class Entities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Code")
    private String code;
    @Size(max = 45)
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "entitycd")
    private Collection<Workplan> workplanCollection;
    @OneToMany(mappedBy = "entityNo")
    private Collection<Budget> budgetCollection;
    @OneToMany(mappedBy = "entityID")
    private Collection<Accounts> accountsCollection;
    @OneToMany(mappedBy = "entityCode")
    private Collection<Cases> casesCollection;
    @OneToMany(mappedBy = "entityCode")
    private Collection<Boutransfers> boutransfersCollection;
    @OneToMany(mappedBy = "entcode")
    private Collection<Request> requestCollection;
    @OneToMany(mappedBy = "entity")
    private Collection<Userrights> userrightsCollection;

    public Entities() {
    }

    public Entities(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Workplan> getWorkplanCollection() {
        return workplanCollection;
    }

    public void setWorkplanCollection(Collection<Workplan> workplanCollection) {
        this.workplanCollection = workplanCollection;
    }

    @XmlTransient
    public Collection<Budget> getBudgetCollection() {
        return budgetCollection;
    }

    public void setBudgetCollection(Collection<Budget> budgetCollection) {
        this.budgetCollection = budgetCollection;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<Cases> getCasesCollection() {
        return casesCollection;
    }

    public void setCasesCollection(Collection<Cases> casesCollection) {
        this.casesCollection = casesCollection;
    }

    @XmlTransient
    public Collection<Boutransfers> getBoutransfersCollection() {
        return boutransfersCollection;
    }

    public void setBoutransfersCollection(Collection<Boutransfers> boutransfersCollection) {
        this.boutransfersCollection = boutransfersCollection;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<Userrights> getUserrightsCollection() {
        return userrightsCollection;
    }

    public void setUserrightsCollection(Collection<Userrights> userrightsCollection) {
        this.userrightsCollection = userrightsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entities)) {
            return false;
        }
        Entities other = (Entities) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Entities[ code=" + code + " ]";
    }
    
}
