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
@Table(name = "cuatrimestres", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuatrimestres.findAll", query = "SELECT c FROM Cuatrimestres c"),
    @NamedQuery(name = "Cuatrimestres.findByIdcuatrimestre", query = "SELECT c FROM Cuatrimestres c WHERE c.idcuatrimestre = :idcuatrimestre"),
    @NamedQuery(name = "Cuatrimestres.findByNombrecuatrimestre", query = "SELECT c FROM Cuatrimestres c WHERE c.nombrecuatrimestre = :nombrecuatrimestre")})
public class Cuatrimestres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuatrimestre")
    private Integer idcuatrimestre;
    @Basic(optional = false)
    @Column(name = "nombrecuatrimestre")
    private String nombrecuatrimestre;

    public Cuatrimestres() {
    }

    public Cuatrimestres(Integer idcuatrimestre) {
        this.idcuatrimestre = idcuatrimestre;
    }

    public Cuatrimestres(Integer idcuatrimestre, String nombrecuatrimestre) {
        this.idcuatrimestre = idcuatrimestre;
        this.nombrecuatrimestre = nombrecuatrimestre;
    }

    public Integer getIdcuatrimestre() {
        return idcuatrimestre;
    }

    public void setIdcuatrimestre(Integer idcuatrimestre) {
        this.idcuatrimestre = idcuatrimestre;
    }

    public String getNombrecuatrimestre() {
        return nombrecuatrimestre;
    }

    public void setNombrecuatrimestre(String nombrecuatrimestre) {
        this.nombrecuatrimestre = nombrecuatrimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuatrimestre != null ? idcuatrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuatrimestres)) {
            return false;
        }
        Cuatrimestres other = (Cuatrimestres) object;
        if ((this.idcuatrimestre == null && other.idcuatrimestre != null) || (this.idcuatrimestre != null && !this.idcuatrimestre.equals(other.idcuatrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Cuatrimestres[ idcuatrimestre=" + idcuatrimestre + " ]";
    }
    
}
