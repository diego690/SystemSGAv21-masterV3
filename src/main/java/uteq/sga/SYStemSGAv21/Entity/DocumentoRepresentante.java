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
@Table(name = "documento_representante", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoRepresentante.findAll", query = "SELECT d FROM DocumentoRepresentante d"),
    @NamedQuery(name = "DocumentoRepresentante.findByDocumentoid", query = "SELECT d FROM DocumentoRepresentante d WHERE d.documentoid = :documentoid"),
    @NamedQuery(name = "DocumentoRepresentante.findByDescripciondocumento", query = "SELECT d FROM DocumentoRepresentante d WHERE d.descripciondocumento = :descripciondocumento"),
    @NamedQuery(name = "DocumentoRepresentante.findByDocumento", query = "SELECT d FROM DocumentoRepresentante d WHERE d.documento = :documento"),
    @NamedQuery(name = "DocumentoRepresentante.findByRepresentanteid", query = "SELECT d FROM DocumentoRepresentante d WHERE d.representanteid = :representanteid"),
    @NamedQuery(name = "DocumentoRepresentante.findByFechasubida", query = "SELECT d FROM DocumentoRepresentante d WHERE d.fechasubida = :fechasubida")})
public class DocumentoRepresentante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "documentoid")
    private Integer documentoid;
    @Basic(optional = false)
    @Column(name = "descripciondocumento")
    private String descripciondocumento;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Column(name = "representanteid")
    private Integer representanteid;
    @Column(name = "fechasubida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechasubida;

    public DocumentoRepresentante() {
    }

    public DocumentoRepresentante(Integer documentoid) {
        this.documentoid = documentoid;
    }

    public DocumentoRepresentante(Integer documentoid, String descripciondocumento, String documento) {
        this.documentoid = documentoid;
        this.descripciondocumento = descripciondocumento;
        this.documento = documento;
    }

    public Integer getDocumentoid() {
        return documentoid;
    }

    public void setDocumentoid(Integer documentoid) {
        this.documentoid = documentoid;
    }

    public String getDescripciondocumento() {
        return descripciondocumento;
    }

    public void setDescripciondocumento(String descripciondocumento) {
        this.descripciondocumento = descripciondocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getRepresentanteid() {
        return representanteid;
    }

    public void setRepresentanteid(Integer representanteid) {
        this.representanteid = representanteid;
    }

    public Date getFechasubida() {
        return fechasubida;
    }

    public void setFechasubida(Date fechasubida) {
        this.fechasubida = fechasubida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoid != null ? documentoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoRepresentante)) {
            return false;
        }
        DocumentoRepresentante other = (DocumentoRepresentante) object;
        if ((this.documentoid == null && other.documentoid != null) || (this.documentoid != null && !this.documentoid.equals(other.documentoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.DocumentoRepresentante[ documentoid=" + documentoid + " ]";
    }
    
}
