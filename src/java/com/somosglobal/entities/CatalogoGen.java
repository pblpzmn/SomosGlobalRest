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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "catalogo_gen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoGen.findAll", query = "SELECT c FROM CatalogoGen c"),
    @NamedQuery(name = "CatalogoGen.findByIdCg", query = "SELECT c FROM CatalogoGen c WHERE c.idCg = :idCg"),
    @NamedQuery(name = "CatalogoGen.findByTipoCg", query = "SELECT c FROM CatalogoGen c WHERE c.tipoCg = :tipoCg"),
    @NamedQuery(name = "CatalogoGen.findByNombreCg", query = "SELECT c FROM CatalogoGen c WHERE c.nombreCg = :nombreCg"),
    @NamedQuery(name = "CatalogoGen.findByRefCg", query = "SELECT c FROM CatalogoGen c WHERE c.refCg = :refCg"),
    @NamedQuery(name = "CatalogoGen.findByUsrCreaCg", query = "SELECT c FROM CatalogoGen c WHERE c.usrCreaCg = :usrCreaCg"),
    @NamedQuery(name = "CatalogoGen.findByUsrModCg", query = "SELECT c FROM CatalogoGen c WHERE c.usrModCg = :usrModCg"),
    @NamedQuery(name = "CatalogoGen.findByFecCreaCg", query = "SELECT c FROM CatalogoGen c WHERE c.fecCreaCg = :fecCreaCg"),
    @NamedQuery(name = "CatalogoGen.findByFecModCg", query = "SELECT c FROM CatalogoGen c WHERE c.fecModCg = :fecModCg"),
    @NamedQuery(name = "CatalogoGen.findByRef02Cg", query = "SELECT c FROM CatalogoGen c WHERE c.ref02Cg = :ref02Cg")})
public class CatalogoGen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cg")
    private Integer idCg;
    @Size(max = 2)
    @Column(name = "tipo_cg")
    private String tipoCg;
    @Size(max = 50)
    @Column(name = "nombre_cg")
    private String nombreCg;
    @Size(max = 50)
    @Column(name = "ref_cg")
    private String refCg;
    @Size(max = 25)
    @Column(name = "usr_crea_cg")
    private String usrCreaCg;
    @Size(max = 25)
    @Column(name = "usr_mod_cg")
    private String usrModCg;
    @Column(name = "fec_crea_cg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreaCg;
    @Column(name = "fec_mod_cg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModCg;
    @Size(max = 25)
    @Column(name = "ref02_cg")
    private String ref02Cg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCg")
    private Collection<ActorReferencia> actorReferenciaCollection;
    @OneToMany(mappedBy = "idCgPadre")
    private Collection<CatalogoGen> catalogoGenCollection;
    @JoinColumn(name = "id_cg_padre", referencedColumnName = "id_cg")
    @ManyToOne
    private CatalogoGen idCgPadre;
    @OneToMany(mappedBy = "idCg")
    private Collection<ActorRol> actorRolCollection;

    public CatalogoGen() {
    }

    public CatalogoGen(Integer idCg) {
        this.idCg = idCg;
    }

    public Integer getIdCg() {
        return idCg;
    }

    public void setIdCg(Integer idCg) {
        this.idCg = idCg;
    }

    public String getTipoCg() {
        return tipoCg;
    }

    public void setTipoCg(String tipoCg) {
        this.tipoCg = tipoCg;
    }

    public String getNombreCg() {
        return nombreCg;
    }

    public void setNombreCg(String nombreCg) {
        this.nombreCg = nombreCg;
    }

    public String getRefCg() {
        return refCg;
    }

    public void setRefCg(String refCg) {
        this.refCg = refCg;
    }

    public String getUsrCreaCg() {
        return usrCreaCg;
    }

    public void setUsrCreaCg(String usrCreaCg) {
        this.usrCreaCg = usrCreaCg;
    }

    public String getUsrModCg() {
        return usrModCg;
    }

    public void setUsrModCg(String usrModCg) {
        this.usrModCg = usrModCg;
    }

    public Date getFecCreaCg() {
        return fecCreaCg;
    }

    public void setFecCreaCg(Date fecCreaCg) {
        this.fecCreaCg = fecCreaCg;
    }

    public Date getFecModCg() {
        return fecModCg;
    }

    public void setFecModCg(Date fecModCg) {
        this.fecModCg = fecModCg;
    }

    public String getRef02Cg() {
        return ref02Cg;
    }

    public void setRef02Cg(String ref02Cg) {
        this.ref02Cg = ref02Cg;
    }

    @XmlTransient
    public Collection<ActorReferencia> getActorReferenciaCollection() {
        return actorReferenciaCollection;
    }

    public void setActorReferenciaCollection(Collection<ActorReferencia> actorReferenciaCollection) {
        this.actorReferenciaCollection = actorReferenciaCollection;
    }

    @XmlTransient
    public Collection<CatalogoGen> getCatalogoGenCollection() {
        return catalogoGenCollection;
    }

    public void setCatalogoGenCollection(Collection<CatalogoGen> catalogoGenCollection) {
        this.catalogoGenCollection = catalogoGenCollection;
    }

    public CatalogoGen getIdCgPadre() {
        return idCgPadre;
    }

    public void setIdCgPadre(CatalogoGen idCgPadre) {
        this.idCgPadre = idCgPadre;
    }

    @XmlTransient
    public Collection<ActorRol> getActorRolCollection() {
        return actorRolCollection;
    }

    public void setActorRolCollection(Collection<ActorRol> actorRolCollection) {
        this.actorRolCollection = actorRolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCg != null ? idCg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoGen)) {
            return false;
        }
        CatalogoGen other = (CatalogoGen) object;
        if ((this.idCg == null && other.idCg != null) || (this.idCg != null && !this.idCg.equals(other.idCg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.CatalogoGen[ idCg=" + idCg + " ]";
    }
    
}
