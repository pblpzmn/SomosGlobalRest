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
import javax.persistence.Id;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findCategoriaPadre", query = "SELECT c FROM Categoria c  WHERE LENGTH(c.catId) =2 "),//, LENGTH(c.catId) as longitud
    @NamedQuery(name = "Categoria.findSubCategoriaNivel1", query = "SELECT c FROM Categoria c  WHERE LENGTH(c.catId) =4 "),//, LENGTH(c.catId) as longitud
    @NamedQuery(name = "Categoria.findSubCategoriaNivel2", query = "SELECT c FROM Categoria c  WHERE LENGTH(c.catId) =6 "),//, LENGTH(c.catId) as longitud
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCatId", query = "SELECT c FROM Categoria c WHERE c.catId = :catId"),
    @NamedQuery(name = "Categoria.findByCatEstado", query = "SELECT c FROM Categoria c WHERE c.catEstado = :catEstado"),
    @NamedQuery(name = "Categoria.findByCatNombre", query = "SELECT c FROM Categoria c WHERE c.catNombre = :catNombre"),
    @NamedQuery(name = "Categoria.findByCatImagen", query = "SELECT c FROM Categoria c WHERE c.catImagen = :catImagen")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cat_id")
    private String catId;
    @Size(max = 3)
    @Column(name = "cat_estado")
    private String catEstado;
    @Size(max = 100)
    @Column(name = "cat_nombre")
    private String catNombre;
    @Size(max = 25)
    @Column(name = "cat_imagen")
    private String catImagen;
    @OneToMany(mappedBy = "catId")
    private Collection<Actor> actorCollection;

    public Categoria() {
    }

    public Categoria(String catId) {
        this.catId = catId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatEstado() {
        return catEstado;
    }

    public void setCatEstado(String catEstado) {
        this.catEstado = catEstado;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatImagen() {
        return catImagen;
    }

    public void setCatImagen(String catImagen) {
        this.catImagen = catImagen;
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
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.Categoria[ catId=" + catId + " ]";
    }
    
}
