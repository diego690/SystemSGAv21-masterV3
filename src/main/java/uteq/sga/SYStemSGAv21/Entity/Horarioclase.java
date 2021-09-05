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
@Table(name = "horarioclase", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarioclase.findAll", query = "SELECT h FROM Horarioclase h"),
    @NamedQuery(name = "Horarioclase.findByHorarioid", query = "SELECT h FROM Horarioclase h WHERE h.horarioid = :horarioid"),
    @NamedQuery(name = "Horarioclase.findByDia", query = "SELECT h FROM Horarioclase h WHERE h.dia = :dia")})
public class Horarioclase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "horarioid")
    private Integer horarioid;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false)
    private Asignaturas idasignatura;
    @JoinColumn(name = "aulaid", referencedColumnName = "aulaid")
    @ManyToOne(optional = false)
    private Aula aulaid;
    @JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
    @ManyToOne(optional = false)
    private Carreras idcarrera;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docentes iddocente;
    @JoinColumn(name = "timeid", referencedColumnName = "timeid")
    @ManyToOne(optional = false)
    private Time timeid;

    public Horarioclase() {
    }

    public Horarioclase(Integer horarioid) {
        this.horarioid = horarioid;
    }

    public Horarioclase(Integer horarioid, String dia) {
        this.horarioid = horarioid;
        this.dia = dia;
    }

    public Integer getHorarioid() {
        return horarioid;
    }

    public void setHorarioid(Integer horarioid) {
        this.horarioid = horarioid;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Asignaturas getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Asignaturas idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Aula getAulaid() {
        return aulaid;
    }

    public void setAulaid(Aula aulaid) {
        this.aulaid = aulaid;
    }

    public Carreras getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Carreras idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Docentes getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docentes iddocente) {
        this.iddocente = iddocente;
    }

    public Time getTimeid() {
        return timeid;
    }

    public void setTimeid(Time timeid) {
        this.timeid = timeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioid != null ? horarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarioclase)) {
            return false;
        }
        Horarioclase other = (Horarioclase) object;
        if ((this.horarioid == null && other.horarioid != null) || (this.horarioid != null && !this.horarioid.equals(other.horarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Horarioclase[ horarioid=" + horarioid + " ]";
    }
    
}
