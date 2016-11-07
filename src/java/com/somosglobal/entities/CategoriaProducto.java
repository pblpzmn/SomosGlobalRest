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
//@Table(name = "categoria_producto")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c"),
//    @NamedQuery(name = "CategoriaProducto.findByCpId", query = "SELECT c FROM CategoriaProducto c WHERE c.cpId = :cpId"),
//    @NamedQuery(name = "CategoriaProducto.findByCpDescripcion", query = "SELECT c FROM CategoriaProducto c WHERE c.cpDescripcion = :cpDescripcion"),
//    @NamedQuery(name = "CategoriaProducto.findByCpEstado", query = "SELECT c FROM CategoriaProducto c WHERE c.cpEstado = :cpEstado"),
//    @NamedQuery(name = "CategoriaProducto.findByCpNombre", query = "SELECT c FROM CategoriaProducto c WHERE c.cpNombre = :cpNombre"),
//    @NamedQuery(name = "CategoriaProducto.findByCpIdPadre", query = "SELECT c FROM CategoriaProducto c WHERE c.cpIdPadre = :cpIdPadre")})
//public class CategoriaProducto implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "cp_id")
//    private Integer cpId;
//    @Size(max = 255)
//    @Column(name = "cp_descripcion")
//    private String cpDescripcion;
//    @Column(name = "cp_estado")
//    private Integer cpEstado;
//    @Size(max = 255)
//    @Column(name = "cp_nombre")
//    private String cpNombre;
//    @Column(name = "cp_id_padre")
//    private Integer cpIdPadre;
//
//    public CategoriaProducto() {
//    }
//
//    public CategoriaProducto(Integer cpId) {
//        this.cpId = cpId;
//    }
//
//    public Integer getCpId() {
//        return cpId;
//    }
//
//    public void setCpId(Integer cpId) {
//        this.cpId = cpId;
//    }
//
//    public String getCpDescripcion() {
//        return cpDescripcion;
//    }
//
//    public void setCpDescripcion(String cpDescripcion) {
//        this.cpDescripcion = cpDescripcion;
//    }
//
//    public Integer getCpEstado() {
//        return cpEstado;
//    }
//
//    public void setCpEstado(Integer cpEstado) {
//        this.cpEstado = cpEstado;
//    }
//
//    public String getCpNombre() {
//        return cpNombre;
//    }
//
//    public void setCpNombre(String cpNombre) {
//        this.cpNombre = cpNombre;
//    }
//
//    public Integer getCpIdPadre() {
//        return cpIdPadre;
//    }
//
//    public void setCpIdPadre(Integer cpIdPadre) {
//        this.cpIdPadre = cpIdPadre;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (cpId != null ? cpId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CategoriaProducto)) {
//            return false;
//        }
//        CategoriaProducto other = (CategoriaProducto) object;
//        if ((this.cpId == null && other.cpId != null) || (this.cpId != null && !this.cpId.equals(other.cpId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.somosglobal.entities.CategoriaProducto[ cpId=" + cpId + " ]";
//    }
//    
//}
