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
@Table(name = "tipodocumento", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t"),
    @NamedQuery(name = "Tipodocumento.findByIdtipodocu", query = "SELECT t FROM Tipodocumento t WHERE t.idtipodocu = :idtipodocu"),
    @NamedQuery(name = "Tipodocumento.findByDocumento", query = "SELECT t FROM Tipodocumento t WHERE t.documento = :documento")})
public class Tipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipodocu")
    private Integer idtipodocu;
    @Column(name = "documento")
    private String documento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipodocumento")
    private Collection<Documentos> documentosCollection;

    public Tipodocumento() {
    }

    public Tipodocumento(Integer idtipodocu) {
        this.idtipodocu = idtipodocu;
    }

    public Integer getIdtipodocu() {
        return idtipodocu;
    }

    public void setIdtipodocu(Integer idtipodocu) {
        this.idtipodocu = idtipodocu;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @XmlTransient
    public Collection<Documentos> getDocumentosCollection() {
        return documentosCollection;
    }

    public void setDocumentosCollection(Collection<Documentos> documentosCollection) {
        this.documentosCollection = documentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodocu != null ? idtipodocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumento)) {
            return false;
        }
        Tipodocumento other = (Tipodocumento) object;
        if ((this.idtipodocu == null && other.idtipodocu != null) || (this.idtipodocu != null && !this.idtipodocu.equals(other.idtipodocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Tipodocumento[ idtipodocu=" + idtipodocu + " ]";
    }
    
}
