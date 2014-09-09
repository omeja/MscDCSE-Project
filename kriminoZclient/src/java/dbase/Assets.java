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
@Table(name = "assets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assets.findAll", query = "SELECT a FROM Assets a"),
    @NamedQuery(name = "Assets.findByCasecode", query = "SELECT pdb FROM Assets pdb WHERE pdb.casecode.caseCode =:caseCode"),
    @NamedQuery(name = "Assets.findByAssetcode", query = "SELECT a FROM Assets a WHERE a.assetcode = :assetcode"),
    @NamedQuery(name = "Assets.findByAssettype", query = "SELECT a FROM Assets a WHERE a.assettype = :assettype"),
    @NamedQuery(name = "Assets.findByMarketvalue", query = "SELECT a FROM Assets a WHERE a.marketvalue = :marketvalue"),
    @NamedQuery(name = "Assets.findByAcquiredate", query = "SELECT a FROM Assets a WHERE a.acquiredate = :acquiredate"),
    @NamedQuery(name = "Assets.findByAcquirecost", query = "SELECT a FROM Assets a WHERE a.acquirecost = :acquirecost"),
    @NamedQuery(name = "Assets.findByAcquiremode", query = "SELECT a FROM Assets a WHERE a.acquiremode = :acquiremode"),
    @NamedQuery(name = "Assets.findBySourceoffunds", query = "SELECT a FROM Assets a WHERE a.sourceoffunds = :sourceoffunds")})
public class Assets implements Serializable {
    @Column(name = "timestamp4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp4;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assetcode")
    private Integer assetcode;
    @Size(max = 45)
    @Column(name = "assettype")
    private String assettype;
    @Column(name = "marketvalue")
    private Integer marketvalue;
    @Column(name = "acquiredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acquiredate;
    @Column(name = "acquirecost")
    private Integer acquirecost;
    @Size(max = 45)
    @Column(name = "acquiremode")
    private String acquiremode;
    @Size(max = 45)
    @Column(name = "sourceoffunds")
    private String sourceoffunds;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;

    public Assets() {
    }

    public Assets(Integer assetcode) {
        this.assetcode = assetcode;
    }

    public Integer getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(Integer assetcode) {
        this.assetcode = assetcode;
    }

    public String getAssettype() {
        return assettype;
    }

    public void setAssettype(String assettype) {
        this.assettype = assettype;
    }

    public Integer getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(Integer marketvalue) {
        this.marketvalue = marketvalue;
    }

    public Date getAcquiredate() {
        return acquiredate;
    }

    public void setAcquiredate(Date acquiredate) {
        this.acquiredate = acquiredate;
    }

    public Integer getAcquirecost() {
        return acquirecost;
    }

    public void setAcquirecost(Integer acquirecost) {
        this.acquirecost = acquirecost;
    }

    public String getAcquiremode() {
        return acquiremode;
    }

    public void setAcquiremode(String acquiremode) {
        this.acquiremode = acquiremode;
    }

    public String getSourceoffunds() {
        return sourceoffunds;
    }

    public void setSourceoffunds(String sourceoffunds) {
        this.sourceoffunds = sourceoffunds;
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
        hash += (assetcode != null ? assetcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assets)) {
            return false;
        }
        Assets other = (Assets) object;
        if ((this.assetcode == null && other.assetcode != null) || (this.assetcode != null && !this.assetcode.equals(other.assetcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Assets[ assetcode=" + assetcode + " ]";
    }

    public Date getTimestamp4() {
        return timestamp4;
    }

    public void setTimestamp4(Date timestamp4) {
        this.timestamp4 = timestamp4;
    }
    
}
