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
@Table(name = "numeros_asignaciones", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumerosAsignaciones.findAll", query = "SELECT n FROM NumerosAsignaciones n"),
    @NamedQuery(name = "NumerosAsignaciones.findByIdnumeroasignacion", query = "SELECT n FROM NumerosAsignaciones n WHERE n.idnumeroasignacion = :idnumeroasignacion"),
    @NamedQuery(name = "NumerosAsignaciones.findByNumeroasignado", query = "SELECT n FROM NumerosAsignaciones n WHERE n.numeroasignado = :numeroasignado")})
public class NumerosAsignaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnumeroasignacion")
    private Integer idnumeroasignacion;
    @Basic(optional = false)
    @Column(name = "numeroasignado")
    private int numeroasignado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnumeroasignacion")
    private Collection<MaterialDidactico> materialDidacticoCollection;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docentes iddocente;

    public NumerosAsignaciones() {
    }

    public NumerosAsignaciones(Integer idnumeroasignacion) {
        this.idnumeroasignacion = idnumeroasignacion;
    }

    public NumerosAsignaciones(Integer idnumeroasignacion, int numeroasignado) {
        this.idnumeroasignacion = idnumeroasignacion;
        this.numeroasignado = numeroasignado;
    }

    public Integer getIdnumeroasignacion() {
        return idnumeroasignacion;
    }

    public void setIdnumeroasignacion(Integer idnumeroasignacion) {
        this.idnumeroasignacion = idnumeroasignacion;
    }

    public int getNumeroasignado() {
        return numeroasignado;
    }

    public void setNumeroasignado(int numeroasignado) {
        this.numeroasignado = numeroasignado;
    }

    @XmlTransient
    public Collection<MaterialDidactico> getMaterialDidacticoCollection() {
        return materialDidacticoCollection;
    }

    public void setMaterialDidacticoCollection(Collection<MaterialDidactico> materialDidacticoCollection) {
        this.materialDidacticoCollection = materialDidacticoCollection;
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
        hash += (idnumeroasignacion != null ? idnumeroasignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumerosAsignaciones)) {
            return false;
        }
        NumerosAsignaciones other = (NumerosAsignaciones) object;
        if ((this.idnumeroasignacion == null && other.idnumeroasignacion != null) || (this.idnumeroasignacion != null && !this.idnumeroasignacion.equals(other.idnumeroasignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.NumerosAsignaciones[ idnumeroasignacion=" + idnumeroasignacion + " ]";
    }
    
}
