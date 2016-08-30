/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
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
@Table(name = "actor_referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActorReferencia.findAll", query = "SELECT a FROM ActorReferencia a"),
    @NamedQuery(name = "ActorReferencia.findIdAct", query = "SELECT a FROM ActorReferencia a WHERE a.idAct.idAct = :idAct"),
    @NamedQuery(name = "ActorReferencia.findByIdAr", query = "SELECT a FROM ActorReferencia a WHERE a.idAr = :idAr"),
    @NamedQuery(name = "ActorReferencia.findByActorIdAndCatalogo", query = "SELECT a FROM ActorReferencia a WHERE a.idAct = :idAct AND a.idCg = :idCatalogo "),
    @NamedQuery(name = "ActorReferencia.findByIdActAndiNCatalogo", query = "SELECT a FROM ActorReferencia a WHERE a.idAct = :idAct AND a.idCg IN :idCgList"),
    @NamedQuery(name = "ActorReferencia.findAllInCatalogo", query = "SELECT a FROM ActorReferencia a WHERE a.idCg IN :idCgList"),
    @NamedQuery(name = "ActorReferencia.findByVal1Ar", query = "SELECT a FROM ActorReferencia a WHERE a.val1Ar = :val1Ar"),
    @NamedQuery(name = "ActorReferencia.findByVal2Ar", query = "SELECT a FROM ActorReferencia a WHERE a.val2Ar = :val2Ar"),
    @NamedQuery(name = "ActorReferencia.findByVal3Ar", query = "SELECT a FROM ActorReferencia a WHERE a.val3Ar = :val3Ar"),
    @NamedQuery(name = "ActorReferencia.findByUsrCreaAr", query = "SELECT a FROM ActorReferencia a WHERE a.usrCreaAr = :usrCreaAr"),
    @NamedQuery(name = "ActorReferencia.findByUsrModAr", query = "SELECT a FROM ActorReferencia a WHERE a.usrModAr = :usrModAr"),
    @NamedQuery(name = "ActorReferencia.findByFecCreaAr", query = "SELECT a FROM ActorReferencia a WHERE a.fecCreaAr = :fecCreaAr"),
    @NamedQuery(name = "ActorReferencia.findByFecModAr", query = "SELECT a FROM ActorReferencia a WHERE a.fecModAr = :fecModAr"),
    @NamedQuery(name = "ActorReferencia.findByVal4Ar", query = "SELECT a FROM ActorReferencia a WHERE a.val4Ar = :val4Ar"),
    @NamedQuery(name = "ActorReferencia.findByEstadoAr", query = "SELECT a FROM ActorReferencia a WHERE a.estadoAr = :estadoAr"),
    @NamedQuery(name = "ActorReferencia.findByUrlGmapAr", query = "SELECT a FROM ActorReferencia a WHERE a.urlGmapAr = :urlGmapAr"),
    @NamedQuery(name = "ActorReferencia.findByUrlSviewAr", query = "SELECT a FROM ActorReferencia a WHERE a.urlSviewAr = :urlSviewAr"),
    @NamedQuery(name = "ActorReferencia.findByLatitudAr", query = "SELECT a FROM ActorReferencia a WHERE a.latitudAr = :latitudAr"),
    @NamedQuery(name = "ActorReferencia.findByLongitudAr", query = "SELECT a FROM ActorReferencia a WHERE a.longitudAr = :longitudAr")})
public class ActorReferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ar")
    private Integer idAr;
    @Size(max = 255)
    @Column(name = "val1_ar")
    private String val1Ar;
    @Size(max = 255)
    @Column(name = "val2_ar")
    private String val2Ar;
    @Size(max = 255)
    @Column(name = "val3_ar")
    private String val3Ar;
    @Size(max = 25)
    @Column(name = "usr_crea_ar")
    private String usrCreaAr;
    @Size(max = 25)
    @Column(name = "usr_mod_ar")
    private String usrModAr;
    @Column(name = "fec_crea_ar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreaAr;
    @Column(name = "fec_mod_ar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModAr;
    @Size(max = 25)
    @Column(name = "val4_ar")
    private String val4Ar;
    @Size(max = 3)
    @Column(name = "estado_ar")
    private String estadoAr;
    @Size(max = 255)
    @Column(name = "url_gmap_ar")
    private String urlGmapAr;
    @Size(max = 255)
    @Column(name = "url_sview_ar")
    private String urlSviewAr;
    @Size(max = 100)
    @Column(name = "latitud_ar")
    private String latitudAr;
    @Size(max = 100)
    @Column(name = "longitud_ar")
    private String longitudAr;
    @JoinColumn(name = "id_act", referencedColumnName = "id_act")
    @ManyToOne(optional = false)
    private Actor idAct;
    @JoinColumn(name = "id_cg", referencedColumnName = "id_cg")
    @ManyToOne(optional = false)
    private CatalogoGen idCg;
    @OneToMany(mappedBy = "idAr")
    private Collection<Actor> actorCollection;

    public ActorReferencia() {
    }

    public ActorReferencia(Integer idAr) {
        this.idAr = idAr;
    }

    public Integer getIdAr() {
        return idAr;
    }

    public void setIdAr(Integer idAr) {
        this.idAr = idAr;
    }

    public String getVal1Ar() {
        return val1Ar;
    }

    public void setVal1Ar(String val1Ar) {
        this.val1Ar = val1Ar;
    }

    public String getVal2Ar() {
        return val2Ar;
    }

    public void setVal2Ar(String val2Ar) {
        this.val2Ar = val2Ar;
    }

    public String getVal3Ar() {
        return val3Ar;
    }

    public void setVal3Ar(String val3Ar) {
        this.val3Ar = val3Ar;
    }

    public String getUsrCreaAr() {
        return usrCreaAr;
    }

    public void setUsrCreaAr(String usrCreaAr) {
        this.usrCreaAr = usrCreaAr;
    }

    public String getUsrModAr() {
        return usrModAr;
    }

    public void setUsrModAr(String usrModAr) {
        this.usrModAr = usrModAr;
    }

    public Date getFecCreaAr() {
        return fecCreaAr;
    }

    public void setFecCreaAr(Date fecCreaAr) {
        this.fecCreaAr = fecCreaAr;
    }

    public Date getFecModAr() {
        return fecModAr;
    }

    public void setFecModAr(Date fecModAr) {
        this.fecModAr = fecModAr;
    }

    public String getVal4Ar() {
        return val4Ar;
    }

    public void setVal4Ar(String val4Ar) {
        this.val4Ar = val4Ar;
    }

    public String getEstadoAr() {
        return estadoAr;
    }

    public void setEstadoAr(String estadoAr) {
        this.estadoAr = estadoAr;
    }

    public String getUrlGmapAr() {
        return urlGmapAr;
    }

    public void setUrlGmapAr(String urlGmapAr) {
        this.urlGmapAr = urlGmapAr;
    }

    public String getUrlSviewAr() {
        return urlSviewAr;
    }

    public void setUrlSviewAr(String urlSviewAr) {
        this.urlSviewAr = urlSviewAr;
    }

    public String getLatitudAr() {
        return latitudAr;
    }

    public void setLatitudAr(String latitudAr) {
        this.latitudAr = latitudAr;
    }

    public String getLongitudAr() {
        return longitudAr;
    }

    public void setLongitudAr(String longitudAr) {
        this.longitudAr = longitudAr;
    }

    public Actor getIdAct() {
        return idAct;
    }

    public void setIdAct(Actor idAct) {
        this.idAct = idAct;
    }

    public CatalogoGen getIdCg() {
        return idCg;
    }

    public void setIdCg(CatalogoGen idCg) {
        this.idCg = idCg;
    }

    @XmlTransient
    public Collection<Actor> getActorCollection() {
        return actorCollection;
    }

    public void setActorCollection(Collection<Actor> actorCollection) {
        this.actorCollection = actorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAr != null ? idAr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActorReferencia)) {
            return false;
        }
        ActorReferencia other = (ActorReferencia) object;
        if ((this.idAr == null && other.idAr != null) || (this.idAr != null && !this.idAr.equals(other.idAr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.ActorReferencia[ idAr=" + idAr + " ]";
    }
    
}
