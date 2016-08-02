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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paflo
 */
@Entity
@Table(name = "texto_clave")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TextoClave.findAll", query = "SELECT t FROM TextoClave t"),
    @NamedQuery(name = "TextoClave.findByTcId", query = "SELECT t FROM TextoClave t WHERE t.tcId = :tcId"),
    @NamedQuery(name = "TextoClave.findByTcTexto", query = "SELECT t FROM TextoClave t WHERE t.tcTexto = :tcTexto"),
    @NamedQuery(name = "TextoClave.findByTcTipo", query = "SELECT t FROM TextoClave t WHERE t.tcTipo = :tcTipo"),
    @NamedQuery(name = "TextoClave.findByTcEstado", query = "SELECT t FROM TextoClave t WHERE t.tcEstado = :tcEstado")})
public class TextoClave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tc_id")
    private Integer tcId;
    @Size(max = 255)
    @Column(name = "tc_texto")
    private String tcTexto;
    @Size(max = 3)
    @Column(name = "tc_tipo")
    private String tcTipo;
    @Size(max = 3)
    @Column(name = "tc_estado")
    private String tcEstado;

    public TextoClave() {
    }

    public TextoClave(Integer tcId) {
        this.tcId = tcId;
    }

    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
    }

    public String getTcTexto() {
        return tcTexto;
    }

    public void setTcTexto(String tcTexto) {
        this.tcTexto = tcTexto;
    }

    public String getTcTipo() {
        return tcTipo;
    }

    public void setTcTipo(String tcTipo) {
        this.tcTipo = tcTipo;
    }

    public String getTcEstado() {
        return tcEstado;
    }

    public void setTcEstado(String tcEstado) {
        this.tcEstado = tcEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcId != null ? tcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TextoClave)) {
            return false;
        }
        TextoClave other = (TextoClave) object;
        if ((this.tcId == null && other.tcId != null) || (this.tcId != null && !this.tcId.equals(other.tcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.TextoClave[ tcId=" + tcId + " ]";
    }
    
}
