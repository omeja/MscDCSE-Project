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
@Table(name = "userrights")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userrights.findAll", query = "SELECT u FROM Userrights u"),
    @NamedQuery(name = "Userrights.findByUserID", query = "SELECT u FROM Userrights u WHERE u.userID = :userID"),
    @NamedQuery(name = "Userrights.findByDateCreated", query = "SELECT u FROM Userrights u WHERE u.dateCreated = :dateCreated"),
    @NamedQuery(name = "Userrights.findByCasecode", query = "SELECT ubc FROM Userrights ubc WHERE ubc.casecode.caseCode = :caseCode"),
    @NamedQuery(name = "Userrights.findByCreater", query = "SELECT u FROM Userrights u WHERE u.creater = :creater"),
    @NamedQuery(name = "Userrights.findByUserAuthority", query = "SELECT u FROM Userrights u WHERE u.userAuthority = :userAuthority"),
    @NamedQuery(name = "Userrights.findByStaffLevel", query = "SELECT u FROM Userrights u WHERE u.staffLevel = :staffLevel")})
public class Userrights implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "UserID")
    private String userID;
    @Size(max = 45)
    @Column(name = "DateCreated")
    private String dateCreated;
    @Size(max = 45)
    @Column(name = "Creater")
    private String creater;
    @Size(max = 45)
    @Column(name = "UserAuthority")
    private String userAuthority;
    @Size(max = 45)
    @Column(name = "StaffLevel")
    private String staffLevel;
    @OneToMany(mappedBy = "userId")
    private Collection<Request> requestCollection;
    @JoinColumn(name = "Entity", referencedColumnName = "Code")
    @ManyToOne
    private Entities entity;
    @JoinColumn(name = "casecode", referencedColumnName = "caseCode")
    @ManyToOne
    private Cases casecode;

    public Userrights() {
    }

    public Userrights(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }

    public String getStaffLevel() {
        return staffLevel;
    }

    public void setStaffLevel(String staffLevel) {
        this.staffLevel = staffLevel;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public Entities getEntity() {
        return entity;
    }

    public void setEntity(Entities entity) {
        this.entity = entity;
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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrights)) {
            return false;
        }
        Userrights other = (Userrights) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Userrights[ userID=" + userID + " ]";
    }
    
}
