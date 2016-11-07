/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "puntos_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntosActor.findAll", query = "SELECT p FROM PuntosActor p"),
    @NamedQuery(name = "PuntosActor.findById", query = "SELECT p FROM PuntosActor p WHERE p.id = :id"),
    @NamedQuery(name = "PuntosActor.findByTotalPuntos", query = "SELECT p FROM PuntosActor p WHERE p.totalPuntos = :totalPuntos"),
    @NamedQuery(name = "PuntosActor.findByValor", query = "SELECT p FROM PuntosActor p WHERE p.valor = :valor"),
    @NamedQuery(name = "PuntosActor.findByVigDesde", query = "SELECT p FROM PuntosActor p WHERE p.vigDesde = :vigDesde"),
    @NamedQuery(name = "PuntosActor.findByVigHasta", query = "SELECT p FROM PuntosActor p WHERE p.vigHasta = :vigHasta"),
    @NamedQuery(name = "PuntosActor.findByNumDocumentoActor", query = "SELECT p FROM PuntosActor p WHERE p.numDocumentoActor = :numDocumentoActor")})
public class PuntosActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "total_puntos")
    private Integer totalPuntos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "vig_desde")
    @Temporal(TemporalType.DATE)
    private Date vigDesde;
    @Column(name = "vig_hasta")
    @Temporal(TemporalType.DATE)
    private Date vigHasta;
    @Size(max = 15)
    @Column(name = "num_documento_actor")
    private String numDocumentoActor;
    @JoinColumn(name = "id_actor", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idActor;

    public PuntosActor() {
    }

    public PuntosActor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(Integer totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getVigDesde() {
        return vigDesde;
    }

    public void setVigDesde(Date vigDesde) {
        this.vigDesde = vigDesde;
    }

    public Date getVigHasta() {
        return vigHasta;
    }

    public void setVigHasta(Date vigHasta) {
        this.vigHasta = vigHasta;
    }

    public String getNumDocumentoActor() {
        return numDocumentoActor;
    }

    public void setNumDocumentoActor(String numDocumentoActor) {
        this.numDocumentoActor = numDocumentoActor;
    }

    public Actor getIdActor() {
        return idActor;
    }

    public void setIdActor(Actor idActor) {
        this.idActor = idActor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntosActor)) {
            return false;
        }
        PuntosActor other = (PuntosActor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.PuntosActor[ id=" + id + " ]";
    }
    
}
