/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "planificacion_tareas", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanificacionTareas.findAll", query = "SELECT p FROM PlanificacionTareas p"),
    @NamedQuery(name = "PlanificacionTareas.findByIdplanificacion", query = "SELECT p FROM PlanificacionTareas p WHERE p.idplanificacion = :idplanificacion"),
    @NamedQuery(name = "PlanificacionTareas.findByUnidad", query = "SELECT p FROM PlanificacionTareas p WHERE p.unidad = :unidad"),
    @NamedQuery(name = "PlanificacionTareas.findByDescripcionunidad", query = "SELECT p FROM PlanificacionTareas p WHERE p.descripcionunidad = :descripcionunidad"),
    @NamedQuery(name = "PlanificacionTareas.findByTarea", query = "SELECT p FROM PlanificacionTareas p WHERE p.tarea = :tarea"),
    @NamedQuery(name = "PlanificacionTareas.findByDescripciontarea", query = "SELECT p FROM PlanificacionTareas p WHERE p.descripciontarea = :descripciontarea"),
    @NamedQuery(name = "PlanificacionTareas.findByFechapublicacion", query = "SELECT p FROM PlanificacionTareas p WHERE p.fechapublicacion = :fechapublicacion"),
    @NamedQuery(name = "PlanificacionTareas.findByFechapresentacion", query = "SELECT p FROM PlanificacionTareas p WHERE p.fechapresentacion = :fechapresentacion"),
    @NamedQuery(name = "PlanificacionTareas.findByCodigotarea", query = "SELECT p FROM PlanificacionTareas p WHERE p.codigotarea = :codigotarea")})
public class PlanificacionTareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanificacion")
    private Integer idplanificacion;
    @Basic(optional = false)
    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @Column(name = "descripcionunidad")
    private String descripcionunidad;
    @Basic(optional = false)
    @Column(name = "tarea")
    private String tarea;
    @Basic(optional = false)
    @Column(name = "descripciontarea")
    private String descripciontarea;
    @Basic(optional = false)
    @Column(name = "fechapublicacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechapublicacion;
    @Basic(optional = false)
    @Column(name = "fechapresentacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechapresentacion;
    @Basic(optional = false)
    @Column(name = "codigotarea")
    private int codigotarea;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false)
    private Asignaturas idasignatura;
    @JoinColumn(name = "claseid", referencedColumnName = "idcarrera")
    @ManyToOne(optional = false)
    private Carreras claseid;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docentes iddocente;

    public PlanificacionTareas() {
    }

    public PlanificacionTareas(Integer idplanificacion) {
        this.idplanificacion = idplanificacion;
    }

    public PlanificacionTareas(Integer idplanificacion, String unidad, String descripcionunidad, String tarea, String descripciontarea, Date fechapublicacion, Date fechapresentacion, int codigotarea) {
        this.idplanificacion = idplanificacion;
        this.unidad = unidad;
        this.descripcionunidad = descripcionunidad;
        this.tarea = tarea;
        this.descripciontarea = descripciontarea;
        this.fechapublicacion = fechapublicacion;
        this.fechapresentacion = fechapresentacion;
        this.codigotarea = codigotarea;
    }

    public Integer getIdplanificacion() {
        return idplanificacion;
    }

    public void setIdplanificacion(Integer idplanificacion) {
        this.idplanificacion = idplanificacion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcionunidad() {
        return descripcionunidad;
    }

    public void setDescripcionunidad(String descripcionunidad) {
        this.descripcionunidad = descripcionunidad;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescripciontarea() {
        return descripciontarea;
    }

    public void setDescripciontarea(String descripciontarea) {
        this.descripciontarea = descripciontarea;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public Date getFechapresentacion() {
        return fechapresentacion;
    }

    public void setFechapresentacion(Date fechapresentacion) {
        this.fechapresentacion = fechapresentacion;
    }

    public int getCodigotarea() {
        return codigotarea;
    }

    public void setCodigotarea(int codigotarea) {
        this.codigotarea = codigotarea;
    }

    public Asignaturas getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Asignaturas idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Carreras getClaseid() {
        return claseid;
    }

    public void setClaseid(Carreras claseid) {
        this.claseid = claseid;
    }

    public Docentes getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docentes iddocente) {
        this.iddocente = iddocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanificacion != null ? idplanificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanificacionTareas)) {
            return false;
        }
        PlanificacionTareas other = (PlanificacionTareas) object;
        if ((this.idplanificacion == null && other.idplanificacion != null) || (this.idplanificacion != null && !this.idplanificacion.equals(other.idplanificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.PlanificacionTareas[ idplanificacion=" + idplanificacion + " ]";
    }
    
}
