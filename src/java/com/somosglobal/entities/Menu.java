/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenId", query = "SELECT m FROM Menu m WHERE m.menId = :menId"),
    @NamedQuery(name = "Menu.findByMenEstado", query = "SELECT m FROM Menu m WHERE m.menEstado = :menEstado"),
    @NamedQuery(name = "Menu.findByMenNombre", query = "SELECT m FROM Menu m WHERE m.menNombre = :menNombre"),
    @NamedQuery(name = "Menu.findByMenTipo", query = "SELECT m FROM Menu m WHERE m.menTipo = :menTipo"),
    @NamedQuery(name = "Menu.findByMenUrl", query = "SELECT m FROM Menu m WHERE m.menUrl = :menUrl")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "men_id")
    private Integer menId;
    @Size(max = 3)
    @Column(name = "men_estado")
    private String menEstado;
    @Size(max = 255)
    @Column(name = "men_nombre")
    private String menNombre;
    @Size(max = 255)
    @Column(name = "men_tipo")
    private String menTipo;
    @Size(max = 255)
    @Column(name = "men_url")
    private String menUrl;
    @OneToMany(mappedBy = "menId")
    private Collection<MenuPerfil> menuPerfilCollection;

    public Menu() {
    }

    public Menu(Integer menId) {
        this.menId = menId;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenEstado() {
        return menEstado;
    }

    public void setMenEstado(String menEstado) {
        this.menEstado = menEstado;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenTipo() {
        return menTipo;
    }

    public void setMenTipo(String menTipo) {
        this.menTipo = menTipo;
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    @XmlTransient
    public Collection<MenuPerfil> getMenuPerfilCollection() {
        return menuPerfilCollection;
    }

    public void setMenuPerfilCollection(Collection<MenuPerfil> menuPerfilCollection) {
        this.menuPerfilCollection = menuPerfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.Menu[ menId=" + menId + " ]";
    }
    
}
