/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "grupos", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findByIdgrupo", query = "SELECT g FROM Grupos g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "Grupos.findByNumerogrupo", query = "SELECT g FROM Grupos g WHERE g.numerogrupo = :numerogrupo"),
    @NamedQuery(name = "Grupos.findByNombregrupo", query = "SELECT g FROM Grupos g WHERE g.nombregrupo = :nombregrupo")})
public class Grupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupo")
    private Integer idgrupo;
    @Basic(optional = false)
    @Column(name = "numerogrupo")
    private String numerogrupo;
    @Basic(optional = false)
    @Column(name = "nombregrupo")
    private String nombregrupo;

    public Grupos() {
    }

    public Grupos(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Grupos(Integer idgrupo, String numerogrupo, String nombregrupo) {
        this.idgrupo = idgrupo;
        this.numerogrupo = numerogrupo;
        this.nombregrupo = nombregrupo;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNumerogrupo() {
        return numerogrupo;
    }

    public void setNumerogrupo(String numerogrupo) {
        this.numerogrupo = numerogrupo;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupo != null ? idgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Grupos[ idgrupo=" + idgrupo + " ]";
    }
    
}
