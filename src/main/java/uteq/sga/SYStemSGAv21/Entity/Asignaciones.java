/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "asignaciones", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaciones.findAll", query = "SELECT a FROM Asignaciones a"),
    @NamedQuery(name = "Asignaciones.findByIdasignacion", query = "SELECT a FROM Asignaciones a WHERE a.idasignacion = :idasignacion"),
    @NamedQuery(name = "Asignaciones.findByDescripcion", query = "SELECT a FROM Asignaciones a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Asignaciones.findByEstado", query = "SELECT a FROM Asignaciones a WHERE a.estado = :estado")})
public class Asignaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignacion")
    private Integer idasignacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false)
    private Asignaturas idasignatura;
    @JoinColumn(name = "aulaid", referencedColumnName = "aulaid")
    @ManyToOne(optional = false)
    private Aula aulaid;
    @JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
    @ManyToOne(optional = false)
    private Carreras idcarrera;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docentes iddocente;
    @JoinColumn(name = "seccionid", referencedColumnName = "seccionid")
    @ManyToOne(optional = false)
    private Secciones seccionid;

    public Asignaciones() {
    }

    public Asignaciones(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Asignaciones(Integer idasignacion, String descripcion, int estado) {
        this.idasignacion = idasignacion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Asignaturas getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Asignaturas idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Aula getAulaid() {
        return aulaid;
    }

    public void setAulaid(Aula aulaid) {
        this.aulaid = aulaid;
    }

    public Carreras getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Carreras idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Docentes getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docentes iddocente) {
        this.iddocente = iddocente;
    }

    public Secciones getSeccionid() {
        return seccionid;
    }

    public void setSeccionid(Secciones seccionid) {
        this.seccionid = seccionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignacion != null ? idasignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaciones)) {
            return false;
        }
        Asignaciones other = (Asignaciones) object;
        if ((this.idasignacion == null && other.idasignacion != null) || (this.idasignacion != null && !this.idasignacion.equals(other.idasignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Asignaciones[ idasignacion=" + idasignacion + " ]";
    }
    
}
