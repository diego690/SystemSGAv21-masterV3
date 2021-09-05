/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "entrega_tareas", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntregaTareas.findAll", query = "SELECT e FROM EntregaTareas e"),
    @NamedQuery(name = "EntregaTareas.findByIdentregatareas", query = "SELECT e FROM EntregaTareas e WHERE e.identregatareas = :identregatareas"),
    @NamedQuery(name = "EntregaTareas.findByCodigotareadocente", query = "SELECT e FROM EntregaTareas e WHERE e.codigotareadocente = :codigotareadocente"),
    @NamedQuery(name = "EntregaTareas.findByDescripcion", query = "SELECT e FROM EntregaTareas e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EntregaTareas.findByCodigoenviotarea", query = "SELECT e FROM EntregaTareas e WHERE e.codigoenviotarea = :codigoenviotarea"),
    @NamedQuery(name = "EntregaTareas.findByArchivo", query = "SELECT e FROM EntregaTareas e WHERE e.archivo = :archivo"),
    @NamedQuery(name = "EntregaTareas.findByFechaentrega", query = "SELECT e FROM EntregaTareas e WHERE e.fechaentrega = :fechaentrega")})
public class EntregaTareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identregatareas")
    private Integer identregatareas;
    @Basic(optional = false)
    @Column(name = "codigotareadocente")
    private int codigotareadocente;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "codigoenviotarea")
    private int codigoenviotarea;
    @Basic(optional = false)
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "fechaentrega")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaentrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identregatareas")
    private Collection<Notastareas> notastareasCollection;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false)
    private Asignaturas idasignatura;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiantes idestudiante;

    public EntregaTareas() {
    }

    public EntregaTareas(Integer identregatareas) {
        this.identregatareas = identregatareas;
    }

    public EntregaTareas(Integer identregatareas, int codigotareadocente, String descripcion, int codigoenviotarea, String archivo) {
        this.identregatareas = identregatareas;
        this.codigotareadocente = codigotareadocente;
        this.descripcion = descripcion;
        this.codigoenviotarea = codigoenviotarea;
        this.archivo = archivo;
    }

    public Integer getIdentregatareas() {
        return identregatareas;
    }

    public void setIdentregatareas(Integer identregatareas) {
        this.identregatareas = identregatareas;
    }

    public int getCodigotareadocente() {
        return codigotareadocente;
    }

    public void setCodigotareadocente(int codigotareadocente) {
        this.codigotareadocente = codigotareadocente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoenviotarea() {
        return codigoenviotarea;
    }

    public void setCodigoenviotarea(int codigoenviotarea) {
        this.codigoenviotarea = codigoenviotarea;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    @XmlTransient
    public Collection<Notastareas> getNotastareasCollection() {
        return notastareasCollection;
    }

    public void setNotastareasCollection(Collection<Notastareas> notastareasCollection) {
        this.notastareasCollection = notastareasCollection;
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
        hash += (identregatareas != null ? identregatareas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntregaTareas)) {
            return false;
        }
        EntregaTareas other = (EntregaTareas) object;
        if ((this.identregatareas == null && other.identregatareas != null) || (this.identregatareas != null && !this.identregatareas.equals(other.identregatareas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.EntregaTareas[ identregatareas=" + identregatareas + " ]";
    }
    
}
