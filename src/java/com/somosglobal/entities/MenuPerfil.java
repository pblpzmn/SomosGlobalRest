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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "menu_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuPerfil.findAll", query = "SELECT m FROM MenuPerfil m"),
    @NamedQuery(name = "MenuPerfil.findByMpId", query = "SELECT m FROM MenuPerfil m WHERE m.mpId = :mpId")})
public class MenuPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mp_id")
    private Integer mpId;
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne
    private Menu menId;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id")
    @ManyToOne
    private Perfil prfId;

    public MenuPerfil() {
    }

    public MenuPerfil(Integer mpId) {
        this.mpId = mpId;
    }

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public Menu getMenId() {
        return menId;
    }

    public void setMenId(Menu menId) {
        this.menId = menId;
    }

    public Perfil getPrfId() {
        return prfId;
    }

    public void setPrfId(Perfil prfId) {
        this.prfId = prfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mpId != null ? mpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuPerfil)) {
            return false;
        }
        MenuPerfil other = (MenuPerfil) object;
        if ((this.mpId == null && other.mpId != null) || (this.mpId != null && !this.mpId.equals(other.mpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.MenuPerfil[ mpId=" + mpId + " ]";
    }
    
}
