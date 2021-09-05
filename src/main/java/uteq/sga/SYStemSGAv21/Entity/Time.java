/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "time", catalog = "Sis_SGA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t"),
    @NamedQuery(name = "Time.findByTimeid", query = "SELECT t FROM Time t WHERE t.timeid = :timeid"),
    @NamedQuery(name = "Time.findByTimestart", query = "SELECT t FROM Time t WHERE t.timestart = :timestart"),
    @NamedQuery(name = "Time.findByTimeend", query = "SELECT t FROM Time t WHERE t.timeend = :timeend"),
    @NamedQuery(name = "Time.findByDias", query = "SELECT t FROM Time t WHERE t.dias = :dias")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "timeid")
    private Integer timeid;
    @Basic(optional = false)
    @Column(name = "timestart")
    @Temporal(TemporalType.TIME)
    private Date timestart;
    @Basic(optional = false)
    @Column(name = "timeend")
    @Temporal(TemporalType.TIME)
    private Date timeend;
    @Basic(optional = false)
    @Column(name = "dias")
    private String dias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeid")
    private Collection<Horarioclase> horarioclaseCollection;

    public Time() {
    }

    public Time(Integer timeid) {
        this.timeid = timeid;
    }

    public Time(Integer timeid, Date timestart, Date timeend, String dias) {
        this.timeid = timeid;
        this.timestart = timestart;
        this.timeend = timeend;
        this.dias = dias;
    }

    public Integer getTimeid() {
        return timeid;
    }

    public void setTimeid(Integer timeid) {
        this.timeid = timeid;
    }

    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    @XmlTransient
    public Collection<Horarioclase> getHorarioclaseCollection() {
        return horarioclaseCollection;
    }

    public void setHorarioclaseCollection(Collection<Horarioclase> horarioclaseCollection) {
        this.horarioclaseCollection = horarioclaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeid != null ? timeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.timeid == null && other.timeid != null) || (this.timeid != null && !this.timeid.equals(other.timeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.SYStemSGAv21.Entity.Time[ timeid=" + timeid + " ]";
    }
    
}
