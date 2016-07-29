/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "ubicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u"),
    @NamedQuery(name = "Ubicacion.findByUbiId", query = "SELECT u FROM Ubicacion u WHERE u.ubiId = :ubiId"),
    @NamedQuery(name = "Ubicacion.findByUbiCallePrin", query = "SELECT u FROM Ubicacion u WHERE u.ubiCallePrin = :ubiCallePrin"),
    @NamedQuery(name = "Ubicacion.findByUbiCalleSec", query = "SELECT u FROM Ubicacion u WHERE u.ubiCalleSec = :ubiCalleSec"),
    @NamedQuery(name = "Ubicacion.findByUbiLatitud", query = "SELECT u FROM Ubicacion u WHERE u.ubiLatitud = :ubiLatitud"),
    @NamedQuery(name = "Ubicacion.findByUbiLongitud", query = "SELECT u FROM Ubicacion u WHERE u.ubiLongitud = :ubiLongitud"),
    @NamedQuery(name = "Ubicacion.findByUbiNumPredio", query = "SELECT u FROM Ubicacion u WHERE u.ubiNumPredio = :ubiNumPredio"),
    @NamedQuery(name = "Ubicacion.findByUbiSector", query = "SELECT u FROM Ubicacion u WHERE u.ubiSector = :ubiSector"),
    @NamedQuery(name = "Ubicacion.findByUbiEstado", query = "SELECT u FROM Ubicacion u WHERE u.ubiEstado = :ubiEstado"),
    @NamedQuery(name = "Ubicacion.findByUbiLunVieAbre", query = "SELECT u FROM Ubicacion u WHERE u.ubiLunVieAbre = :ubiLunVieAbre"),
    @NamedQuery(name = "Ubicacion.findByUbiLunVieCierra", query = "SELECT u FROM Ubicacion u WHERE u.ubiLunVieCierra = :ubiLunVieCierra"),
    @NamedQuery(name = "Ubicacion.findByUbiSdfAbre", query = "SELECT u FROM Ubicacion u WHERE u.ubiSdfAbre = :ubiSdfAbre"),
    @NamedQuery(name = "Ubicacion.findByUbiSdfCierra", query = "SELECT u FROM Ubicacion u WHERE u.ubiSdfCierra = :ubiSdfCierra"),
    @NamedQuery(name = "Ubicacion.findByUbiFrameMapa", query = "SELECT u FROM Ubicacion u WHERE u.ubiFrameMapa = :ubiFrameMapa"),
    @NamedQuery(name = "Ubicacion.findByUbiFrameSv", query = "SELECT u FROM Ubicacion u WHERE u.ubiFrameSv = :ubiFrameSv"),
    @NamedQuery(name = "Ubicacion.findByUbiPalabrasClave", query = "SELECT u FROM Ubicacion u WHERE u.ubiPalabrasClave = :ubiPalabrasClave"),
    @NamedQuery(name = "Ubicacion.findByUbiMas", query = "SELECT u FROM Ubicacion u WHERE u.ubiMas = :ubiMas"),
    @NamedQuery(name = "Ubicacion.findByUbiGeo", query = "SELECT u FROM Ubicacion u WHERE u.ubiGeo = :ubiGeo"),
    @NamedQuery(name = "Ubicacion.findByUbiPromo", query = "SELECT u FROM Ubicacion u WHERE u.ubiPromo = :ubiPromo")})
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ubi_id")
    private Integer ubiId;
    @Size(max = 255)
    @Column(name = "ubi_calle_prin")
    private String ubiCallePrin;
    @Size(max = 255)
    @Column(name = "ubi_calle_sec")
    private String ubiCalleSec;
    @Size(max = 255)
    @Column(name = "ubi_latitud")
    private String ubiLatitud;
    @Size(max = 255)
    @Column(name = "ubi_longitud")
    private String ubiLongitud;
    @Size(max = 255)
    @Column(name = "ubi_num_predio")
    private String ubiNumPredio;
    @Size(max = 255)
    @Column(name = "ubi_sector")
    private String ubiSector;
    @Size(max = 3)
    @Column(name = "ubi_estado")
    private String ubiEstado;
    @Size(max = 5)
    @Column(name = "ubi_lun_vie_abre")
    private String ubiLunVieAbre;
    @Size(max = 5)
    @Column(name = "ubi_lun_vie_cierra")
    private String ubiLunVieCierra;
    @Size(max = 5)
    @Column(name = "ubi_sdf_abre")
    private String ubiSdfAbre;
    @Size(max = 5)
    @Column(name = "ubi_sdf_cierra")
    private String ubiSdfCierra;
    @Size(max = 500)
    @Column(name = "ubi_frame_mapa")
    private String ubiFrameMapa;
    @Size(max = 500)
    @Column(name = "ubi_frame_sv")
    private String ubiFrameSv;
    @Size(max = 200)
    @Column(name = "ubi_palabras_clave")
    private String ubiPalabrasClave;
    @Size(max = 1)
    @Column(name = "ubi_mas")
    private String ubiMas;
    @Size(max = 1)
    @Column(name = "ubi_geo")
    private String ubiGeo;
    @Size(max = 1)
    @Column(name = "ubi_promo")
    private String ubiPromo;
    @JoinColumn(name = "bar_id", referencedColumnName = "bar_id")
    @ManyToOne
    private Barrio barId;
    @JoinColumn(name = "lv_id", referencedColumnName = "lv_id")
    @ManyToOne
    private LocalVenta lvId;

    public Ubicacion() {
    }

    public Ubicacion(Integer ubiId) {
        this.ubiId = ubiId;
    }

    public Integer getUbiId() {
        return ubiId;
    }

    public void setUbiId(Integer ubiId) {
        this.ubiId = ubiId;
    }

    public String getUbiCallePrin() {
        return ubiCallePrin;
    }

    public void setUbiCallePrin(String ubiCallePrin) {
        this.ubiCallePrin = ubiCallePrin;
    }

    public String getUbiCalleSec() {
        return ubiCalleSec;
    }

    public void setUbiCalleSec(String ubiCalleSec) {
        this.ubiCalleSec = ubiCalleSec;
    }

    public String getUbiLatitud() {
        return ubiLatitud;
    }

    public void setUbiLatitud(String ubiLatitud) {
        this.ubiLatitud = ubiLatitud;
    }

    public String getUbiLongitud() {
        return ubiLongitud;
    }

    public void setUbiLongitud(String ubiLongitud) {
        this.ubiLongitud = ubiLongitud;
    }

    public String getUbiNumPredio() {
        return ubiNumPredio;
    }

    public void setUbiNumPredio(String ubiNumPredio) {
        this.ubiNumPredio = ubiNumPredio;
    }

    public String getUbiSector() {
        return ubiSector;
    }

    public void setUbiSector(String ubiSector) {
        this.ubiSector = ubiSector;
    }

    public String getUbiEstado() {
        return ubiEstado;
    }

    public void setUbiEstado(String ubiEstado) {
        this.ubiEstado = ubiEstado;
    }

    public String getUbiLunVieAbre() {
        return ubiLunVieAbre;
    }

    public void setUbiLunVieAbre(String ubiLunVieAbre) {
        this.ubiLunVieAbre = ubiLunVieAbre;
    }

    public String getUbiLunVieCierra() {
        return ubiLunVieCierra;
    }

    public void setUbiLunVieCierra(String ubiLunVieCierra) {
        this.ubiLunVieCierra = ubiLunVieCierra;
    }

    public String getUbiSdfAbre() {
        return ubiSdfAbre;
    }

    public void setUbiSdfAbre(String ubiSdfAbre) {
        this.ubiSdfAbre = ubiSdfAbre;
    }

    public String getUbiSdfCierra() {
        return ubiSdfCierra;
    }

    public void setUbiSdfCierra(String ubiSdfCierra) {
        this.ubiSdfCierra = ubiSdfCierra;
    }

    public String getUbiFrameMapa() {
        return ubiFrameMapa;
    }

    public void setUbiFrameMapa(String ubiFrameMapa) {
        this.ubiFrameMapa = ubiFrameMapa;
    }

    public String getUbiFrameSv() {
        return ubiFrameSv;
    }

    public void setUbiFrameSv(String ubiFrameSv) {
        this.ubiFrameSv = ubiFrameSv;
    }

    public String getUbiPalabrasClave() {
        return ubiPalabrasClave;
    }

    public void setUbiPalabrasClave(String ubiPalabrasClave) {
        this.ubiPalabrasClave = ubiPalabrasClave;
    }

    public String getUbiMas() {
        return ubiMas;
    }

    public void setUbiMas(String ubiMas) {
        this.ubiMas = ubiMas;
    }

    public String getUbiGeo() {
        return ubiGeo;
    }

    public void setUbiGeo(String ubiGeo) {
        this.ubiGeo = ubiGeo;
    }

    public String getUbiPromo() {
        return ubiPromo;
    }

    public void setUbiPromo(String ubiPromo) {
        this.ubiPromo = ubiPromo;
    }

    public Barrio getBarId() {
        return barId;
    }

    public void setBarId(Barrio barId) {
        this.barId = barId;
    }

    public LocalVenta getLvId() {
        return lvId;
    }

    public void setLvId(LocalVenta lvId) {
        this.lvId = lvId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubiId != null ? ubiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.ubiId == null && other.ubiId != null) || (this.ubiId != null && !this.ubiId.equals(other.ubiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.Ubicacion[ ubiId=" + ubiId + " ]";
    }
    
}
