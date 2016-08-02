/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.entities;

import java.io.Serializable;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsrId", query = "SELECT u FROM Usuario u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "Usuario.findByUsrEstado", query = "SELECT u FROM Usuario u WHERE u.usrEstado = :usrEstado"),
    @NamedQuery(name = "Usuario.findByUsrPassword", query = "SELECT u FROM Usuario u WHERE u.usrPassword = :usrPassword"),
    @NamedQuery(name = "Usuario.findByUsrNombre", query = "SELECT u FROM Usuario u WHERE u.usrNombre = :usrNombre"),
    @NamedQuery(name = "Usuario.findByUsrFecCrea", query = "SELECT u FROM Usuario u WHERE u.usrFecCrea = :usrFecCrea"),
    @NamedQuery(name = "Usuario.findByUsrFecMod", query = "SELECT u FROM Usuario u WHERE u.usrFecMod = :usrFecMod"),
    @NamedQuery(name = "Usuario.findByUsrCreadoPor", query = "SELECT u FROM Usuario u WHERE u.usrCreadoPor = :usrCreadoPor"),
    @NamedQuery(name = "Usuario.findByUsrModPor", query = "SELECT u FROM Usuario u WHERE u.usrModPor = :usrModPor"),
    @NamedQuery(name = "Usuario.findByUsrNombre2", query = "SELECT u FROM Usuario u WHERE u.usrNombre2 = :usrNombre2"),
    @NamedQuery(name = "Usuario.findByUsrCambiaPassword", query = "SELECT u FROM Usuario u WHERE u.usrCambiaPassword = :usrCambiaPassword")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer usrId;
    @Size(max = 3)
    @Column(name = "usr_estado")
    private String usrEstado;
    @Size(max = 255)
    @Column(name = "usr_password")
    private String usrPassword;
    @Size(max = 50)
    @Column(name = "usr_nombre")
    private String usrNombre;
    @Column(name = "usr_fec_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFecCrea;
    @Column(name = "usr_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFecMod;
    @Size(max = 25)
    @Column(name = "usr_creado_por")
    private String usrCreadoPor;
    @Size(max = 25)
    @Column(name = "usr_mod_por")
    private String usrModPor;
    @Size(max = 100)
    @Column(name = "usr_nombre2")
    private String usrNombre2;
    @Size(max = 1)
    @Column(name = "usr_cambia_password")
    private String usrCambiaPassword;
    @JoinColumn(name = "id_act", referencedColumnName = "id_act")
    @ManyToOne
    private Actor idAct;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id")
    @ManyToOne(optional = false)
    private Perfil prfId;

    public Usuario() {
    }

    public Usuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(String usrEstado) {
        this.usrEstado = usrEstado;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public Date getUsrFecCrea() {
        return usrFecCrea;
    }

    public void setUsrFecCrea(Date usrFecCrea) {
        this.usrFecCrea = usrFecCrea;
    }

    public Date getUsrFecMod() {
        return usrFecMod;
    }

    public void setUsrFecMod(Date usrFecMod) {
        this.usrFecMod = usrFecMod;
    }

    public String getUsrCreadoPor() {
        return usrCreadoPor;
    }

    public void setUsrCreadoPor(String usrCreadoPor) {
        this.usrCreadoPor = usrCreadoPor;
    }

    public String getUsrModPor() {
        return usrModPor;
    }

    public void setUsrModPor(String usrModPor) {
        this.usrModPor = usrModPor;
    }

    public String getUsrNombre2() {
        return usrNombre2;
    }

    public void setUsrNombre2(String usrNombre2) {
        this.usrNombre2 = usrNombre2;
    }

    public String getUsrCambiaPassword() {
        return usrCambiaPassword;
    }

    public void setUsrCambiaPassword(String usrCambiaPassword) {
        this.usrCambiaPassword = usrCambiaPassword;
    }

    public Actor getIdAct() {
        return idAct;
    }

    public void setIdAct(Actor idAct) {
        this.idAct = idAct;
    }

    public Perfil getPrfId() {
        return prfId;
    }

    public void setPrfId(Perfil prfId) {
        this.prfId = prfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.somosglobal.entities.Usuario[ usrId=" + usrId + " ]";
    }
    
}
