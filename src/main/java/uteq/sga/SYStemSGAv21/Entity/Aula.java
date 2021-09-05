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
@Table(name = "aula", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByAulaid", query = "SELECT a FROM Aula a WHERE a.aulaid = :aulaid"),
    @NamedQuery(name = "Aula.findByAula", query = "SELECT a FROM Aula a WHERE a.aula = :aula"),
    @NamedQuery(name = "Aula.findByCantidadestudiantes", query = "SELECT a FROM Aula a WHERE a.cantidadestudiantes = :cantidadestudiantes")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aulaid")
    private Integer aulaid;
    @Basic(optional = false)
    @Column(name = "aula")
    private String aula;
    @Column(name = "cantidadestudiantes")
    private Integer cantidadestudiantes;
    @OneToMany(mappedBy = "aula")
    private Collection<Matriculacion> matriculacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulaid")
    private Collection<Asignaciones> asignacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulaid")
    private Collection<Horarioclase> horarioclaseCollection;

    public Aula() {
    }

    public Aula(Integer aulaid) {
        this.aulaid = aulaid;
    }

    public Aula(Integer aulaid, String aula) {
        this.aulaid = aulaid;
        this.aula = aula;
    }

    public Integer getAulaid() {
        return aulaid;
    }

    public void setAulaid(Integer aulaid) {
        this.aulaid = aulaid;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Integer getCantidadestudiantes() {
        return cantidadestudiantes;
    }

    public void setCantidadestudiantes(Integer cantidadestudiantes) {
        this.cantidadestudiantes = cantidadestudiantes;
    }

    @XmlTransient
    public Collection<Matriculacion> getMatriculacionCollection() {
        return matriculacionCollection;
    }

    public void setMatriculacionCollection(Collection<Matriculacion> matriculacionCollection) {
        this.matriculacionCollection = matriculacionCollection;
    }

    @XmlTransient
    public Collection<Asignaciones> getAsignacionesCollection() {
        return asignacionesCollection;
    }

    public void setAsignacionesCollection(Collection<Asignaciones> asignacionesCollection) {
        this.asignacionesCollection = asignacionesCollection;
    }

    @XmlTransient
    public Collection<Horarioclase> getHorarioclaseCollection() {
        return horarioclaseCollection;
    }

    public void setHorarioclaseCollection(Collection<Horarioclase> horarioclaseCollection) {
        this.horarioclaseCollection = horarioclaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aulaid != null ? aulaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.aulaid == null && other.aulaid != null) || (this.aulaid != null && !this.aulaid.equals(other.aulaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Aula[ aulaid=" + aulaid + " ]";
    }
    
}
