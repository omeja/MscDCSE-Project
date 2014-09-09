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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "phonelogs")
@NamedQueries({
    @NamedQuery(name = "Phonelogs.findAll", query = "SELECT p FROM Phonelogs p"),
    @NamedQuery(name = "Phonelogs.findByCallId", query = "SELECT p FROM Phonelogs p WHERE p.callId = :callId"),
     @NamedQuery(name = "Phonelogs.findByCasecode", query = "SELECT pd FROM Phonelogs pd WHERE pd.caseCode.caseCode =:caseCode"),
    @NamedQuery(name = "Phonelogs.findByCallDate", query = "SELECT p FROM Phonelogs p WHERE p.callDate = :callDate"),
    @NamedQuery(name = "Phonelogs.findByFromNo", query = "SELECT p FROM Phonelogs p WHERE p.fromNo = :fromNo"),
    @NamedQuery(name = "Phonelogs.findByToNo", query = "SELECT p FROM Phonelogs p WHERE p.toNo = :toNo")})
public class Phonelogs implements Serializable {
    @Column(name = "timestamp1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp1;
    @JoinColumn(name = "RequestID", referencedColumnName = "Filenme")
    @ManyToOne
    private Request requestID;
    @OneToMany(mappedBy = "callid")
   // private Collection<Boutransfers> boutransfersCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "callId")
    private Integer callId;
    @Column(name = "callDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callDate;
    @Column(name = "fromNo")
    private String fromNo;
    @Column(name = "toNo")
    private String toNo;
    @JoinColumn(name = "Case_Code", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases caseCode;

    public Cases getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(Cases caseCode) {
        this.caseCode = caseCode;
    }

    public Phonelogs() {
    }

    public Phonelogs(Integer callId) {
        this.callId = callId;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getFromNo() {
        return fromNo;
    }

    public void setFromNo(String fromNo) {
        this.fromNo = fromNo;
    }

    public String getToNo() {
        return toNo;
    }

    public void setToNo(String toNo) {
        this.toNo = toNo;
    }

    public Cases getCases() {
        return caseCode;
    }

    public void setCases(Cases cases) {
        this.caseCode = caseCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (callId != null ? callId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phonelogs)) {
            return false;
        }
        Phonelogs other = (Phonelogs) object;
        if ((this.callId == null && other.callId != null) || (this.callId != null && !this.callId.equals(other.callId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Phonelogs[callId=" + callId + "]";
    }

    @XmlTransient

    public Request getRequestID() {
        return requestID;
    }

    public void setRequestID(Request requestID) {
        this.requestID = requestID;
    }

    public Date getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(Date timestamp1) {
        this.timestamp1 = timestamp1;
    }

}
