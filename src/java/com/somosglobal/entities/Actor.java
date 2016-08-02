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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findByCatId", query = "SELECT a FROM Actor a WHERE a.catId.catId = :catId"),
    @NamedQuery(name = "Actor.findByIdAct", query = "SELECT a FROM Actor a WHERE a.idAct = :idAct"),
    @NamedQuery(name = "Actor.findByTipoAct", query = "SELECT a FROM Actor a WHERE a.tipoAct = :tipoAct"),
    @NamedQuery(name = "Actor.findByActividadAct", query = "SELECT a FROM Actor a WHERE a.actividadAct = :actividadAct"),
    @NamedQuery(name = "Actor.findByRazonSocialAct", query = "SELECT a FROM Actor a WHERE a.razonSocialAct = :razonSocialAct"),
    @NamedQuery(name = "Actor.findByNombresAct", query = "SELECT a FROM Actor a WHERE a.nombresAct = :nombresAct"),
    @NamedQuery(name = "Actor.findByCedrucpasAct", query = "SELECT a FROM Actor a WHERE a.cedrucpasAct = :cedrucpasAct"),
    @NamedQuery(name = "Actor.findByLogoAct", query = "SELECT a FROM Actor a WHERE a.logoAct = :logoAct"),
    @NamedQuery(name = "Actor.findByFotoAct", query = "SELECT a FROM Actor a WHERE a.fotoAct = :fotoAct"),
    @NamedQuery(name = "Actor.findBySloganAct", query = "SELECT a FROM Actor a WHERE a.sloganAct = :sloganAct"),
    @NamedQuery(name = "Actor.findByPalabrasClaveAct", query = "SELECT a FROM Actor a WHERE a.palabrasClaveAct = :palabrasClaveAct"),
    @NamedQuery(name = "Actor.findByRankingAct", query = "SELECT a FROM Actor a WHERE a.rankingAct = :rankingAct"),
    @NamedQuery(name = "Actor.findByUsrCreaAct", query = "SELECT a FROM Actor a WHERE a.usrCreaAct = :usrCreaAct"),
    @NamedQuery(name = "Actor.findByUsrModAct", query = "SELECT a FROM Actor a WHERE a.usrModAct = :usrModAct"),
    @NamedQuery(name = "Actor.findByFecCreaAct", query = "SELECT a FROM Actor a WHERE a.fecCreaAct = :fecCreaAct"),
    @NamedQuery(name = "Actor.findByFecModAct", query = "SELECT a FROM Actor a WHERE a.fecModAct = :fecModAct"),
    @NamedQuery(name = "Actor.findByEstadoAct", query = "SELECT a FROM Actor a WHERE a.estadoAct = :estadoAct"),
    @NamedQuery(name = "Actor.findByCalPrinAct", query = "SELECT a FROM Actor a WHERE a.calPrinAct = :calPrinAct"),
    @NamedQuery(name = "Actor.findByCalSecAct", query = "SELECT a FROM Actor a WHERE a.calSecAct = :calSecAct"),
    @NamedQuery(name = "Actor.findByLatitudAct", query = "SELECT a FROM Actor a WHERE a.latitudAct = :latitudAct"),
    @NamedQuery(name = "Actor.findByLongitudAct", query = "SELECT a FROM Actor a WHERE a.longitudAct = :longitudAct"),
    @NamedQuery(name = "Actor.findByNumPreAct", query = "SELECT a FROM Actor a WHERE a.numPreAct = :numPreAct"),
    @NamedQuery(name = "Actor.findBySectorAct", query = "SELECT a FROM Actor a WHERE a.sectorAct = :sectorAct"),
    @NamedQuery(name = "Actor.findByUrlDireccionAct", query = "SELECT a FROM Actor a WHERE a.urlDireccionAct = :urlDireccionAct"),
    @NamedQuery(name = "Actor.findByUrlSviewAct", query = "SELECT a FROM Actor a WHERE a.urlSviewAct = :urlSviewAct"),
    @NamedQuery(name = "Actor.findByApellidosAct", query = "SELECT a FROM Actor a WHERE a.apellidosAct = :apellidosAct"),
    @NamedQuery(name = "Actor.findByRepresentanteAct", query = "SELECT a FROM Actor a WHERE a.representanteAct = :representanteAct"),
    @NamedQuery(name = "Actor.findByMailAct", query = "SELECT a FROM Actor a WHERE a.mailAct = :mailAct"),
    @NamedQuery(name = "Actor.findByFecNacAct", query = "SELECT a FROM Actor a WHERE a.fecNacAct = :fecNacAct"),
    @NamedQuery(name = "Actor.findBySexoAct", query = "SELECT a FROM Actor a WHERE a.sexoAct = :sexoAct"),
    @NamedQuery(name = "Actor.findByPorcentajeAct", query = "SELECT a FROM Actor a WHERE a.porcentajeAct = :porcentajeAct")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_act")
    private Integer idAct;
    @Size(max = 2)
    @Column(name = "tipo_act")
    private String tipoAct;
    @Size(max = 400)
    @Column(name = "actividad_act")
    private String actividadAct;
    @Size(max = 255)
    @Column(name = "razon_social_act")
    private String razonSocialAct;
    @Size(max = 255)
    @Column(name = "nombres_act")
    private String nombresAct;
    @Size(max = 25)
    @Column(name = "cedrucpas_act")
    private String cedrucpasAct;
    @Size(max = 50)
    @Column(name = "logo_act")
    private String logoAct;
    @Size(max = 50)
    @Column(name = "foto_act")
    private String fotoAct;
    @Size(max = 200)
    @Column(name = "slogan_act")
    private String sloganAct;
    @Lob
    @Size(max = 16777215)
    @Column(name = "servicio_act")
    private String servicioAct;
    @Size(max = 200)
    @Column(name = "palabras_clave_act")
    private String palabrasClaveAct;
    @Column(name = "ranking_act")
    private Integer rankingAct;
    @Size(max = 25)
    @Column(name = "usr_crea_act")
    private String usrCreaAct;
    @Size(max = 25)
    @Column(name = "usr_mod_act")
    private String usrModAct;
    @Column(name = "fec_crea_act")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreaAct;
    @Column(name = "fec_mod_act")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModAct;
    @Size(max = 3)
    @Column(name = "estado_act")
    private String estadoAct;
    @Size(max = 500)
    @Column(name = "cal_prin_act")
    private String calPrinAct;
    @Size(max = 500)
    @Column(name = "cal_sec_act")
    private String calSecAct;
    @Size(max = 255)
    @Column(name = "latitud_act")
    private String latitudAct;
    @Size(max = 255)
    @Column(name = "longitud_act")
    private String longitudAct;
    @Size(max = 50)
    @Column(name = "num_pre_act")
    private String numPreAct;
    @Size(max = 200)
    @Column(name = "sector_act")
    private String sectorAct;
    @Size(max = 500)
    @Column(name = "url_direccion_act")
    private String urlDireccionAct;
    @Size(max = 500)
    @Column(name = "url_sview_act")
    private String urlSviewAct;
    @Size(max = 255)
    @Column(name = "apellidos_act")
    private String apellidosAct;
    @Size(max = 255)
    @Column(name = "representante_act")
    private String representanteAct;
    @Size(max = 255)
    @Column(name = "mail_act")
    private String mailAct;
    @Column(name = "fec_nac_act")
    @Temporal(TemporalType.DATE)
    private Date fecNacAct;
    @Size(max = 1)
    @Column(name = "sexo_act")
    private String sexoAct;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_act")
    private BigDecimal porcentajeAct;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAct")
    private Collection<ActorReferencia> actorReferenciaCollection;
    @OneToMany(mappedBy = "idActPadre")
    private Collection<Actor> actorCollection;
    @JoinColumn(name = "id_act_padre", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idActPadre;
    @JoinColumn(name = "id_ar", referencedColumnName = "id_ar")
    @ManyToOne
    private ActorReferencia idAr;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne
    private Categoria catId;
    @JoinColumn(name = "loc_id", referencedColumnName = "loc_id")
    @ManyToOne
    private Localidad locId;
    @OneToMany(mappedBy = "idAct")
    private Collection<ActorRol> actorRolCollection;
    @OneToMany(mappedBy = "idAct")
    private Collection<Usuario> usuarioCollection;

    public Actor() {
    }

    public Actor(Integer idAct) {
        this.idAct = idAct;
    }

    public Integer getIdAct() {
        return idAct;
    }

    public void setIdAct(Integer idAct) {
        this.idAct = idAct;
    }

    public String getTipoAct() {
        return tipoAct;
    }

    public void setTipoAct(String tipoAct) {
        this.tipoAct = tipoAct;
    }

    public String getActividadAct() {
        return actividadAct;
    }

    public void setActividadAct(String actividadAct) {
        this.actividadAct = actividadAct;
    }

    public String getRazonSocialAct() {
        return razonSocialAct;
    }

    public void setRazonSocialAct(String razonSocialAct) {
        this.razonSocialAct = razonSocialAct;
    }

    public String getNombresAct() {
        return nombresAct;
    }

    public void setNombresAct(String nombresAct) {
        this.nombresAct = nombresAct;
    }

    public String getCedrucpasAct() {
        return cedrucpasAct;
    }

    public void setCedrucpasAct(String cedrucpasAct) {
        this.cedrucpasAct = cedrucpasAct;
    }

    public String getLogoAct() {
        return logoAct;
    }

    public void setLogoAct(String logoAct) {
        this.logoAct = logoAct;
    }

    public String getFotoAct() {
        return fotoAct;
    }

    public void setFotoAct(String fotoAct) {
        this.fotoAct = fotoAct;
    }

    public String getSloganAct() {
        return sloganAct;
    }

    public void setSloganAct(String sloganAct) {
        this.sloganAct = sloganAct;
    }

    public String getServicioAct() {
        return servicioAct;
    }

    public void setServicioAct(String servicioAct) {
        this.servicioAct = servicioAct;
    }

    public String getPalabrasClaveAct() {
        return palabrasClaveAct;
    }

    public void setPalabrasClaveAct(String palabrasClaveAct) {
        this.palabrasClaveAct = palabrasClaveAct;
    }

    public Integer getRankingAct() {
        return rankingAct;
    }

    public void setRankingAct(Integer rankingAct) {
        this.rankingAct = rankingAct;
    }

    public String getUsrCreaAct() {
        return usrCreaAct;
    }

    public void setUsrCreaAct(String usrCreaAct) {
        this.usrCreaAct = usrCreaAct;
    }

    public String getUsrModAct() {
        return usrModAct;
    }

    public void setUsrModAct(String usrModAct) {
        this.usrModAct = usrModAct;
    }

    public Date getFecCreaAct() {
        return fecCreaAct;
    }

    public void setFecCreaAct(Date fecCreaAct) {
        this.fecCreaAct = fecCreaAct;
    }

    public Date getFecModAct() {
        return fecModAct;
    }

    public void setFecModAct(Date fecModAct) {
        this.fecModAct = fecModAct;
    }

    public String getEstadoAct() {
        return estadoAct;
    }

    public void setEstadoAct(String estadoAct) {
        this.estadoAct = estadoAct;
    }

    public String getCalPrinAct() {
        return calPrinAct;
    }

    public void setCalPrinAct(String calPrinAct) {
        this.calPrinAct = calPrinAct;
    }

    public String getCalSecAct() {
        return calSecAct;
    }

    public void setCalSecAct(String calSecAct) {
        this.calSecAct = calSecAct;
    }

    public String getLatitudAct() {
        return latitudAct;
    }

    public void setLatitudAct(String latitudAct) {
        this.latitudAct = latitudAct;
    }

    public String getLongitudAct() {
        return longitudAct;
    }

    public void setLongitudAct(String longitudAct) {
        this.longitudAct = longitudAct;
    }

    public String getNumPreAct() {
        return numPreAct;
    }

    public void setNumPreAct(String numPreAct) {
        this.numPreAct = numPreAct;
    }

    public String getSectorAct() {
        return sectorAct;
    }

    public void setSectorAct(String sectorAct) {
        this.sectorAct = sectorAct;
    }

    public String getUrlDireccionAct() {
        return urlDireccionAct;
    }

    public void setUrlDireccionAct(String urlDireccionAct) {
        this.urlDireccionAct = urlDireccionAct;
    }

    public String getUrlSviewAct() {
        return urlSviewAct;
    }

    public void setUrlSviewAct(String urlSviewAct) {
        this.urlSviewAct = urlSviewAct;
    }

    public String getApellidosAct() {
        return apellidosAct;
    }

    public void setApellidosAct(String apellidosAct) {
        this.apellidosAct = apellidosAct;
    }

    public String getRepresentanteAct() {
        return representanteAct;
    }

    public void setRepresentanteAct(String representanteAct) {
        this.representanteAct = representanteAct;
    }

    public String getMailAct() {
        return mailAct;
    }

    public void setMailAct(String mailAct) {
        this.mailAct = mailAct;
    }

    public Date getFecNacAct() {
        return fecNacAct;
    }

    public void setFecNacAct(Date fecNacAct) {
        this.fecNacAct = fecNacAct;
    }

    public String getSexoAct() {
        return sexoAct;
    }

    public void setSexoAct(String sexoAct) {
        this.sexoAct = sexoAct;
    }

    public BigDecimal getPorcentajeAct() {
        return porcentajeAct;
    }

    public void setPorcentajeAct(BigDecimal porcentajeAct) {
        this.porcentajeAct = porcentajeAct;
    }

    @XmlTransient
    public Collection<ActorReferencia> getActorReferenciaCollection() {
        return actorReferenciaCollection;
    }

    public void setActorReferenciaCollection(Collection<ActorReferencia> actorReferenciaCollection) {
        this.actorReferenciaCollection = actorReferenciaCollection;
    }

    @XmlTransient
    public Collection<Actor> getActorCollection() {
        return actorCollection;
    }

    public void setActorCollection(Collection<Actor> actorCollection) {
        this.actorCollection = actorCollection;
    }

    public Actor getIdActPadre() {
        return idActPadre;
    }

    public void setIdActPadre(Actor idActPadre) {
        this.idActPadre = idActPadre;
    }

    public ActorReferencia getIdAr() {
        return idAr;
    }

    public void setIdAr(ActorReferencia idAr) {
        this.idAr = idAr;
    }

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }

    public Localidad getLocId() {
        return locId;
    }

    public void setLocId(Localidad locId) {
        this.locId = locId;
    }

    @XmlTransient
    public Collection<ActorRol> getActorRolCollection() {
        return actorRolCollection;
    }

    public void setActorRolCollection(Collection<ActorRol> actorRolCollection) {
        this.actorRolCollection = actorRolCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAct != null ? idAct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.idAct == null && other.idAct != null) || (this.idAct != null && !this.idAct.equals(other.idAct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.Actor[ idAct=" + idAct + " ]";
    }
    
}
