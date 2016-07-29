/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByPrfId", query = "SELECT p FROM Perfil p WHERE p.prfId = :prfId"),
    @NamedQuery(name = "Perfil.findByPrfNombre", query = "SELECT p FROM Perfil p WHERE p.prfNombre = :prfNombre"),
    @NamedQuery(name = "Perfil.findByPrfEstado", query = "SELECT p FROM Perfil p WHERE p.prfEstado = :prfEstado"),
    @NamedQuery(name = "Perfil.findByPrfCodigo", query = "SELECT p FROM Perfil p WHERE p.prfCodigo = :prfCodigo")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prf_id")
    private Integer prfId;
    @Size(max = 255)
    @Column(name = "prf_nombre")
    private String prfNombre;
    @Size(max = 3)
    @Column(name = "prf_estado")
    private String prfEstado;
    @Size(max = 2)
    @Column(name = "prf_codigo")
    private String prfCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prfId")
    private Collection<Usuario> usuarioCollection;

    public Perfil() {
    }

    public Perfil(Integer prfId) {
        this.prfId = prfId;
    }

    public Integer getPrfId() {
        return prfId;
    }

    public void setPrfId(Integer prfId) {
        this.prfId = prfId;
    }

    public String getPrfNombre() {
        return prfNombre;
    }

    public void setPrfNombre(String prfNombre) {
        this.prfNombre = prfNombre;
    }

    public String getPrfEstado() {
        return prfEstado;
    }

    public void setPrfEstado(String prfEstado) {
        this.prfEstado = prfEstado;
    }

    public String getPrfCodigo() {
        return prfCodigo;
    }

    public void setPrfCodigo(String prfCodigo) {
        this.prfCodigo = prfCodigo;
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
        hash += (prfId != null ? prfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.prfId == null && other.prfId != null) || (this.prfId != null && !this.prfId.equals(other.prfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.Perfil[ prfId=" + prfId + " ]";
    }
    
}
