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
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Paflo
// */
//@Entity
//@Table(name = "parametros_gen")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ParametrosGen.findAll", query = "SELECT p FROM ParametrosGen p"),
//    @NamedQuery(name = "ParametrosGen.findByParCodigo", query = "SELECT p FROM ParametrosGen p WHERE p.parCodigo = :parCodigo"),
//    @NamedQuery(name = "ParametrosGen.findByParValor", query = "SELECT p FROM ParametrosGen p WHERE p.parValor = :parValor"),
//    @NamedQuery(name = "ParametrosGen.findByParDescripcion", query = "SELECT p FROM ParametrosGen p WHERE p.parDescripcion = :parDescripcion")})
//public class ParametrosGen implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 25)
//    @Column(name = "par_codigo")
//    private String parCodigo;
//    @Size(max = 255)
//    @Column(name = "par_valor")
//    private String parValor;
//    @Size(max = 255)
//    @Column(name = "par_descripcion")
//    private String parDescripcion;
//
//    public ParametrosGen() {
//    }
//
//    public ParametrosGen(String parCodigo) {
//        this.parCodigo = parCodigo;
//    }
//
//    public String getParCodigo() {
//        return parCodigo;
//    }
//
//    public void setParCodigo(String parCodigo) {
//        this.parCodigo = parCodigo;
//    }
//
//    public String getParValor() {
//        return parValor;
//    }
//
//    public void setParValor(String parValor) {
//        this.parValor = parValor;
//    }
//
//    public String getParDescripcion() {
//        return parDescripcion;
//    }
//
//    public void setParDescripcion(String parDescripcion) {
//        this.parDescripcion = parDescripcion;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (parCodigo != null ? parCodigo.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ParametrosGen)) {
//            return false;
//        }
//        ParametrosGen other = (ParametrosGen) object;
//        if ((this.parCodigo == null && other.parCodigo != null) || (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.somosglobal.entities.ParametrosGen[ parCodigo=" + parCodigo + " ]";
//    }
//    
//}
