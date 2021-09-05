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
@Table(name = "pagos", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdpagos", query = "SELECT p FROM Pagos p WHERE p.idpagos = :idpagos"),
    @NamedQuery(name = "Pagos.findByDetallepago", query = "SELECT p FROM Pagos p WHERE p.detallepago = :detallepago"),
    @NamedQuery(name = "Pagos.findByDocumentopago", query = "SELECT p FROM Pagos p WHERE p.documentopago = :documentopago"),
    @NamedQuery(name = "Pagos.findByEstado", query = "SELECT p FROM Pagos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Pagos.findByFechapago", query = "SELECT p FROM Pagos p WHERE p.fechapago = :fechapago")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpagos")
    private Integer idpagos;
    @Column(name = "detallepago")
    private String detallepago;
    @Column(name = "documentopago")
    private String documentopago;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechapago;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne
    private Estudiantes idestudiante;

    public Pagos() {
    }

    public Pagos(Integer idpagos) {
        this.idpagos = idpagos;
    }

    public Integer getIdpagos() {
        return idpagos;
    }

    public void setIdpagos(Integer idpagos) {
        this.idpagos = idpagos;
    }

    public String getDetallepago() {
        return detallepago;
    }

    public void setDetallepago(String detallepago) {
        this.detallepago = detallepago;
    }

    public String getDocumentopago() {
        return documentopago;
    }

    public void setDocumentopago(String documentopago) {
        this.documentopago = documentopago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
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
        hash += (idpagos != null ? idpagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idpagos == null && other.idpagos != null) || (this.idpagos != null && !this.idpagos.equals(other.idpagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Pagos[ idpagos=" + idpagos + " ]";
    }
    
}
