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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "asignaturas", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a"),
    @NamedQuery(name = "Asignaturas.findByIdasignatura", query = "SELECT a FROM Asignaturas a WHERE a.idasignatura = :idasignatura"),
    @NamedQuery(name = "Asignaturas.findByNombreasignatura", query = "SELECT a FROM Asignaturas a WHERE a.nombreasignatura = :nombreasignatura")})
public class Asignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignatura")
    private Integer idasignatura;
    @Basic(optional = false)
    @Column(name = "nombreasignatura")
    private String nombreasignatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<PlanEstudio> planEstudioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<InscripcionesAsignaturas> inscripcionesAsignaturasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<EntregaTareas> entregaTareasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<Evaluaciones> evaluacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<Asignaciones> asignacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<Horarioclase> horarioclaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignatura")
    private Collection<PlanificacionTareas> planificacionTareasCollection;
    @JoinColumn(name = "seccionid", referencedColumnName = "seccionid")
    @ManyToOne
    private Secciones seccionid;
    @JoinColumn(name = "idyear", referencedColumnName = "idyearacademico")
    @ManyToOne(optional = false)
    private YearsAcademicos idyear;

    public Asignaturas() {
    }

    public Asignaturas(Integer idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Asignaturas(Integer idasignatura, String nombreasignatura) {
        this.idasignatura = idasignatura;
        this.nombreasignatura = nombreasignatura;
    }

    public Integer getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Integer idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getNombreasignatura() {
        return nombreasignatura;
    }

    public void setNombreasignatura(String nombreasignatura) {
        this.nombreasignatura = nombreasignatura;
    }

    @XmlTransient
    public Collection<PlanEstudio> getPlanEstudioCollection() {
        return planEstudioCollection;
    }

    public void setPlanEstudioCollection(Collection<PlanEstudio> planEstudioCollection) {
        this.planEstudioCollection = planEstudioCollection;
    }

    @XmlTransient
    public Collection<InscripcionesAsignaturas> getInscripcionesAsignaturasCollection() {
        return inscripcionesAsignaturasCollection;
    }

    public void setInscripcionesAsignaturasCollection(Collection<InscripcionesAsignaturas> inscripcionesAsignaturasCollection) {
        this.inscripcionesAsignaturasCollection = inscripcionesAsignaturasCollection;
    }

    @XmlTransient
    public Collection<EntregaTareas> getEntregaTareasCollection() {
        return entregaTareasCollection;
    }

    public void setEntregaTareasCollection(Collection<EntregaTareas> entregaTareasCollection) {
        this.entregaTareasCollection = entregaTareasCollection;
    }

    @XmlTransient
    public Collection<Evaluaciones> getEvaluacionesCollection() {
        return evaluacionesCollection;
    }

    public void setEvaluacionesCollection(Collection<Evaluaciones> evaluacionesCollection) {
        this.evaluacionesCollection = evaluacionesCollection;
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

    public Secciones getSeccionid() {
        return seccionid;
    }

    public void setSeccionid(Secciones seccionid) {
        this.seccionid = seccionid;
    }

    public YearsAcademicos getIdyear() {
        return idyear;
    }

    public void setIdyear(YearsAcademicos idyear) {
        this.idyear = idyear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignatura != null ? idasignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.idasignatura == null && other.idasignatura != null) || (this.idasignatura != null && !this.idasignatura.equals(other.idasignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Asignaturas[ idasignatura=" + idasignatura + " ]";
    }
    
}
