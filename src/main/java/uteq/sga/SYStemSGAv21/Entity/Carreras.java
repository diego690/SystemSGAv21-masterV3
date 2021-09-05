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
@Table(name = "carreras", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreras.findAll", query = "SELECT c FROM Carreras c"),
    @NamedQuery(name = "Carreras.findByIdcarrera", query = "SELECT c FROM Carreras c WHERE c.idcarrera = :idcarrera"),
    @NamedQuery(name = "Carreras.findByNombrecarrera", query = "SELECT c FROM Carreras c WHERE c.nombrecarrera = :nombrecarrera")})
public class Carreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarrera")
    private Integer idcarrera;
    @Basic(optional = false)
    @Column(name = "nombrecarrera")
    private String nombrecarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcarrera")
    private Collection<PlanEstudio> planEstudioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<Matriculacion> matriculacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcarrera")
    private Collection<Asignaciones> asignacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcarrera")
    private Collection<Horarioclase> horarioclaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claseid")
    private Collection<PlanificacionTareas> planificacionTareasCollection;

    public Carreras() {
    }

    public Carreras(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Carreras(Integer idcarrera, String nombrecarrera) {
        this.idcarrera = idcarrera;
        this.nombrecarrera = nombrecarrera;
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombrecarrera() {
        return nombrecarrera;
    }

    public void setNombrecarrera(String nombrecarrera) {
        this.nombrecarrera = nombrecarrera;
    }

    @XmlTransient
    public Collection<PlanEstudio> getPlanEstudioCollection() {
        return planEstudioCollection;
    }

    public void setPlanEstudioCollection(Collection<PlanEstudio> planEstudioCollection) {
        this.planEstudioCollection = planEstudioCollection;
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

    @XmlTransient
    public Collection<PlanificacionTareas> getPlanificacionTareasCollection() {
        return planificacionTareasCollection;
    }

    public void setPlanificacionTareasCollection(Collection<PlanificacionTareas> planificacionTareasCollection) {
        this.planificacionTareasCollection = planificacionTareasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarrera != null ? idcarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carreras)) {
            return false;
        }
        Carreras other = (Carreras) object;
        if ((this.idcarrera == null && other.idcarrera != null) || (this.idcarrera != null && !this.idcarrera.equals(other.idcarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Carreras[ idcarrera=" + idcarrera + " ]";
    }
    
}
