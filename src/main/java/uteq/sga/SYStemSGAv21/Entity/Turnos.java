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
@Table(name = "turnos", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t"),
    @NamedQuery(name = "Turnos.findByIdturno", query = "SELECT t FROM Turnos t WHERE t.idturno = :idturno"),
    @NamedQuery(name = "Turnos.findByNombreturno", query = "SELECT t FROM Turnos t WHERE t.nombreturno = :nombreturno")})
public class Turnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturno")
    private Integer idturno;
    @Basic(optional = false)
    @Column(name = "nombreturno")
    private String nombreturno;

    public Turnos() {
    }

    public Turnos(Integer idturno) {
        this.idturno = idturno;
    }

    public Turnos(Integer idturno, String nombreturno) {
        this.idturno = idturno;
        this.nombreturno = nombreturno;
    }

    public Integer getIdturno() {
        return idturno;
    }

    public void setIdturno(Integer idturno) {
        this.idturno = idturno;
    }

    public String getNombreturno() {
        return nombreturno;
    }

    public void setNombreturno(String nombreturno) {
        this.nombreturno = nombreturno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturno != null ? idturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.idturno == null && other.idturno != null) || (this.idturno != null && !this.idturno.equals(other.idturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Turnos[ idturno=" + idturno + " ]";
    }
    
}
