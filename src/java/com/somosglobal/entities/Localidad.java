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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByLocId", query = "SELECT l FROM Localidad l WHERE l.locId = :locId"),
    @NamedQuery(name = "Localidad.findByLocNombre", query = "SELECT l FROM Localidad l WHERE l.locNombre = :locNombre"),
    @NamedQuery(name = "Localidad.findByLocEstado", query = "SELECT l FROM Localidad l WHERE l.locEstado = :locEstado")})
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loc_id")
    private Integer locId;
    @Size(max = 50)
    @Column(name = "loc_nombre")
    private String locNombre;
    @Size(max = 3)
    @Column(name = "loc_estado")
    private String locEstado;
    @OneToMany(mappedBy = "locId")
    private Collection<Actor> actorCollection;
    @OneToMany(mappedBy = "locIdPadre")
    private Collection<Localidad> localidadCollection;
    @JoinColumn(name = "loc_id_padre", referencedColumnName = "loc_id")
    @ManyToOne
    private Localidad locIdPadre;

    public Localidad() {
    }

    public Localidad(Integer locId) {
        this.locId = locId;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public String getLocNombre() {
        return locNombre;
    }

    public void setLocNombre(String locNombre) {
        this.locNombre = locNombre;
    }

    public String getLocEstado() {
        return locEstado;
    }

    public void setLocEstado(String locEstado) {
        this.locEstado = locEstado;
    }

    @XmlTransient
    public Collection<Actor> getActorCollection() {
        return actorCollection;
    }

    public void setActorCollection(Collection<Actor> actorCollection) {
        this.actorCollection = actorCollection;
    }

    @XmlTransient
    public Collection<Localidad> getLocalidadCollection() {
        return localidadCollection;
    }

    public void setLocalidadCollection(Collection<Localidad> localidadCollection) {
        this.localidadCollection = localidadCollection;
    }

    public Localidad getLocIdPadre() {
        return locIdPadre;
    }

    public void setLocIdPadre(Localidad locIdPadre) {
        this.locIdPadre = locIdPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.Localidad[ locId=" + locId + " ]";
    }
    
}
