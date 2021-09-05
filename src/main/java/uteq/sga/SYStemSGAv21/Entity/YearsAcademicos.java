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
@Table(name = "years_academicos", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YearsAcademicos.findAll", query = "SELECT y FROM YearsAcademicos y"),
    @NamedQuery(name = "YearsAcademicos.findByIdyearacademico", query = "SELECT y FROM YearsAcademicos y WHERE y.idyearacademico = :idyearacademico"),
    @NamedQuery(name = "YearsAcademicos.findByNombreyear", query = "SELECT y FROM YearsAcademicos y WHERE y.nombreyear = :nombreyear"),
    @NamedQuery(name = "YearsAcademicos.findByFechainicio", query = "SELECT y FROM YearsAcademicos y WHERE y.fechainicio = :fechainicio"),
    @NamedQuery(name = "YearsAcademicos.findByFechafin", query = "SELECT y FROM YearsAcademicos y WHERE y.fechafin = :fechafin")})
public class YearsAcademicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idyearacademico")
    private Integer idyearacademico;
    @Basic(optional = false)
    @Column(name = "nombreyear")
    private String nombreyear;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechafin;
    @OneToMany(mappedBy = "idyearacademico")
    private Collection<Secciones> seccionesCollection;
    @OneToMany(mappedBy = "aniolectivo")
    private Collection<Matriculacion> matriculacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idyear")
    private Collection<Asignaturas> asignaturasCollection;

    public YearsAcademicos() {
    }

    public YearsAcademicos(Integer idyearacademico) {
        this.idyearacademico = idyearacademico;
    }

    public YearsAcademicos(Integer idyearacademico, String nombreyear) {
        this.idyearacademico = idyearacademico;
        this.nombreyear = nombreyear;
    }

    public Integer getIdyearacademico() {
        return idyearacademico;
    }

    public void setIdyearacademico(Integer idyearacademico) {
        this.idyearacademico = idyearacademico;
    }

    public String getNombreyear() {
        return nombreyear;
    }

    public void setNombreyear(String nombreyear) {
        this.nombreyear = nombreyear;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public Collection<Secciones> getSeccionesCollection() {
        return seccionesCollection;
    }

    public void setSeccionesCollection(Collection<Secciones> seccionesCollection) {
        this.seccionesCollection = seccionesCollection;
    }

    @XmlTransient
    public Collection<Matriculacion> getMatriculacionCollection() {
        return matriculacionCollection;
    }

    public void setMatriculacionCollection(Collection<Matriculacion> matriculacionCollection) {
        this.matriculacionCollection = matriculacionCollection;
    }

    @XmlTransient
    public Collection<Asignaturas> getAsignaturasCollection() {
        return asignaturasCollection;
    }

    public void setAsignaturasCollection(Collection<Asignaturas> asignaturasCollection) {
        this.asignaturasCollection = asignaturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idyearacademico != null ? idyearacademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YearsAcademicos)) {
            return false;
        }
        YearsAcademicos other = (YearsAcademicos) object;
        if ((this.idyearacademico == null && other.idyearacademico != null) || (this.idyearacademico != null && !this.idyearacademico.equals(other.idyearacademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.YearsAcademicos[ idyearacademico=" + idyearacademico + " ]";
    }
    
}
