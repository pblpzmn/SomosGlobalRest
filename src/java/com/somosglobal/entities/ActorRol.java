/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "actor_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActorRol.findAll", query = "SELECT a FROM ActorRol a"),
    @NamedQuery(name = "ActorRol.findByIdArol", query = "SELECT a FROM ActorRol a WHERE a.idArol = :idArol"),
    @NamedQuery(name = "ActorRol.findByPrcArol", query = "SELECT a FROM ActorRol a WHERE a.prcArol = :prcArol"),
    @NamedQuery(name = "ActorRol.findByEstadoArol", query = "SELECT a FROM ActorRol a WHERE a.estadoArol = :estadoArol"),
    @NamedQuery(name = "ActorRol.findByFecCreaArol", query = "SELECT a FROM ActorRol a WHERE a.fecCreaArol = :fecCreaArol"),
    @NamedQuery(name = "ActorRol.findByFecModArol", query = "SELECT a FROM ActorRol a WHERE a.fecModArol = :fecModArol")})
public class ActorRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arol")
    private Integer idArol;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prc_arol")
    private BigDecimal prcArol;
    @Size(max = 3)
    @Column(name = "estado_arol")
    private String estadoArol;
    @Column(name = "fec_crea_arol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreaArol;
    @Column(name = "fec_mod_arol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModArol;
    @JoinColumn(name = "id_act", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idAct;
    @OneToMany(mappedBy = "idArolPadre")
    private Collection<ActorRol> actorRolCollection;
    @JoinColumn(name = "id_arol_padre", referencedColumnName = "id_arol")
    @ManyToOne
    private ActorRol idArolPadre;
    @JoinColumn(name = "id_cg", referencedColumnName = "id_cg")
    @ManyToOne
    private CatalogoGen idCg;

    public ActorRol() {
    }

    public ActorRol(Integer idArol) {
        this.idArol = idArol;
    }

    public Integer getIdArol() {
        return idArol;
    }

    public void setIdArol(Integer idArol) {
        this.idArol = idArol;
    }

    public BigDecimal getPrcArol() {
        return prcArol;
    }

    public void setPrcArol(BigDecimal prcArol) {
        this.prcArol = prcArol;
    }

    public String getEstadoArol() {
        return estadoArol;
    }

    public void setEstadoArol(String estadoArol) {
        this.estadoArol = estadoArol;
    }

    public Date getFecCreaArol() {
        return fecCreaArol;
    }

    public void setFecCreaArol(Date fecCreaArol) {
        this.fecCreaArol = fecCreaArol;
    }

    public Date getFecModArol() {
        return fecModArol;
    }

    public void setFecModArol(Date fecModArol) {
        this.fecModArol = fecModArol;
    }

    public Actor getIdAct() {
        return idAct;
    }

    public void setIdAct(Actor idAct) {
        this.idAct = idAct;
    }

    @XmlTransient
    public Collection<ActorRol> getActorRolCollection() {
        return actorRolCollection;
    }

    public void setActorRolCollection(Collection<ActorRol> actorRolCollection) {
        this.actorRolCollection = actorRolCollection;
    }

    public ActorRol getIdArolPadre() {
        return idArolPadre;
    }

    public void setIdArolPadre(ActorRol idArolPadre) {
        this.idArolPadre = idArolPadre;
    }

    public CatalogoGen getIdCg() {
        return idCg;
    }

    public void setIdCg(CatalogoGen idCg) {
        this.idCg = idCg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArol != null ? idArol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActorRol)) {
            return false;
        }
        ActorRol other = (ActorRol) object;
        if ((this.idArol == null && other.idArol != null) || (this.idArol != null && !this.idArol.equals(other.idArol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.ActorRol[ idArol=" + idArol + " ]";
    }
    
}
