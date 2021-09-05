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
import javax.persistence.OneToOne;
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
@Table(name = "matriculacion", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculacion.findAll", query = "SELECT m FROM Matriculacion m"),
    @NamedQuery(name = "Matriculacion.findByIdmatriculacion", query = "SELECT m FROM Matriculacion m WHERE m.idmatriculacion = :idmatriculacion"),
    @NamedQuery(name = "Matriculacion.findByEstadomatricula", query = "SELECT m FROM Matriculacion m WHERE m.estadomatricula = :estadomatricula"),
    @NamedQuery(name = "Matriculacion.findByDocumentosrevisados", query = "SELECT m FROM Matriculacion m WHERE m.documentosrevisados = :documentosrevisados"),
    @NamedQuery(name = "Matriculacion.findByFechainscripcion", query = "SELECT m FROM Matriculacion m WHERE m.fechainscripcion = :fechainscripcion"),
    @NamedQuery(name = "Matriculacion.findByFechamatricula", query = "SELECT m FROM Matriculacion m WHERE m.fechamatricula = :fechamatricula")})
public class Matriculacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatriculacion")
    private Integer idmatriculacion;
    @Column(name = "estadomatricula")
    private String estadomatricula;
    @Column(name = "documentosrevisados")
    private String documentosrevisados;
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechainscripcion;
    @Column(name = "fechamatricula")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechamatricula;
    @JoinColumn(name = "aula", referencedColumnName = "aulaid")
    @ManyToOne
    private Aula aula;
    @JoinColumn(name = "curso", referencedColumnName = "idcarrera")
    @ManyToOne(optional = false)
    private Carreras curso;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @OneToOne(optional = false)
    private Estudiantes idestudiante;
    @JoinColumn(name = "aniolectivo", referencedColumnName = "idyearacademico")
    @ManyToOne
    private YearsAcademicos aniolectivo;

    public Matriculacion() {
    }

    public Matriculacion(Integer idmatriculacion) {
        this.idmatriculacion = idmatriculacion;
    }

    public Integer getIdmatriculacion() {
        return idmatriculacion;
    }

    public void setIdmatriculacion(Integer idmatriculacion) {
        this.idmatriculacion = idmatriculacion;
    }

    public String getEstadomatricula() {
        return estadomatricula;
    }

    public void setEstadomatricula(String estadomatricula) {
        this.estadomatricula = estadomatricula;
    }

    public String getDocumentosrevisados() {
        return documentosrevisados;
    }

    public void setDocumentosrevisados(String documentosrevisados) {
        this.documentosrevisados = documentosrevisados;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public Date getFechamatricula() {
        return fechamatricula;
    }

    public void setFechamatricula(Date fechamatricula) {
        this.fechamatricula = fechamatricula;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Carreras getCurso() {
        return curso;
    }

    public void setCurso(Carreras curso) {
        this.curso = curso;
    }

    public Estudiantes getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiantes idestudiante) {
        this.idestudiante = idestudiante;
    }

    public YearsAcademicos getAniolectivo() {
        return aniolectivo;
    }

    public void setAniolectivo(YearsAcademicos aniolectivo) {
        this.aniolectivo = aniolectivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatriculacion != null ? idmatriculacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculacion)) {
            return false;
        }
        Matriculacion other = (Matriculacion) object;
        if ((this.idmatriculacion == null && other.idmatriculacion != null) || (this.idmatriculacion != null && !this.idmatriculacion.equals(other.idmatriculacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Matriculacion[ idmatriculacion=" + idmatriculacion + " ]";
    }
    
}
