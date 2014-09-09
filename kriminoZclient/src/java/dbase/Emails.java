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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "emails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emails.findAll", query = "SELECT e FROM Emails e"),
    @NamedQuery(name = "Emails.findByEmailID", query = "SELECT e FROM Emails e WHERE e.emailID = :emailID"),
    @NamedQuery(name = "Emails.findByEdate", query = "SELECT e FROM Emails e WHERE e.edate = :edate"),
    @NamedQuery(name = "Emails.findByCasecode", query = "SELECT abc FROM Emails abc WHERE abc.casecode.caseCode = :caseCode"),
    @NamedQuery(name = "Emails.findBySourceAddr", query = "SELECT e FROM Emails e WHERE e.sourceAddr = :sourceAddr"),
    @NamedQuery(name = "Emails.findByDestAddr", query = "SELECT e FROM Emails e WHERE e.destAddr = :destAddr")})
public class Emails implements Serializable {
    @Column(name = "timestamp11")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp11;
    @JoinColumn(name = "reqidd", referencedColumnName = "Filenme")
    @ManyToOne
    private Request reqidd;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmailID")
    private Integer emailID;
    @Size(max = 45)
    @Column(name = "Edate")
    private String edate;
    @Size(max = 45)
    @Column(name = "SourceAddr")
    private String sourceAddr;
    @Size(max = 45)
    @Column(name = "DestAddr")
    private String destAddr;
    @JoinColumn(name = "Casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;
//  @JoinColumn(name = "ReqIDD", referencedColumnName = "Filenme")
//    @ManyToOne
//    private Request reqIDD;
   // @OneToMany(mappedBy = "emailId")
   // private Collection<Boutransfers> boutransfersCollection;

    public Emails() {
    }

    public Emails(Integer emailID) {
        this.emailID = emailID;
    }

    public Integer getEmailID() {
        return emailID;
    }

    public void setEmailID(Integer emailID) {
        this.emailID = emailID;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getSourceAddr() {
        return sourceAddr;
    }

    public void setSourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;
    }

    public String getDestAddr() {
        return destAddr;
    }

    public void setDestAddr(String destAddr) {
        this.destAddr = destAddr;
    }

    public Cases getCasecode() {
        return casecode;
    }

    public void setCasecode(Cases casecode) {
        this.casecode = casecode;
    }

//    public Request getReqIDD() {
//        return reqIDD;
//    }
//
//    public void setReqID(Request reqIDD) {
//        this.reqIDD = reqIDD;
//    }

    @XmlTransient
//    public Collection<Boutransfers> getBoutransfersCollection() {
//        return boutransfersCollection;
//    }
//
//    public void setBoutransfersCollection(Collection<Boutransfers> boutransfersCollection) {
//        this.boutransfersCollection = boutransfersCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailID != null ? emailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.emailID == null && other.emailID != null) || (this.emailID != null && !this.emailID.equals(other.emailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Emails[ emailID=" + emailID + " ]";
    }

    public Request getReqidd() {
        return reqidd;
    }

    public void setReqidd(Request reqidd) {
        this.reqidd = reqidd;
    }

    public Date getTimestamp11() {
        return timestamp11;
    }

    public void setTimestamp11(Date timestamp11) {
        this.timestamp11 = timestamp11;
    }
    
}
