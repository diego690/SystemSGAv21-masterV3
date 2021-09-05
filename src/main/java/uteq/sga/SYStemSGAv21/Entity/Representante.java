/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "representante", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findByRepresentanteid", query = "SELECT r FROM Representante r WHERE r.representanteid = :representanteid"),
    @NamedQuery(name = "Representante.findByNombres", query = "SELECT r FROM Representante r WHERE r.nombres = :nombres"),
    @NamedQuery(name = "Representante.findByApellidos", query = "SELECT r FROM Representante r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "Representante.findByCedula", query = "SELECT r FROM Representante r WHERE r.cedula = :cedula"),
    @NamedQuery(name = "Representante.findByDireccion", query = "SELECT r FROM Representante r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "Representante.findByCorreo", query = "SELECT r FROM Representante r WHERE r.correo = :correo"),
    @NamedQuery(name = "Representante.findBySexo", query = "SELECT r FROM Representante r WHERE r.sexo = :sexo"),
    @NamedQuery(name = "Representante.findByTelefono", query = "SELECT r FROM Representante r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "Representante.findByParentesco", query = "SELECT r FROM Representante r WHERE r.parentesco = :parentesco"),
    @NamedQuery(name = "Representante.findByEstado", query = "SELECT r FROM Representante r WHERE r.estado = :estado"),
    @NamedQuery(name = "Representante.findByMovil", query = "SELECT r FROM Representante r WHERE r.movil = :movil")})
public class Representante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "representanteid")
    private Integer representanteid;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "parentesco")
    private String parentesco;
    @Column(name = "estado")
    private String estado;
    @Column(name = "movil")
    private String movil;
    @OneToMany(mappedBy = "representanteid")
    private Collection<Estudiantes> estudiantesCollection;

    public Representante() {
    }

    public Representante(Integer representanteid) {
        this.representanteid = representanteid;
    }

    public Integer getRepresentanteid() {
        return representanteid;
    }

    public void setRepresentanteid(Integer representanteid) {
        this.representanteid = representanteid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    @XmlTransient
    public Collection<Estudiantes> getEstudiantesCollection() {
        return estudiantesCollection;
    }

    public void setEstudiantesCollection(Collection<Estudiantes> estudiantesCollection) {
        this.estudiantesCollection = estudiantesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (representanteid != null ? representanteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.representanteid == null && other.representanteid != null) || (this.representanteid != null && !this.representanteid.equals(other.representanteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Representante[ representanteid=" + representanteid + " ]";
    }
    
}
