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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "boutransfers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boutransfers.findAll", query = "SELECT b FROM Boutransfers b"),
    @NamedQuery(name = "Boutransfers.findByitemcode", query = "SELECT pda FROM Boutransfers pda WHERE pda.itemcode.itemcode =:itemCode"),
    @NamedQuery(name = "Boutransfers.findByCasecode", query = "SELECT pda FROM Boutransfers pda WHERE pda.casecode5.caseCode =:caseCode"),
    @NamedQuery(name = "Boutransfers.findByIdbou", query = "SELECT b FROM Boutransfers b WHERE b.idbou = :idbou"),
    @NamedQuery(name = "Boutransfers.findByDate", query = "SELECT b FROM Boutransfers b WHERE b.bdate = :bdate"),
    @NamedQuery(name = "Boutransfers.findByTransfertype", query = "SELECT b FROM Boutransfers b WHERE b.transfertype = :transfertype"),
    @NamedQuery(name = "Boutransfers.findByDebitacctno", query = "SELECT b FROM Boutransfers b WHERE b.debitacctno = :debitacctno"),
    @NamedQuery(name = "Boutransfers.findByDebitacctname", query = "SELECT b FROM Boutransfers b WHERE b.debitacctname = :debitacctname"),
    @NamedQuery(name = "Boutransfers.findByDebitamount", query = "SELECT b FROM Boutransfers b WHERE b.debitamount = :debitamount"),
    @NamedQuery(name = "Boutransfers.findByCreditbank", query = "SELECT b FROM Boutransfers b WHERE b.creditbank = :creditbank"),
    @NamedQuery(name = "Boutransfers.findByCreditacct", query = "SELECT b FROM Boutransfers b WHERE b.creditacct = :creditacct"),
    @NamedQuery(name = "Boutransfers.findByBankstaffid", query = "SELECT b FROM Boutransfers b WHERE b.bankstaffid = :bankstaffid"),
    @NamedQuery(name = "Boutransfers.findByGovtstaffid", query = "SELECT b FROM Boutransfers b WHERE b.govtstaffid = :govtstaffid")})
public class Boutransfers implements Serializable {
    @Column(name = "timestamp5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp5;
    @Size(max = 45)
    @Column(name = "craccstat")
    private String craccstat;
    @Column(name = "limitamt")
    private Integer limitamt;
    @JoinColumn(name = "reqid", referencedColumnName = "Filenme")
    @ManyToOne
    private Request reqid;
    @Size(max = 45)
    @Column(name = "workplanid")
    private String workplanid;
   
  
    @JoinColumn(name = "EntityCode", referencedColumnName = "Code")
    @ManyToOne
    private Entities entityCode;
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbou")
    private Integer idbou;
    @Column(name = "bdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bdate;
    @Size(max = 45)
    @Column(name = "transfertype")
    private String transfertype;
    @Size(max = 45)
    @Column(name = "debitacctno")
    private String debitacctno;
    @Size(max = 45)
    @Column(name = "debitacctname")
    private String debitacctname;
    @Column(name = "debitamount")
    private Integer debitamount;
    @Size(max = 45)
    @Column(name = "creditbank")
    private String creditbank;
    @Size(max = 45)
    @Column(name = "creditacct")
    private String creditacct;
    @Size(max = 45)
    @Column(name = "bankstaffid")
    private String bankstaffid;
    @Size(max = 45)
    @Column(name = "govtstaffid")
    private String govtstaffid;
    @JoinColumn(name = "casecode5", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode5;
    @JoinColumn(name = "itemcode", referencedColumnName = "itemcode")
    @ManyToOne
    private Budget itemcode;

    public Boutransfers() {
    }

    public Boutransfers(Integer idbou) {
        this.idbou = idbou;
    }

    public Integer getIdbou() {
        return idbou;
    }

    public void setIdbou(Integer idbou) {
        this.idbou = idbou;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getTransfertype() {
        return transfertype;
    }

    public void setTransfertype(String transfertype) {
        this.transfertype = transfertype;
    }

    public String getDebitacctno() {
        return debitacctno;
    }

    public void setDebitacctno(String debitacctno) {
        this.debitacctno = debitacctno;
    }

    public String getDebitacctname() {
        return debitacctname;
    }

    public void setDebitacctname(String debitacctname) {
        this.debitacctname = debitacctname;
    }

    public Integer getDebitamount() {
        return debitamount;
    }

    public void setDebitamount(Integer debitamount) {
        this.debitamount = debitamount;
    }

    public String getCreditbank() {
        return creditbank;
    }

    public void setCreditbank(String creditbank) {
        this.creditbank = creditbank;
    }

    public String getCreditacct() {
        return creditacct;
    }

    public void setCreditacct(String creditacct) {
        this.creditacct = creditacct;
    }

    public String getBankstaffid() {
        return bankstaffid;
    }

    public void setBankstaffid(String bankstaffid) {
        this.bankstaffid = bankstaffid;
    }

    public String getGovtstaffid() {
        return govtstaffid;
    }

    public void setGovtstaffid(String govtstaffid) {
        this.govtstaffid = govtstaffid;
    }

    public Cases getCasecode5() {
        return casecode5;
    }

    public void setCasecode5(Cases casecode5) {
        this.casecode5 = casecode5;
    }

    public Budget getItemcode() {
        return itemcode;
    }

    public void setItemcode(Budget itemcode) {
        this.itemcode = itemcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbou != null ? idbou.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boutransfers)) {
            return false;
        }
        Boutransfers other = (Boutransfers) object;
        if ((this.idbou == null && other.idbou != null) || (this.idbou != null && !this.idbou.equals(other.idbou))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Boutransfers[ idbou=" + idbou + " ]";
    }

    

    public Entities getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(Entities entityCode) {
        this.entityCode = entityCode;
    }



    public String getWorkplanid() {
        return workplanid;
    }

    public void setWorkplanid(String workplanid) {
        this.workplanid = workplanid;
    }

 

    public Request getReqid() {
        return reqid;
    }

    public void setReqid(Request reqid) {
        this.reqid = reqid;
    }

    public String getCraccstat() {
        return craccstat;
    }

    public void setCraccstat(String craccstat) {
        this.craccstat = craccstat;
    }

    public Integer getLimitamt() {
        return limitamt;
    }

    public void setLimitamt(Integer limitamt) {
        this.limitamt = limitamt;
    }

    public Date getTimestamp5() {
        return timestamp5;
    }

    public void setTimestamp5(Date timestamp5) {
        this.timestamp5 = timestamp5;
    }
    
}
