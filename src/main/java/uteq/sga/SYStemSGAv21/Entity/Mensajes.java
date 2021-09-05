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
@Table(name = "mensajes", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m"),
    @NamedQuery(name = "Mensajes.findByIdmensaje", query = "SELECT m FROM Mensajes m WHERE m.idmensaje = :idmensaje"),
    @NamedQuery(name = "Mensajes.findByRemitente", query = "SELECT m FROM Mensajes m WHERE m.remitente = :remitente"),
    @NamedQuery(name = "Mensajes.findByCorreo", query = "SELECT m FROM Mensajes m WHERE m.correo = :correo"),
    @NamedQuery(name = "Mensajes.findByMensaje", query = "SELECT m FROM Mensajes m WHERE m.mensaje = :mensaje"),
    @NamedQuery(name = "Mensajes.findByFechaenvio", query = "SELECT m FROM Mensajes m WHERE m.fechaenvio = :fechaenvio")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmensaje")
    private Integer idmensaje;
    @Basic(optional = false)
    @Column(name = "remitente")
    private String remitente;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "fechaenvio")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaenvio;

    public Mensajes() {
    }

    public Mensajes(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Mensajes(Integer idmensaje, String remitente, String correo, String mensaje, Date fechaenvio) {
        this.idmensaje = idmensaje;
        this.remitente = remitente;
        this.correo = correo;
        this.mensaje = mensaje;
        this.fechaenvio = fechaenvio;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensaje != null ? idmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.idmensaje == null && other.idmensaje != null) || (this.idmensaje != null && !this.idmensaje.equals(other.idmensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Mensajes[ idmensaje=" + idmensaje + " ]";
    }
    
}
