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
import javax.persistence.OneToOne;
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
@Table(name = "estudiantes", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByIdestudiante", query = "SELECT e FROM Estudiantes e WHERE e.idestudiante = :idestudiante"),
    @NamedQuery(name = "Estudiantes.findByCarnetestudiante", query = "SELECT e FROM Estudiantes e WHERE e.carnetestudiante = :carnetestudiante"),
    @NamedQuery(name = "Estudiantes.findByNombresestudiante", query = "SELECT e FROM Estudiantes e WHERE e.nombresestudiante = :nombresestudiante"),
    @NamedQuery(name = "Estudiantes.findByApellidosestudiante", query = "SELECT e FROM Estudiantes e WHERE e.apellidosestudiante = :apellidosestudiante"),
    @NamedQuery(name = "Estudiantes.findByCedulaestudiante", query = "SELECT e FROM Estudiantes e WHERE e.cedulaestudiante = :cedulaestudiante"),
    @NamedQuery(name = "Estudiantes.findByCorreoestudiante", query = "SELECT e FROM Estudiantes e WHERE e.correoestudiante = :correoestudiante"),
    @NamedQuery(name = "Estudiantes.findByCelularestudiante", query = "SELECT e FROM Estudiantes e WHERE e.celularestudiante = :celularestudiante"),
    @NamedQuery(name = "Estudiantes.findByTelefonoestudiante", query = "SELECT e FROM Estudiantes e WHERE e.telefonoestudiante = :telefonoestudiante"),
    @NamedQuery(name = "Estudiantes.findByDireccionestudiante", query = "SELECT e FROM Estudiantes e WHERE e.direccionestudiante = :direccionestudiante"),
    @NamedQuery(name = "Estudiantes.findByEstado", query = "SELECT e FROM Estudiantes e WHERE e.estado = :estado"),
    @NamedQuery(name = "Estudiantes.findByFoto", query = "SELECT e FROM Estudiantes e WHERE e.foto = :foto"),
    @NamedQuery(name = "Estudiantes.findByFnacimiento", query = "SELECT e FROM Estudiantes e WHERE e.fnacimiento = :fnacimiento"),
    @NamedQuery(name = "Estudiantes.findBySexo", query = "SELECT e FROM Estudiantes e WHERE e.sexo = :sexo")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestudiante")
    private Integer idestudiante;
    @Basic(optional = false)
    @Column(name = "carnetestudiante")
    private String carnetestudiante;
    @Basic(optional = false)
    @Column(name = "nombresestudiante")
    private String nombresestudiante;
    @Basic(optional = false)
    @Column(name = "apellidosestudiante")
    private String apellidosestudiante;
    @Basic(optional = false)
    @Column(name = "cedulaestudiante")
    private String cedulaestudiante;
    @Basic(optional = false)
    @Column(name = "correoestudiante")
    private String correoestudiante;
    @Basic(optional = false)
    @Column(name = "celularestudiante")
    private String celularestudiante;
    @Column(name = "telefonoestudiante")
    private String telefonoestudiante;
    @Basic(optional = false)
    @Column(name = "direccionestudiante")
    private String direccionestudiante;
    @Column(name = "estado")
    private String estado;
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @Column(name = "fnacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fnacimiento;
    @Column(name = "sexo")
    private String sexo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private Matriculacion matriculacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private Collection<InscripcionesAsignaturas> inscripcionesAsignaturasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private Collection<EntregaTareas> entregaTareasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private Collection<Evaluaciones> evaluacionesCollection;
    @JoinColumn(name = "representanteid", referencedColumnName = "representanteid")
    @ManyToOne
    private Representante representanteid;
    @OneToMany(mappedBy = "idestudiante")
    private Collection<Pagos> pagosCollection;

    public Estudiantes() {
    }

    public Estudiantes(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Estudiantes(Integer idestudiante, String carnetestudiante, String nombresestudiante, String apellidosestudiante, String cedulaestudiante, String correoestudiante, String celularestudiante, String direccionestudiante, Date fnacimiento) {
        this.idestudiante = idestudiante;
        this.carnetestudiante = carnetestudiante;
        this.nombresestudiante = nombresestudiante;
        this.apellidosestudiante = apellidosestudiante;
        this.cedulaestudiante = cedulaestudiante;
        this.correoestudiante = correoestudiante;
        this.celularestudiante = celularestudiante;
        this.direccionestudiante = direccionestudiante;
        this.fnacimiento = fnacimiento;
    }

    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getCarnetestudiante() {
        return carnetestudiante;
    }

    public void setCarnetestudiante(String carnetestudiante) {
        this.carnetestudiante = carnetestudiante;
    }

    public String getNombresestudiante() {
        return nombresestudiante;
    }

    public void setNombresestudiante(String nombresestudiante) {
        this.nombresestudiante = nombresestudiante;
    }

    public String getApellidosestudiante() {
        return apellidosestudiante;
    }

    public void setApellidosestudiante(String apellidosestudiante) {
        this.apellidosestudiante = apellidosestudiante;
    }

    public String getCedulaestudiante() {
        return cedulaestudiante;
    }

    public void setCedulaestudiante(String cedulaestudiante) {
        this.cedulaestudiante = cedulaestudiante;
    }

    public String getCorreoestudiante() {
        return correoestudiante;
    }

    public void setCorreoestudiante(String correoestudiante) {
        this.correoestudiante = correoestudiante;
    }

    public String getCelularestudiante() {
        return celularestudiante;
    }

    public void setCelularestudiante(String celularestudiante) {
        this.celularestudiante = celularestudiante;
    }

    public String getTelefonoestudiante() {
        return telefonoestudiante;
    }

    public void setTelefonoestudiante(String telefonoestudiante) {
        this.telefonoestudiante = telefonoestudiante;
    }

    public String getDireccionestudiante() {
        return direccionestudiante;
    }

    public void setDireccionestudiante(String direccionestudiante) {
        this.direccionestudiante = direccionestudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Matriculacion getMatriculacion() {
        return matriculacion;
    }

    public void setMatriculacion(Matriculacion matriculacion) {
        this.matriculacion = matriculacion;
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

    public Representante getRepresentanteid() {
        return representanteid;
    }

    public void setRepresentanteid(Representante representanteid) {
        this.representanteid = representanteid;
    }

    @XmlTransient
    public Collection<Pagos> getPagosCollection() {
        return pagosCollection;
    }

    public void setPagosCollection(Collection<Pagos> pagosCollection) {
        this.pagosCollection = pagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiante != null ? idestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Estudiantes[ idestudiante=" + idestudiante + " ]";
    }
    
}
