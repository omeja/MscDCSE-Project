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
@Table(name = "budget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budget.findAll", query = "SELECT b FROM Budget b"),
     @NamedQuery(name = "Budget.findByCasecode", query = "SELECT b FROM Budget b WHERE b.casecode.caseCode =:caseCode"),
    @NamedQuery(name = "Budget.findByDescription", query = "SELECT b FROM Budget b WHERE b.description = :description"),
    @NamedQuery(name = "Budget.findByAmount", query = "SELECT b FROM Budget b WHERE b.amount = :amount")})
public class Budget implements Serializable {
    @Column(name = "timestamp12")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp12;
    @Size(max = 45)
    @Column(name = "yearPeriod")
    private String yearPeriod;
    @Size(max = 45)
    @Column(name = "Source")
    private String source;
    @Size(max = 45)
    @Column(name = "AccountNo")
    private String accountNo;
    @Column(name = "CreditDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creditDate;
    @JoinColumn(name = "EntityNo", referencedColumnName = "Code")
    @ManyToOne
    private Entities entityNo;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemcode")
    private Integer itemcode;
  
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private Integer amount;
    @Size(max = 45)
   
    @OneToMany(mappedBy = "itemcode")
    private Collection<Boutransfers> boutransfersCollection;

    public Budget() {
    }

    public Budget(Integer itemcode) {
        this.itemcode = itemcode;
    }

    public Integer getItemcode() {
        return itemcode;
    }

    public void setItemcode(Integer itemcode) {
        this.itemcode = itemcode;
    }

  

 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }



    @XmlTransient
    public Collection<Boutransfers> getBoutransfersCollection() {
        return boutransfersCollection;
    }

    public void setBoutransfersCollection(Collection<Boutransfers> boutransfersCollection) {
        this.boutransfersCollection = boutransfersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemcode != null ? itemcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.itemcode == null && other.itemcode != null) || (this.itemcode != null && !this.itemcode.equals(other.itemcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Budget[ itemcode=" + itemcode + " ]";
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Date creditDate) {
        this.creditDate = creditDate;
    }

    public Entities getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(Entities entityNo) {
        this.entityNo = entityNo;
    }

    public Cases getCasecode() {
        return casecode;
    }

    public void setCasecode(Cases casecode) {
        this.casecode = casecode;
    }

    public String getYearPeriod() {
        return yearPeriod;
    }

    public void setYearPeriod(String yearPeriod) {
        this.yearPeriod = yearPeriod;
    }

    public Date getTimestamp12() {
        return timestamp12;
    }

    public void setTimestamp12(Date timestamp12) {
        this.timestamp12 = timestamp12;
    }
    
}
