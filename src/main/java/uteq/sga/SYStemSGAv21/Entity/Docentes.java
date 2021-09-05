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
@Table(name = "docentes", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findByIddocente", query = "SELECT d FROM Docentes d WHERE d.iddocente = :iddocente"),
    @NamedQuery(name = "Docentes.findByNombresdocente", query = "SELECT d FROM Docentes d WHERE d.nombresdocente = :nombresdocente"),
    @NamedQuery(name = "Docentes.findByApellidosdocente", query = "SELECT d FROM Docentes d WHERE d.apellidosdocente = :apellidosdocente"),
    @NamedQuery(name = "Docentes.findByCeduladocente", query = "SELECT d FROM Docentes d WHERE d.ceduladocente = :ceduladocente"),
    @NamedQuery(name = "Docentes.findByCorreodocente", query = "SELECT d FROM Docentes d WHERE d.correodocente = :correodocente"),
    @NamedQuery(name = "Docentes.findByCelulardocente", query = "SELECT d FROM Docentes d WHERE d.celulardocente = :celulardocente"),
    @NamedQuery(name = "Docentes.findByTelefonodocente", query = "SELECT d FROM Docentes d WHERE d.telefonodocente = :telefonodocente"),
    @NamedQuery(name = "Docentes.findByDirecciondocente", query = "SELECT d FROM Docentes d WHERE d.direcciondocente = :direcciondocente"),
    @NamedQuery(name = "Docentes.findByEstado", query = "SELECT d FROM Docentes d WHERE d.estado = :estado"),
    @NamedQuery(name = "Docentes.findByFoto", query = "SELECT d FROM Docentes d WHERE d.foto = :foto")})
public class Docentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocente")
    private Integer iddocente;
    @Basic(optional = false)
    @Column(name = "nombresdocente")
    private String nombresdocente;
    @Basic(optional = false)
    @Column(name = "apellidosdocente")
    private String apellidosdocente;
    @Basic(optional = false)
    @Column(name = "ceduladocente")
    private String ceduladocente;
    @Basic(optional = false)
    @Column(name = "correodocente")
    private String correodocente;
    @Basic(optional = false)
    @Column(name = "celulardocente")
    private String celulardocente;
    @Basic(optional = false)
    @Column(name = "telefonodocente")
    private String telefonodocente;
    @Basic(optional = false)
    @Column(name = "direcciondocente")
    private String direcciondocente;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private Collection<MaterialDidactico> materialDidacticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private Collection<NumerosAsignaciones> numerosAsignacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private Collection<Evaluaciones> evaluacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private Collection<Asignaciones> asignacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private Collection<Horarioclase> horarioclaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private Collection<PlanificacionTareas> planificacionTareasCollection;

    public Docentes() {
    }

    public Docentes(Integer iddocente) {
        this.iddocente = iddocente;
    }

    public Docentes(Integer iddocente, String nombresdocente, String apellidosdocente, String ceduladocente, String correodocente, String celulardocente, String telefonodocente, String direcciondocente, int estado) {
        this.iddocente = iddocente;
        this.nombresdocente = nombresdocente;
        this.apellidosdocente = apellidosdocente;
        this.ceduladocente = ceduladocente;
        this.correodocente = correodocente;
        this.celulardocente = celulardocente;
        this.telefonodocente = telefonodocente;
        this.direcciondocente = direcciondocente;
        this.estado = estado;
    }

    public Integer getIddocente() {
        return iddocente;
    }

    public void setIddocente(Integer iddocente) {
        this.iddocente = iddocente;
    }

    public String getNombresdocente() {
        return nombresdocente;
    }

    public void setNombresdocente(String nombresdocente) {
        this.nombresdocente = nombresdocente;
    }

    public String getApellidosdocente() {
        return apellidosdocente;
    }

    public void setApellidosdocente(String apellidosdocente) {
        this.apellidosdocente = apellidosdocente;
    }

    public String getCeduladocente() {
        return ceduladocente;
    }

    public void setCeduladocente(String ceduladocente) {
        this.ceduladocente = ceduladocente;
    }

    public String getCorreodocente() {
        return correodocente;
    }

    public void setCorreodocente(String correodocente) {
        this.correodocente = correodocente;
    }

    public String getCelulardocente() {
        return celulardocente;
    }

    public void setCelulardocente(String celulardocente) {
        this.celulardocente = celulardocente;
    }

    public String getTelefonodocente() {
        return telefonodocente;
    }

    public void setTelefonodocente(String telefonodocente) {
        this.telefonodocente = telefonodocente;
    }

    public String getDirecciondocente() {
        return direcciondocente;
    }

    public void setDirecciondocente(String direcciondocente) {
        this.direcciondocente = direcciondocente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<MaterialDidactico> getMaterialDidacticoCollection() {
        return materialDidacticoCollection;
    }

    public void setMaterialDidacticoCollection(Collection<MaterialDidactico> materialDidacticoCollection) {
        this.materialDidacticoCollection = materialDidacticoCollection;
    }

    @XmlTransient
    public Collection<NumerosAsignaciones> getNumerosAsignacionesCollection() {
        return numerosAsignacionesCollection;
    }

    public void setNumerosAsignacionesCollection(Collection<NumerosAsignaciones> numerosAsignacionesCollection) {
        this.numerosAsignacionesCollection = numerosAsignacionesCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocente != null ? iddocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.iddocente == null && other.iddocente != null) || (this.iddocente != null && !this.iddocente.equals(other.iddocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Docentes[ iddocente=" + iddocente + " ]";
    }
    
}
