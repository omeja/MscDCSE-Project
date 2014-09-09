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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "income")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i"),
    @NamedQuery(name = "Income.findByCasecode", query = "SELECT pdc FROM Income pdc WHERE pdc.casecode.caseCode =:caseCode"),
    @NamedQuery(name = "Income.findByItemno", query = "SELECT i FROM Income i WHERE i.itemno = :itemno"),
    @NamedQuery(name = "Income.findByDescription", query = "SELECT i FROM Income i WHERE i.description = :description"),
    @NamedQuery(name = "Income.findByIncometype", query = "SELECT i FROM Income i WHERE i.incometype = :incometype"),
    @NamedQuery(name = "Income.findByFrequency", query = "SELECT i FROM Income i WHERE i.frequency = :frequency"),
    @NamedQuery(name = "Income.findByAmount", query = "SELECT i FROM Income i WHERE i.amount = :amount")})
public class Income implements Serializable {
    @Column(name = "timestamp6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp6;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemno")
    private Integer itemno;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "incometype")
    private String incometype;
    @Size(max = 45)
    @Column(name = "frequency")
    private String frequency;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;

    public Income() {
    }

    public Income(Integer itemno) {
        this.itemno = itemno;
    }

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncometype() {
        return incometype;
    }

    public void setIncometype(String incometype) {
        this.incometype = incometype;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        hash += (itemno != null ? itemno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.itemno == null && other.itemno != null) || (this.itemno != null && !this.itemno.equals(other.itemno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Income[ itemno=" + itemno + " ]";
    }

    public Date getTimestamp6() {
        return timestamp6;
    }

    public void setTimestamp6(Date timestamp6) {
        this.timestamp6 = timestamp6;
    }
    
}
