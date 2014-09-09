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

/**
 *
 * @author pc
 */
@Entity
@Table(name = "casetrans")
@NamedQueries({
    @NamedQuery(name = "Casetrans.findAll", query = "SELECT c FROM Casetrans c"),
    @NamedQuery(name = "Casetrans.findByTransactionid", query = "SELECT c FROM Casetrans c WHERE c.transactionid = :transactionid"),
    @NamedQuery(name = "Casetrans.findByCasecode", query = "SELECT c from Casetrans c where c.caseCode.caseCode =:caseCode"),
    @NamedQuery(name = "Casetrans.findByTransdate", query = "SELECT c FROM Casetrans c WHERE c.transdate = :transdate"),
    @NamedQuery(name = "Casetrans.findByTranscode", query = "SELECT c FROM Casetrans c WHERE c.transcode = :transcode"),
    @NamedQuery(name = "Casetrans.findByTransAmount", query = "SELECT c FROM Casetrans c WHERE c.transAmount = :transAmount"),
    @NamedQuery(name = "Casetrans.findByTransType", query = "SELECT c FROM Casetrans c WHERE c.transType = :transType"),
    @NamedQuery(name = "Casetrans.findByTransaccount", query = "SELECT c FROM Casetrans c WHERE c.transaccount = :transaccount")})
public class Casetrans implements Serializable {
    @Column(name = "timestamp2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp2;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transactionid")
    private Integer transactionid;
    @Column(name = "transdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transdate;
    @Column(name = "transcode")
    private String transcode;
    @Column(name = "transAmount")
    private Integer transAmount;
    @Column(name = "transType")
    private String transType;
    @Column(name = "transaccount")
    private String transaccount;
    @JoinColumn(name = "Case_code", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases caseCode;

    public Casetrans() {
    }

    public Casetrans(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }

    public Integer getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Integer transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransaccount() {
        return transaccount;
    }

    public void setTransaccount(String transaccount) {
        this.transaccount = transaccount;
    }

    public Cases getCases() {
        return caseCode;
    }

    public void setCases(Cases caseCode) {
        this.caseCode = caseCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionid != null ? transactionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casetrans)) {
            return false;
        }
        Casetrans other = (Casetrans) object;
        if ((this.transactionid == null && other.transactionid != null) || (this.transactionid != null && !this.transactionid.equals(other.transactionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Casetrans[transactionid=" + transactionid + "]";
    }

    public Date getTimestamp2() {
        return timestamp2;
    }

    public void setTimestamp2(Date timestamp2) {
        this.timestamp2 = timestamp2;
    }

}
