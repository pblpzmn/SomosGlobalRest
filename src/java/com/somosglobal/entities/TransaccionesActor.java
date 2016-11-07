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
@Table(name = "transacciones_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionesActor.findAll", query = "SELECT t FROM TransaccionesActor t"),
    @NamedQuery(name = "TransaccionesActor.findById", query = "SELECT t FROM TransaccionesActor t WHERE t.id = :id"),
    @NamedQuery(name = "TransaccionesActor.findByNumDocumentoActor", query = "SELECT t FROM TransaccionesActor t WHERE t.numDocumentoActor = :numDocumentoActor"),
    @NamedQuery(name = "TransaccionesActor.findByNumDocumentoBeneficiario", query = "SELECT t FROM TransaccionesActor t WHERE t.numDocumentoBeneficiario = :numDocumentoBeneficiario"),
    @NamedQuery(name = "TransaccionesActor.findByPuntosTransaccion", query = "SELECT t FROM TransaccionesActor t WHERE t.puntosTransaccion = :puntosTransaccion"),
    @NamedQuery(name = "TransaccionesActor.findByPuntosGanados", query = "SELECT t FROM TransaccionesActor t WHERE t.puntosGanados = :puntosGanados"),
    @NamedQuery(name = "TransaccionesActor.findByFechaTransaccion", query = "SELECT t FROM TransaccionesActor t WHERE t.fechaTransaccion = :fechaTransaccion"),
    @NamedQuery(name = "TransaccionesActor.findByValorCompra", query = "SELECT t FROM TransaccionesActor t WHERE t.valorCompra = :valorCompra"),
    @NamedQuery(name = "TransaccionesActor.findByPorcentajeDescuento", query = "SELECT t FROM TransaccionesActor t WHERE t.porcentajeDescuento = :porcentajeDescuento"),
    @NamedQuery(name = "TransaccionesActor.findByDescripcionCompra", query = "SELECT t FROM TransaccionesActor t WHERE t.descripcionCompra = :descripcionCompra")})
public class TransaccionesActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "num_documento_actor")
    private String numDocumentoActor;
    @Size(max = 15)
    @Column(name = "num_documento_beneficiario")
    private String numDocumentoBeneficiario;
    @Column(name = "puntos_transaccion")
    private Integer puntosTransaccion;
    @Column(name = "puntos_ganados")
    private Integer puntosGanados;
    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;
    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;
    @Size(max = 150)
    @Column(name = "descripcion_compra")
    private String descripcionCompra;
    @JoinColumn(name = "id_consumidor", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idConsumidor;
    @JoinColumn(name = "id_beneficiario", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idBeneficiario;
    @JoinColumn(name = "id_local", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idLocal;

    public TransaccionesActor() {
    }

    public TransaccionesActor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumDocumentoActor() {
        return numDocumentoActor;
    }

    public void setNumDocumentoActor(String numDocumentoActor) {
        this.numDocumentoActor = numDocumentoActor;
    }

    public String getNumDocumentoBeneficiario() {
        return numDocumentoBeneficiario;
    }

    public void setNumDocumentoBeneficiario(String numDocumentoBeneficiario) {
        this.numDocumentoBeneficiario = numDocumentoBeneficiario;
    }

    public Integer getPuntosTransaccion() {
        return puntosTransaccion;
    }

    public void setPuntosTransaccion(Integer puntosTransaccion) {
        this.puntosTransaccion = puntosTransaccion;
    }

    public Integer getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(Integer puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getDescripcionCompra() {
        return descripcionCompra;
    }

    public void setDescripcionCompra(String descripcionCompra) {
        this.descripcionCompra = descripcionCompra;
    }

    public Actor getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(Actor idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public Actor getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Actor idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public Actor getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Actor idLocal) {
        this.idLocal = idLocal;
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
        if (!(object instanceof TransaccionesActor)) {
            return false;
        }
        TransaccionesActor other = (TransaccionesActor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.TransaccionesActor[ id=" + id + " ]";
    }
    
}
