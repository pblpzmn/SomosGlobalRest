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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b"),
    @NamedQuery(name = "Barrio.findByBarId", query = "SELECT b FROM Barrio b WHERE b.barId = :barId"),
    @NamedQuery(name = "Barrio.findByBarNombre", query = "SELECT b FROM Barrio b WHERE b.barNombre = :barNombre")})
public class Barrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bar_id")
    private Integer barId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bar_nombre")
    private String barNombre;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id")
    @ManyToOne(optional = false)
    private Ciudad ciuId;
    @OneToMany(mappedBy = "barId")
    private Collection<Ubicacion> ubicacionCollection;

    public Barrio() {
    }

    public Barrio(Integer barId) {
        this.barId = barId;
    }

    public Barrio(Integer barId, String barNombre) {
        this.barId = barId;
        this.barNombre = barNombre;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public String getBarNombre() {
        return barNombre;
    }

    public void setBarNombre(String barNombre) {
        this.barNombre = barNombre;
    }

    public Ciudad getCiuId() {
        return ciuId;
    }

    public void setCiuId(Ciudad ciuId) {
        this.ciuId = ciuId;
    }

    @XmlTransient
    public Collection<Ubicacion> getUbicacionCollection() {
        return ubicacionCollection;
    }

    public void setUbicacionCollection(Collection<Ubicacion> ubicacionCollection) {
        this.ubicacionCollection = ubicacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barId != null ? barId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.barId == null && other.barId != null) || (this.barId != null && !this.barId.equals(other.barId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.Barrio[ barId=" + barId + " ]";
    }
    
}
