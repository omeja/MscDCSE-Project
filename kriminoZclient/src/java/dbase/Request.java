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
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByFilenme", query = "SELECT r FROM Request r WHERE r.filenme = :filenme"),
    @NamedQuery(name = "Request.findByDebitaccount", query = "SELECT r FROM Request r WHERE r.debitaccount = :debitaccount"),
    @NamedQuery(name = "Request.findByCasecode", query = "SELECT abc FROM Request abc WHERE abc.casecode.caseCode = :caseCode"),
    @NamedQuery(name = "Request.findByCreditaccount", query = "SELECT r FROM Request r WHERE r.creditaccount = :creditaccount"),
    @NamedQuery(name = "Request.findByAmount", query = "SELECT r FROM Request r WHERE r.amount = :amount"),
    @NamedQuery(name = "Request.findByReqDate", query = "SELECT r FROM Request r WHERE r.reqDate = :reqDate")})
public class Request implements Serializable {
    @Column(name = "timestamp7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp7;
    @OneToMany(mappedBy = "reqid")
    private Collection<Boutransfers> boutransfersCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Filenme")
    private String filenme;
    @Size(max = 45)
    @Column(name = "Debitaccount")
    private String debitaccount;
    @Size(max = 45)
    @Column(name = "Creditaccount")
    private String creditaccount;
    @Column(name = "Amount")
    private Integer amount;
    @Column(name = "reqDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDate;
   @OneToMany(mappedBy = "reqidd")
   private Collection<Emails> emailsCollection;
   @OneToMany(mappedBy = "requestID")
    private Collection<Phonelogs> phonelogsCollection;
   
    @JoinColumn(name = "WorkplnId", referencedColumnName = "WorkPlanCode")
    @ManyToOne
    private Workplan workplnId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserID")
    @ManyToOne
    private Userrights userId;
    @JoinColumn(name = "Entcode", referencedColumnName = "Code")
    @ManyToOne
    private Entities entcode;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;

    public Request() {
    }

    public Request(String filenme) {
        this.filenme = filenme;
    }

    public String getFilenme() {
        return filenme;
    }

    public void setFilenme(String filenme) {
        this.filenme = filenme;
    }

    public String getDebitaccount() {
        return debitaccount;
    }

    public void setDebitaccount(String debitaccount) {
        this.debitaccount = debitaccount;
    }

    public String getCreditaccount() {
        return creditaccount;
    }

    public void setCreditaccount(String creditaccount) {
        this.creditaccount = creditaccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    @XmlTransient
    public Collection<Emails> getEmailsCollection() {
        return emailsCollection;
    }

    public void setEmailsCollection(Collection<Emails> emailsCollection) {
        this.emailsCollection = emailsCollection;
    }

    @XmlTransient
    public Collection<Phonelogs> getPhonelogsCollection() {
        return phonelogsCollection;
    }

    public void setPhonelogsCollection(Collection<Phonelogs> phonelogsCollection) {
        this.phonelogsCollection = phonelogsCollection;
    }

    @XmlTransient
  

    public Workplan getWorkplnId() {
        return workplnId;
    }

    public void setWorkplnId(Workplan workplnId) {
        this.workplnId = workplnId;
    }

    public Userrights getUserId() {
        return userId;
    }

    public void setUserId(Userrights userId) {
        this.userId = userId;
    }

    public Entities getEntcode() {
        return entcode;
    }

    public void setEntcode(Entities entcode) {
        this.entcode = entcode;
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
        hash += (filenme != null ? filenme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.filenme == null && other.filenme != null) || (this.filenme != null && !this.filenme.equals(other.filenme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Request[ filenme=" + filenme + " ]";
    }

    @XmlTransient
    public Collection<Boutransfers> getBoutransfersCollection() {
        return boutransfersCollection;
    }

    public void setBoutransfersCollection(Collection<Boutransfers> boutransfersCollection) {
        this.boutransfersCollection = boutransfersCollection;
    }

    public Date getTimestamp7() {
        return timestamp7;
    }

    public void setTimestamp7(Date timestamp7) {
        this.timestamp7 = timestamp7;
    }
    
}
