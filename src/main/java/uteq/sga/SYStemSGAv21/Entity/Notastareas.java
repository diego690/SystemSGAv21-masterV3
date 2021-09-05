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
@Table(name = "notastareas", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notastareas.findAll", query = "SELECT n FROM Notastareas n"),
    @NamedQuery(name = "Notastareas.findByIdnotastareas", query = "SELECT n FROM Notastareas n WHERE n.idnotastareas = :idnotastareas"),
    @NamedQuery(name = "Notastareas.findByNota", query = "SELECT n FROM Notastareas n WHERE n.nota = :nota")})
public class Notastareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotastareas")
    private Integer idnotastareas;
    @Basic(optional = false)
    @Column(name = "nota")
    private double nota;
    @JoinColumn(name = "identregatareas", referencedColumnName = "identregatareas")
    @ManyToOne(optional = false)
    private EntregaTareas identregatareas;

    public Notastareas() {
    }

    public Notastareas(Integer idnotastareas) {
        this.idnotastareas = idnotastareas;
    }

    public Notastareas(Integer idnotastareas, double nota) {
        this.idnotastareas = idnotastareas;
        this.nota = nota;
    }

    public Integer getIdnotastareas() {
        return idnotastareas;
    }

    public void setIdnotastareas(Integer idnotastareas) {
        this.idnotastareas = idnotastareas;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public EntregaTareas getIdentregatareas() {
        return identregatareas;
    }

    public void setIdentregatareas(EntregaTareas identregatareas) {
        this.identregatareas = identregatareas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotastareas != null ? idnotastareas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notastareas)) {
            return false;
        }
        Notastareas other = (Notastareas) object;
        if ((this.idnotastareas == null && other.idnotastareas != null) || (this.idnotastareas != null && !this.idnotastareas.equals(other.idnotastareas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Notastareas[ idnotastareas=" + idnotastareas + " ]";
    }
    
}
