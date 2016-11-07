///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.somosglobal.entities;
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Paflo
// */
//@Entity
//@Table(name = "hobbie")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Hobbie.findAll", query = "SELECT h FROM Hobbie h"),
//    @NamedQuery(name = "Hobbie.findByHobId", query = "SELECT h FROM Hobbie h WHERE h.hobId = :hobId"),
//    @NamedQuery(name = "Hobbie.findByHobEstado", query = "SELECT h FROM Hobbie h WHERE h.hobEstado = :hobEstado"),
//    @NamedQuery(name = "Hobbie.findByHobNombre", query = "SELECT h FROM Hobbie h WHERE h.hobNombre = :hobNombre")})
//public class Hobbie implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "hob_id")
//    private Integer hobId;
//    @Size(max = 3)
//    @Column(name = "hob_estado")
//    private String hobEstado;
//    @Size(max = 255)
//    @Column(name = "hob_nombre")
//    private String hobNombre;
//
//    public Hobbie() {
//    }
//
//    public Hobbie(Integer hobId) {
//        this.hobId = hobId;
//    }
//
//    public Integer getHobId() {
//        return hobId;
//    }
//
//    public void setHobId(Integer hobId) {
//        this.hobId = hobId;
//    }
//
//    public String getHobEstado() {
//        return hobEstado;
//    }
//
//    public void setHobEstado(String hobEstado) {
//        this.hobEstado = hobEstado;
//    }
//
//    public String getHobNombre() {
//        return hobNombre;
//    }
//
//    public void setHobNombre(String hobNombre) {
//        this.hobNombre = hobNombre;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (hobId != null ? hobId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Hobbie)) {
//            return false;
//        }
//        Hobbie other = (Hobbie) object;
//        if ((this.hobId == null && other.hobId != null) || (this.hobId != null && !this.hobId.equals(other.hobId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.somosglobal.entities.Hobbie[ hobId=" + hobId + " ]";
//    }
//    
//}
