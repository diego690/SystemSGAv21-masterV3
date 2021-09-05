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
@Table(name = "material_didactico", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialDidactico.findAll", query = "SELECT m FROM MaterialDidactico m"),
    @NamedQuery(name = "MaterialDidactico.findByIdmaterialdidactico", query = "SELECT m FROM MaterialDidactico m WHERE m.idmaterialdidactico = :idmaterialdidactico"),
    @NamedQuery(name = "MaterialDidactico.findByDescripcion", query = "SELECT m FROM MaterialDidactico m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MaterialDidactico.findByArchivo", query = "SELECT m FROM MaterialDidactico m WHERE m.archivo = :archivo"),
    @NamedQuery(name = "MaterialDidactico.findByCodigomaterial", query = "SELECT m FROM MaterialDidactico m WHERE m.codigomaterial = :codigomaterial"),
    @NamedQuery(name = "MaterialDidactico.findByFechasubida", query = "SELECT m FROM MaterialDidactico m WHERE m.fechasubida = :fechasubida")})
public class MaterialDidactico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmaterialdidactico")
    private Integer idmaterialdidactico;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "archivo")
    private String archivo;
    @Basic(optional = false)
    @Column(name = "codigomaterial")
    private int codigomaterial;
    @Column(name = "fechasubida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechasubida;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docentes iddocente;
    @JoinColumn(name = "idnumeroasignacion", referencedColumnName = "idnumeroasignacion")
    @ManyToOne(optional = false)
    private NumerosAsignaciones idnumeroasignacion;

    public MaterialDidactico() {
    }

    public MaterialDidactico(Integer idmaterialdidactico) {
        this.idmaterialdidactico = idmaterialdidactico;
    }

    public MaterialDidactico(Integer idmaterialdidactico, String descripcion, String archivo, int codigomaterial) {
        this.idmaterialdidactico = idmaterialdidactico;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.codigomaterial = codigomaterial;
    }

    public Integer getIdmaterialdidactico() {
        return idmaterialdidactico;
    }

    public void setIdmaterialdidactico(Integer idmaterialdidactico) {
        this.idmaterialdidactico = idmaterialdidactico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getCodigomaterial() {
        return codigomaterial;
    }

    public void setCodigomaterial(int codigomaterial) {
        this.codigomaterial = codigomaterial;
    }

    public Date getFechasubida() {
        return fechasubida;
    }

    public void setFechasubida(Date fechasubida) {
        this.fechasubida = fechasubida;
    }

    public Docentes getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docentes iddocente) {
        this.iddocente = iddocente;
    }

    public NumerosAsignaciones getIdnumeroasignacion() {
        return idnumeroasignacion;
    }

    public void setIdnumeroasignacion(NumerosAsignaciones idnumeroasignacion) {
        this.idnumeroasignacion = idnumeroasignacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterialdidactico != null ? idmaterialdidactico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialDidactico)) {
            return false;
        }
        MaterialDidactico other = (MaterialDidactico) object;
        if ((this.idmaterialdidactico == null && other.idmaterialdidactico != null) || (this.idmaterialdidactico != null && !this.idmaterialdidactico.equals(other.idmaterialdidactico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.MaterialDidactico[ idmaterialdidactico=" + idmaterialdidactico + " ]";
    }
    
}
