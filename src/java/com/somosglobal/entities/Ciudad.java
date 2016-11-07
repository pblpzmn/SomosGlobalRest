///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.somosglobal.entities;
//
//import java.io.Serializable;
//import java.util.Collection;
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;
//
///**
// *
// * @author Paflo
// */
//@Entity
//@Table(name = "ciudad")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
//    @NamedQuery(name = "Ciudad.findByCiuId", query = "SELECT c FROM Ciudad c WHERE c.ciuId = :ciuId"),
//    @NamedQuery(name = "Ciudad.findByCiuNombre", query = "SELECT c FROM Ciudad c WHERE c.ciuNombre = :ciuNombre")})
//public class Ciudad implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "ciu_id")
//    private Integer ciuId;
//    @Size(max = 255)
//    @Column(name = "ciu_nombre")
//    private String ciuNombre;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciuId")
//    private Collection<Barrio> barrioCollection;
//    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
//    @ManyToOne
//    private Provincia prvId;
//
//    public Ciudad() {
//    }
//
//    public Ciudad(Integer ciuId) {
//        this.ciuId = ciuId;
//    }
//
//    public Integer getCiuId() {
//        return ciuId;
//    }
//
//    public void setCiuId(Integer ciuId) {
//        this.ciuId = ciuId;
//    }
//
//    public String getCiuNombre() {
//        return ciuNombre;
//    }
//
//    public void setCiuNombre(String ciuNombre) {
//        this.ciuNombre = ciuNombre;
//    }
//
//    @XmlTransient
//    public Collection<Barrio> getBarrioCollection() {
//        return barrioCollection;
//    }
//
//    public void setBarrioCollection(Collection<Barrio> barrioCollection) {
//        this.barrioCollection = barrioCollection;
//    }
//
//    public Provincia getPrvId() {
//        return prvId;
//    }
//
//    public void setPrvId(Provincia prvId) {
//        this.prvId = prvId;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (ciuId != null ? ciuId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Ciudad)) {
//            return false;
//        }
//        Ciudad other = (Ciudad) object;
//        if ((this.ciuId == null && other.ciuId != null) || (this.ciuId != null && !this.ciuId.equals(other.ciuId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.somosglobal.entities.Ciudad[ ciuId=" + ciuId + " ]";
//    }
//    
//}
