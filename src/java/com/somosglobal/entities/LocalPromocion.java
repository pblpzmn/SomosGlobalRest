/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "local_promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalPromocion.findAll", query = "SELECT l FROM LocalPromocion l"),
    @NamedQuery(name = "LocalPromocion.findByLpId", query = "SELECT l FROM LocalPromocion l WHERE l.lpId = :lpId"),
    @NamedQuery(name = "LocalPromocion.findByLpImagen", query = "SELECT l FROM LocalPromocion l WHERE l.lpImagen = :lpImagen"),
    @NamedQuery(name = "LocalPromocion.findByLpDetalle", query = "SELECT l FROM LocalPromocion l WHERE l.lpDetalle = :lpDetalle"),
    @NamedQuery(name = "LocalPromocion.findByLpUsrCrea", query = "SELECT l FROM LocalPromocion l WHERE l.lpUsrCrea = :lpUsrCrea"),
    @NamedQuery(name = "LocalPromocion.findByLpUsrModif", query = "SELECT l FROM LocalPromocion l WHERE l.lpUsrModif = :lpUsrModif"),
    @NamedQuery(name = "LocalPromocion.findByLpFecCrea", query = "SELECT l FROM LocalPromocion l WHERE l.lpFecCrea = :lpFecCrea"),
    @NamedQuery(name = "LocalPromocion.findByLpEstado", query = "SELECT l FROM LocalPromocion l WHERE l.lpEstado = :lpEstado"),
    @NamedQuery(name = "LocalPromocion.findByLpTipo", query = "SELECT l FROM LocalPromocion l WHERE l.lpTipo = :lpTipo")})
public class LocalPromocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lp_id")
    private Integer lpId;
    @Size(max = 50)
    @Column(name = "lp_imagen")
    private String lpImagen;
    @Size(max = 25)
    @Column(name = "lp_detalle")
    private String lpDetalle;
    @Size(max = 25)
    @Column(name = "lp_usr_crea")
    private String lpUsrCrea;
    @Size(max = 25)
    @Column(name = "lp_usr_modif")
    private String lpUsrModif;
    @Column(name = "lp_fec_crea")
    @Temporal(TemporalType.DATE)
    private Date lpFecCrea;
    @Size(max = 3)
    @Column(name = "lp_estado")
    private String lpEstado;
    @Size(max = 2)
    @Column(name = "lp_tipo")
    private String lpTipo;
    @JoinColumn(name = "lv_id", referencedColumnName = "lv_id")
    @ManyToOne
    private LocalVenta lvId;

    public LocalPromocion() {
    }

    public LocalPromocion(Integer lpId) {
        this.lpId = lpId;
    }

    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    public String getLpImagen() {
        return lpImagen;
    }

    public void setLpImagen(String lpImagen) {
        this.lpImagen = lpImagen;
    }

    public String getLpDetalle() {
        return lpDetalle;
    }

    public void setLpDetalle(String lpDetalle) {
        this.lpDetalle = lpDetalle;
    }

    public String getLpUsrCrea() {
        return lpUsrCrea;
    }

    public void setLpUsrCrea(String lpUsrCrea) {
        this.lpUsrCrea = lpUsrCrea;
    }

    public String getLpUsrModif() {
        return lpUsrModif;
    }

    public void setLpUsrModif(String lpUsrModif) {
        this.lpUsrModif = lpUsrModif;
    }

    public Date getLpFecCrea() {
        return lpFecCrea;
    }

    public void setLpFecCrea(Date lpFecCrea) {
        this.lpFecCrea = lpFecCrea;
    }

    public String getLpEstado() {
        return lpEstado;
    }

    public void setLpEstado(String lpEstado) {
        this.lpEstado = lpEstado;
    }

    public String getLpTipo() {
        return lpTipo;
    }

    public void setLpTipo(String lpTipo) {
        this.lpTipo = lpTipo;
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
        hash += (lpId != null ? lpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalPromocion)) {
            return false;
        }
        LocalPromocion other = (LocalPromocion) object;
        if ((this.lpId == null && other.lpId != null) || (this.lpId != null && !this.lpId.equals(other.lpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.LocalPromocion[ lpId=" + lpId + " ]";
    }
    
}
