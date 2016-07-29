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
@Table(name = "local_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalVenta.findAll", query = "SELECT l FROM LocalVenta l"),
    @NamedQuery(name = "LocalVenta.findByLvId", query = "SELECT l FROM LocalVenta l WHERE l.lvId = :lvId"),
    @NamedQuery(name = "LocalVenta.findByLvActividadPri", query = "SELECT l FROM LocalVenta l WHERE l.lvActividadPri = :lvActividadPri"),
    @NamedQuery(name = "LocalVenta.findByLvEmail", query = "SELECT l FROM LocalVenta l WHERE l.lvEmail = :lvEmail"),
    @NamedQuery(name = "LocalVenta.findByLvNombreCom", query = "SELECT l FROM LocalVenta l WHERE l.lvNombreCom = :lvNombreCom"),
    @NamedQuery(name = "LocalVenta.findByLvWeb", query = "SELECT l FROM LocalVenta l WHERE l.lvWeb = :lvWeb"),
    @NamedQuery(name = "LocalVenta.findByLvRazonSocial", query = "SELECT l FROM LocalVenta l WHERE l.lvRazonSocial = :lvRazonSocial"),
    @NamedQuery(name = "LocalVenta.findByLvRuc", query = "SELECT l FROM LocalVenta l WHERE l.lvRuc = :lvRuc"),
    @NamedQuery(name = "LocalVenta.findByLvTelefono", query = "SELECT l FROM LocalVenta l WHERE l.lvTelefono = :lvTelefono"),
    @NamedQuery(name = "LocalVenta.findByLvEstado", query = "SELECT l FROM LocalVenta l WHERE l.lvEstado = :lvEstado"),
    @NamedQuery(name = "LocalVenta.findByLvLogo", query = "SELECT l FROM LocalVenta l WHERE l.lvLogo = :lvLogo"),
    @NamedQuery(name = "LocalVenta.findByLvSlogan", query = "SELECT l FROM LocalVenta l WHERE l.lvSlogan = :lvSlogan"),
    @NamedQuery(name = "LocalVenta.findByLvServicio", query = "SELECT l FROM LocalVenta l WHERE l.lvServicio = :lvServicio"),
    @NamedQuery(name = "LocalVenta.findByLvPalabrasClave", query = "SELECT l FROM LocalVenta l WHERE l.lvPalabrasClave = :lvPalabrasClave"),
    @NamedQuery(name = "LocalVenta.findByLvRanking", query = "SELECT l FROM LocalVenta l WHERE l.lvRanking = :lvRanking"),
    @NamedQuery(name = "LocalVenta.findByLvTelCel", query = "SELECT l FROM LocalVenta l WHERE l.lvTelCel = :lvTelCel"),
    @NamedQuery(name = "LocalVenta.findByLvUsrCrea", query = "SELECT l FROM LocalVenta l WHERE l.lvUsrCrea = :lvUsrCrea"),
    @NamedQuery(name = "LocalVenta.findByLvUsrModifica", query = "SELECT l FROM LocalVenta l WHERE l.lvUsrModifica = :lvUsrModifica"),
    @NamedQuery(name = "LocalVenta.findByLvFechaCrea", query = "SELECT l FROM LocalVenta l WHERE l.lvFechaCrea = :lvFechaCrea"),
    @NamedQuery(name = "LocalVenta.findByLvFechaModifica", query = "SELECT l FROM LocalVenta l WHERE l.lvFechaModifica = :lvFechaModifica"),
    @NamedQuery(name = "LocalVenta.findByLvFoto", query = "SELECT l FROM LocalVenta l WHERE l.lvFoto = :lvFoto"),
    @NamedQuery(name = "LocalVenta.findByLvMas", query = "SELECT l FROM LocalVenta l WHERE l.lvMas = :lvMas"),
    @NamedQuery(name = "LocalVenta.findByLvPromo", query = "SELECT l FROM LocalVenta l WHERE l.lvPromo = :lvPromo"),
    @NamedQuery(name = "LocalVenta.findByLvGeo", query = "SELECT l FROM LocalVenta l WHERE l.lvGeo = :lvGeo"),
    @NamedQuery(name = "LocalVenta.findByLvFacebook", query = "SELECT l FROM LocalVenta l WHERE l.lvFacebook = :lvFacebook"),
    @NamedQuery(name = "LocalVenta.findByLvTwitter", query = "SELECT l FROM LocalVenta l WHERE l.lvTwitter = :lvTwitter"),
    @NamedQuery(name = "LocalVenta.findByLvVideo", query = "SELECT l FROM LocalVenta l WHERE l.lvVideo = :lvVideo")})
public class LocalVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lv_id")
    private Integer lvId;
    @Size(max = 255)
    @Column(name = "lv_actividad_pri")
    private String lvActividadPri;
    @Size(max = 255)
    @Column(name = "lv_email")
    private String lvEmail;
    @Size(max = 255)
    @Column(name = "lv_nombre_com")
    private String lvNombreCom;
    @Size(max = 255)
    @Column(name = "lv_web")
    private String lvWeb;
    @Size(max = 255)
    @Column(name = "lv_razon_social")
    private String lvRazonSocial;
    @Size(max = 255)
    @Column(name = "lv_ruc")
    private String lvRuc;
    @Size(max = 12)
    @Column(name = "lv_telefono")
    private String lvTelefono;
    @Size(max = 3)
    @Column(name = "lv_estado")
    private String lvEstado;
    @Size(max = 50)
    @Column(name = "lv_logo")
    private String lvLogo;
    @Size(max = 200)
    @Column(name = "lv_slogan")
    private String lvSlogan;
    @Size(max = 255)
    @Column(name = "lv_servicio")
    private String lvServicio;
    @Size(max = 200)
    @Column(name = "lv_palabras_clave")
    private String lvPalabrasClave;
    @Column(name = "lv_ranking")
    private Integer lvRanking;
    @Size(max = 12)
    @Column(name = "lv_tel_cel")
    private String lvTelCel;
    @Size(max = 25)
    @Column(name = "lv_usr_crea")
    private String lvUsrCrea;
    @Size(max = 25)
    @Column(name = "lv_usr_modifica")
    private String lvUsrModifica;
    @Column(name = "lv_fecha_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lvFechaCrea;
    @Column(name = "lv_fecha_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lvFechaModifica;
    @Size(max = 50)
    @Column(name = "lv_foto")
    private String lvFoto;
    @Size(max = 1)
    @Column(name = "lv_mas")
    private String lvMas;
    @Size(max = 1)
    @Column(name = "lv_promo")
    private String lvPromo;
    @Size(max = 1)
    @Column(name = "lv_geo")
    private String lvGeo;
    @Size(max = 200)
    @Column(name = "lv_facebook")
    private String lvFacebook;
    @Size(max = 200)
    @Column(name = "lv_twitter")
    private String lvTwitter;
    @Size(max = 200)
    @Column(name = "lv_video")
    private String lvVideo;
    @OneToMany(mappedBy = "lvId")
    private Collection<Ubicacion> ubicacionCollection;
    @OneToMany(mappedBy = "lvId")
    private Collection<LocalPromocion> localPromocionCollection;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne
    private Categoria catId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private Persona perId;

    public LocalVenta() {
    }

    public LocalVenta(Integer lvId) {
        this.lvId = lvId;
    }

    public Integer getLvId() {
        return lvId;
    }

    public void setLvId(Integer lvId) {
        this.lvId = lvId;
    }

    public String getLvActividadPri() {
        return lvActividadPri;
    }

    public void setLvActividadPri(String lvActividadPri) {
        this.lvActividadPri = lvActividadPri;
    }

    public String getLvEmail() {
        return lvEmail;
    }

    public void setLvEmail(String lvEmail) {
        this.lvEmail = lvEmail;
    }

    public String getLvNombreCom() {
        return lvNombreCom;
    }

    public void setLvNombreCom(String lvNombreCom) {
        this.lvNombreCom = lvNombreCom;
    }

    public String getLvWeb() {
        return lvWeb;
    }

    public void setLvWeb(String lvWeb) {
        this.lvWeb = lvWeb;
    }

    public String getLvRazonSocial() {
        return lvRazonSocial;
    }

    public void setLvRazonSocial(String lvRazonSocial) {
        this.lvRazonSocial = lvRazonSocial;
    }

    public String getLvRuc() {
        return lvRuc;
    }

    public void setLvRuc(String lvRuc) {
        this.lvRuc = lvRuc;
    }

    public String getLvTelefono() {
        return lvTelefono;
    }

    public void setLvTelefono(String lvTelefono) {
        this.lvTelefono = lvTelefono;
    }

    public String getLvEstado() {
        return lvEstado;
    }

    public void setLvEstado(String lvEstado) {
        this.lvEstado = lvEstado;
    }

    public String getLvLogo() {
        return lvLogo;
    }

    public void setLvLogo(String lvLogo) {
        this.lvLogo = lvLogo;
    }

    public String getLvSlogan() {
        return lvSlogan;
    }

    public void setLvSlogan(String lvSlogan) {
        this.lvSlogan = lvSlogan;
    }

    public String getLvServicio() {
        return lvServicio;
    }

    public void setLvServicio(String lvServicio) {
        this.lvServicio = lvServicio;
    }

    public String getLvPalabrasClave() {
        return lvPalabrasClave;
    }

    public void setLvPalabrasClave(String lvPalabrasClave) {
        this.lvPalabrasClave = lvPalabrasClave;
    }

    public Integer getLvRanking() {
        return lvRanking;
    }

    public void setLvRanking(Integer lvRanking) {
        this.lvRanking = lvRanking;
    }

    public String getLvTelCel() {
        return lvTelCel;
    }

    public void setLvTelCel(String lvTelCel) {
        this.lvTelCel = lvTelCel;
    }

    public String getLvUsrCrea() {
        return lvUsrCrea;
    }

    public void setLvUsrCrea(String lvUsrCrea) {
        this.lvUsrCrea = lvUsrCrea;
    }

    public String getLvUsrModifica() {
        return lvUsrModifica;
    }

    public void setLvUsrModifica(String lvUsrModifica) {
        this.lvUsrModifica = lvUsrModifica;
    }

    public Date getLvFechaCrea() {
        return lvFechaCrea;
    }

    public void setLvFechaCrea(Date lvFechaCrea) {
        this.lvFechaCrea = lvFechaCrea;
    }

    public Date getLvFechaModifica() {
        return lvFechaModifica;
    }

    public void setLvFechaModifica(Date lvFechaModifica) {
        this.lvFechaModifica = lvFechaModifica;
    }

    public String getLvFoto() {
        return lvFoto;
    }

    public void setLvFoto(String lvFoto) {
        this.lvFoto = lvFoto;
    }

    public String getLvMas() {
        return lvMas;
    }

    public void setLvMas(String lvMas) {
        this.lvMas = lvMas;
    }

    public String getLvPromo() {
        return lvPromo;
    }

    public void setLvPromo(String lvPromo) {
        this.lvPromo = lvPromo;
    }

    public String getLvGeo() {
        return lvGeo;
    }

    public void setLvGeo(String lvGeo) {
        this.lvGeo = lvGeo;
    }

    public String getLvFacebook() {
        return lvFacebook;
    }

    public void setLvFacebook(String lvFacebook) {
        this.lvFacebook = lvFacebook;
    }

    public String getLvTwitter() {
        return lvTwitter;
    }

    public void setLvTwitter(String lvTwitter) {
        this.lvTwitter = lvTwitter;
    }

    public String getLvVideo() {
        return lvVideo;
    }

    public void setLvVideo(String lvVideo) {
        this.lvVideo = lvVideo;
    }

    @XmlTransient
    public Collection<Ubicacion> getUbicacionCollection() {
        return ubicacionCollection;
    }

    public void setUbicacionCollection(Collection<Ubicacion> ubicacionCollection) {
        this.ubicacionCollection = ubicacionCollection;
    }

    @XmlTransient
    public Collection<LocalPromocion> getLocalPromocionCollection() {
        return localPromocionCollection;
    }

    public void setLocalPromocionCollection(Collection<LocalPromocion> localPromocionCollection) {
        this.localPromocionCollection = localPromocionCollection;
    }

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }

    public Persona getPerId() {
        return perId;
    }

    public void setPerId(Persona perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lvId != null ? lvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalVenta)) {
            return false;
        }
        LocalVenta other = (LocalVenta) object;
        if ((this.lvId == null && other.lvId != null) || (this.lvId != null && !this.lvId.equals(other.lvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.LocalVenta[ lvId=" + lvId + " ]";
    }
    
}
