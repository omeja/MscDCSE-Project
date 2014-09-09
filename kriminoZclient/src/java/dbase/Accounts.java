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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByNo", query = "SELECT a FROM Accounts a WHERE a.num = :num"),
    @NamedQuery(name = "Accounts.findByAccountName", query = "SELECT a FROM Accounts a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Accounts.findByCasecode", query = "SELECT abc FROM Accounts abc WHERE abc.csscode.caseCode = :caseCode"),
    @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status"),
    @NamedQuery(name = "Accounts.findByLimitAmt", query = "SELECT a FROM Accounts a WHERE a.limitAmt = :limitAmt")})
public class Accounts implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Num")
    private String num;
    @Size(max = 45)
    @Column(name = "AccountName")
    private String accountName;
    @Size(max = 45)
    @Column(name = "Status")
    private String status;
    @Column(name = "LimitAmt")
    private Integer limitAmt;
    @JoinColumn(name = "EntityID", referencedColumnName = "Code")
    @ManyToOne
    private Entities entityID;
    @JoinColumn(name = "Csscode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases csscode;

    public Accounts() {
    }

    public Accounts(String num) {
        this.num = num;
    }

    public String getNo() {
        return num;
    }

    public void setNo(String num) {
        this.num = num;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLimitAmt() {
        return limitAmt;
    }

    public void setLimitAmt(Integer limitAmt) {
        this.limitAmt = limitAmt;
    }

    public Entities getEntityID() {
        return entityID;
    }

    public void setEntityID(Entities entityID) {
        this.entityID = entityID;
    }

    public Cases getCsscode() {
        return csscode;
    }

    public void setCsscode(Cases csscode) {
        this.csscode = csscode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num != null ? num.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Accounts[ num=" + num + " ]";
    }

  
}
