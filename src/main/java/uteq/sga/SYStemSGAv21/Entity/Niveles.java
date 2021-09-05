/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "niveles", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveles.findAll", query = "SELECT n FROM Niveles n"),
    @NamedQuery(name = "Niveles.findByIdnivel", query = "SELECT n FROM Niveles n WHERE n.idnivel = :idnivel"),
    @NamedQuery(name = "Niveles.findByNombrenivel", query = "SELECT n FROM Niveles n WHERE n.nombrenivel = :nombrenivel")})
public class Niveles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel")
    private Integer idnivel;
    @Basic(optional = false)
    @Column(name = "nombrenivel")
    private String nombrenivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelusuario")
    private Collection<Usuarios> usuariosCollection;

    public Niveles() {
    }

    public Niveles(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public Niveles(Integer idnivel, String nombrenivel) {
        this.idnivel = idnivel;
        this.nombrenivel = nombrenivel;
    }

    public Integer getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public String getNombrenivel() {
        return nombrenivel;
    }

    public void setNombrenivel(String nombrenivel) {
        this.nombrenivel = nombrenivel;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel != null ? idnivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveles)) {
            return false;
        }
        Niveles other = (Niveles) object;
        if ((this.idnivel == null && other.idnivel != null) || (this.idnivel != null && !this.idnivel.equals(other.idnivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Niveles[ idnivel=" + idnivel + " ]";
    }
    
}
