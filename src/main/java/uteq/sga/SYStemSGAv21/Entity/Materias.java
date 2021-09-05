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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "materias", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m"),
    @NamedQuery(name = "Materias.findByMateriaid", query = "SELECT m FROM Materias m WHERE m.materiaid = :materiaid"),
    @NamedQuery(name = "Materias.findByNombremateria", query = "SELECT m FROM Materias m WHERE m.nombremateria = :nombremateria"),
    @NamedQuery(name = "Materias.findByHorasclase", query = "SELECT m FROM Materias m WHERE m.horasclase = :horasclase")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "materiaid")
    private Integer materiaid;
    @Column(name = "nombremateria")
    private String nombremateria;
    @Basic(optional = false)
    @Column(name = "horasclase")
    private int horasclase;
    @JoinColumn(name = "seccionid", referencedColumnName = "seccionid")
    @ManyToOne
    private Secciones seccionid;

    public Materias() {
    }

    public Materias(Integer materiaid) {
        this.materiaid = materiaid;
    }

    public Materias(Integer materiaid, int horasclase) {
        this.materiaid = materiaid;
        this.horasclase = horasclase;
    }

    public Integer getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(Integer materiaid) {
        this.materiaid = materiaid;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public int getHorasclase() {
        return horasclase;
    }

    public void setHorasclase(int horasclase) {
        this.horasclase = horasclase;
    }

    public Secciones getSeccionid() {
        return seccionid;
    }

    public void setSeccionid(Secciones seccionid) {
        this.seccionid = seccionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaid != null ? materiaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.materiaid == null && other.materiaid != null) || (this.materiaid != null && !this.materiaid.equals(other.materiaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Materias[ materiaid=" + materiaid + " ]";
    }
    
}
