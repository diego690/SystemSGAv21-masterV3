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
@Table(name = "inscripciones_asignaturas", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscripcionesAsignaturas.findAll", query = "SELECT i FROM InscripcionesAsignaturas i"),
    @NamedQuery(name = "InscripcionesAsignaturas.findByIdinscripcion", query = "SELECT i FROM InscripcionesAsignaturas i WHERE i.idinscripcion = :idinscripcion"),
    @NamedQuery(name = "InscripcionesAsignaturas.findByFechainscripcion", query = "SELECT i FROM InscripcionesAsignaturas i WHERE i.fechainscripcion = :fechainscripcion"),
    @NamedQuery(name = "InscripcionesAsignaturas.findByObservaciones", query = "SELECT i FROM InscripcionesAsignaturas i WHERE i.observaciones = :observaciones")})
public class InscripcionesAsignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinscripcion")
    private Integer idinscripcion;
    @Basic(optional = false)
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechainscripcion;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false)
    private Asignaturas idasignatura;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiantes idestudiante;

    public InscripcionesAsignaturas() {
    }

    public InscripcionesAsignaturas(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public InscripcionesAsignaturas(Integer idinscripcion, Date fechainscripcion) {
        this.idinscripcion = idinscripcion;
        this.fechainscripcion = fechainscripcion;
    }

    public Integer getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Asignaturas getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Asignaturas idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Estudiantes getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiantes idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinscripcion != null ? idinscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionesAsignaturas)) {
            return false;
        }
        InscripcionesAsignaturas other = (InscripcionesAsignaturas) object;
        if ((this.idinscripcion == null && other.idinscripcion != null) || (this.idinscripcion != null && !this.idinscripcion.equals(other.idinscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.InscripcionesAsignaturas[ idinscripcion=" + idinscripcion + " ]";
    }
    
}
