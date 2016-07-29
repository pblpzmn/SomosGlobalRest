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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPerId", query = "SELECT p FROM Persona p WHERE p.perId = :perId"),
    @NamedQuery(name = "Persona.findByPerApellidos", query = "SELECT p FROM Persona p WHERE p.perApellidos = :perApellidos"),
    @NamedQuery(name = "Persona.findByPerFoto", query = "SELECT p FROM Persona p WHERE p.perFoto = :perFoto"),
    @NamedQuery(name = "Persona.findByPerEmail", query = "SELECT p FROM Persona p WHERE p.perEmail = :perEmail"),
    @NamedQuery(name = "Persona.findByPerFecNac", query = "SELECT p FROM Persona p WHERE p.perFecNac = :perFecNac"),
    @NamedQuery(name = "Persona.findByPerNombres", query = "SELECT p FROM Persona p WHERE p.perNombres = :perNombres"),
    @NamedQuery(name = "Persona.findByPerSexo", query = "SELECT p FROM Persona p WHERE p.perSexo = :perSexo"),
    @NamedQuery(name = "Persona.findByPerCedRucPas", query = "SELECT p FROM Persona p WHERE p.perCedRucPas = :perCedRucPas"),
    @NamedQuery(name = "Persona.findByPerEstado", query = "SELECT p FROM Persona p WHERE p.perEstado = :perEstado")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id")
    private Integer perId;
    @Size(max = 255)
    @Column(name = "per_apellidos")
    private String perApellidos;
    @Size(max = 255)
    @Column(name = "per_foto")
    private String perFoto;
    @Size(max = 255)
    @Column(name = "per_email")
    private String perEmail;
    @Column(name = "per_fec_nac")
    @Temporal(TemporalType.DATE)
    private Date perFecNac;
    @Size(max = 255)
    @Column(name = "per_nombres")
    private String perNombres;
    @Column(name = "per_sexo")
    private Integer perSexo;
    @Size(max = 25)
    @Column(name = "per_ced_ruc_pas")
    private String perCedRucPas;
    @Size(max = 3)
    @Column(name = "per_estado")
    private String perEstado;
    @OneToMany(mappedBy = "perId")
    private Collection<LocalVenta> localVentaCollection;

    public Persona() {
    }

    public Persona(Integer perId) {
        this.perId = perId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerFoto() {
        return perFoto;
    }

    public void setPerFoto(String perFoto) {
        this.perFoto = perFoto;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public Date getPerFecNac() {
        return perFecNac;
    }

    public void setPerFecNac(Date perFecNac) {
        this.perFecNac = perFecNac;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public Integer getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(Integer perSexo) {
        this.perSexo = perSexo;
    }

    public String getPerCedRucPas() {
        return perCedRucPas;
    }

    public void setPerCedRucPas(String perCedRucPas) {
        this.perCedRucPas = perCedRucPas;
    }

    public String getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(String perEstado) {
        this.perEstado = perEstado;
    }

    @XmlTransient
    public Collection<LocalVenta> getLocalVentaCollection() {
        return localVentaCollection;
    }

    public void setLocalVentaCollection(Collection<LocalVenta> localVentaCollection) {
        this.localVentaCollection = localVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.rest.Persona[ perId=" + perId + " ]";
    }
    
}
