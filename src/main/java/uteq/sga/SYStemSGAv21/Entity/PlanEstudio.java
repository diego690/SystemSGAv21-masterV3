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
@Table(name = "plan_estudio", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanEstudio.findAll", query = "SELECT p FROM PlanEstudio p"),
    @NamedQuery(name = "PlanEstudio.findByIdplan", query = "SELECT p FROM PlanEstudio p WHERE p.idplan = :idplan"),
    @NamedQuery(name = "PlanEstudio.findByDescripcion", query = "SELECT p FROM PlanEstudio p WHERE p.descripcion = :descripcion")})
public class PlanEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplan")
    private Integer idplan;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false)
    private Asignaturas idasignatura;
    @JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
    @ManyToOne(optional = false)
    private Carreras idcarrera;

    public PlanEstudio() {
    }

    public PlanEstudio(Integer idplan) {
        this.idplan = idplan;
    }

    public PlanEstudio(Integer idplan, String descripcion) {
        this.idplan = idplan;
        this.descripcion = descripcion;
    }

    public Integer getIdplan() {
        return idplan;
    }

    public void setIdplan(Integer idplan) {
        this.idplan = idplan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asignaturas getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Asignaturas idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Carreras getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Carreras idcarrera) {
        this.idcarrera = idcarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplan != null ? idplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanEstudio)) {
            return false;
        }
        PlanEstudio other = (PlanEstudio) object;
        if ((this.idplan == null && other.idplan != null) || (this.idplan != null && !this.idplan.equals(other.idplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.PlanEstudio[ idplan=" + idplan + " ]";
    }
    
}
