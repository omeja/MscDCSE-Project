/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "realtime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Realtime.findAll", query = "SELECT r FROM Realtime r"),
    @NamedQuery(name = "Realtime.findById", query = "SELECT r.value FROM Realtime r WHERE r.id = :id"),
    @NamedQuery(name = "Realtime.findByValue", query = "SELECT r FROM Realtime r WHERE r.value = :value")})
public class Realtime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "value")
    private String value;

    public Realtime() {
    }

    public Realtime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realtime)) {
            return false;
        }
        Realtime other = (Realtime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbase.Realtime[ id=" + id + " ]";
    }
    
}
