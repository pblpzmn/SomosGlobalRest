/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.rest.service;

import com.somosglobal.entities.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Paflo
 */
@Stateless
@Path("com.somosglobal.rest.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SomosGlobalPU")
    private EntityManager em;

    @Inject
    private PerfilFacadeREST perfil;
    
    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createUser(Usuario entity) {
        String result = "Entidad nula";
        
        if (entity != null){
            Query q = em.createNamedQuery("Usuario.findByUsrNombreAndFbId");
            q.setParameter("usrNombre", entity.getUsrNombre());
            q.setParameter("usrFacebookCredencial", entity.getUsrFacebookCredencial());
            
            Usuario us = null;
            try{
                us = (Usuario) q.getSingleResult();
            }catch(Exception ex){
                System.err.println("error "+ ex);
            }
            if (us == null ){
                try {
                    MessageDigest mdEnc = MessageDigest.getInstance("MD5"); 
                    mdEnc.update(entity.getUsrPassword().getBytes(), 0, entity.getUsrPassword().length());
                    String passMd5 = new BigInteger(1, mdEnc.digest()).toString(16); 
                    entity.setUsrPassword(passMd5);
                    entity.setUsrFecCrea(new Date() );
                    entity.setUsrFecMod(new Date());
                    entity.setPrfId(perfil.findByCodigoPerfil("PC"));
                    super.create(entity);    
                    result = "User created";
                }catch( Exception ex){
                    System.err.println("error" + ex);    
                }
            }else{
                result = "User name already exits";
                System.err.println("User name already exits");
            }
        }
        return result;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public String jsonFind(@PathParam("id") Integer id) {
////        return objToJson(super.find(id));
//        
//        return objToJson( super.find(id) );
//        
//    }

    @GET
    @Path("usuario/{user}/{pass}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario findUserByNameAndPassword(@PathParam("user") String user, @PathParam("pass") String pass) {
//        String result = "false";
        String passMd5 = null;
        Usuario us = null; 
        try {
            MessageDigest mdEnc = MessageDigest.getInstance("MD5"); 
            mdEnc.update(pass.getBytes(), 0, pass.length());
            passMd5 = new BigInteger(1, mdEnc.digest()).toString(16); 
            
            if (user != null && passMd5 != null){
                try{
                    Query q = em.createNamedQuery("Usuario.findByNameAndPassword");
                    q.setParameter("usrNombre", user);
                    q.setParameter("usrPassword", passMd5 );
                    us = (Usuario) q.getSingleResult();
//                    result = "true";// user and pass matches
                }catch(Exception ex){
                    System.err.println("error "+ ex);
                }
            }
            
        }catch(Exception ex){
            System.err.println("error "+ ex);
        }
        
        return us;
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    /*
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String jsonFindAll() {
//        return objToJson( super.findAll() );
        Query q = em.createNamedQuery("Usuario.findAll");
        return objToJson( q.getResultList());
    }*/

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
