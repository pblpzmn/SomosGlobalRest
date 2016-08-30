/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.rest.service;

import com.somosglobal.entities.Actor;
import com.somosglobal.entities.ActorReferencia;
import com.somosglobal.entities.CatalogoGen;
import java.util.ArrayList;
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
@Path("com.somosglobal.rest.actorreferencia")
public class ActorReferenciaFacadeREST extends AbstractFacade<ActorReferencia> {

    @PersistenceContext(unitName = "SomosGlobalPU")
    private EntityManager em;
    
    @Inject
    private CatalogoGenFacadeREST catalogo;
    
    @Inject
    private ActorFacadeREST actor;
    
    public ActorReferenciaFacadeREST() {
        super(ActorReferencia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ActorReferencia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ActorReferencia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("actorId/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ActorReferencia find(@PathParam("id") Integer id) {
        ActorReferencia actorRef = null;
        try{
            Actor foundActor = actor.find(id);
            List<CatalogoGen> catalogoList =  new ArrayList<>();
            catalogoList.add(catalogo.find(68));
            catalogoList.add(catalogo.find(76));
            catalogoList.add(catalogo.find(77));

    //        Query q = em.createNamedQuery("Actor.findByIdAct");
            Query q = em.createNamedQuery("ActorReferencia.findByIdActAndiNCatalogo");
            q.setParameter("idAct", foundActor) ;    
            q.setParameter("idCgList", catalogoList) ;        
            actorRef = (ActorReferencia) q.getSingleResult();
        }catch(Exception ex){
            System.err.println("error: " + ex);
        }
        return actorRef;
//        return super.find(id);
    }
    
    
    @GET
    @Path("searchNearShop/{longitude}/{latitude}/{distance}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActorReferencia> searchNearShop(@PathParam("longitude") double longitude, @PathParam("latitude") double latitude, @PathParam("distance") double distance) {
        List<ActorReferencia> returnActorReferencia = new ArrayList<>();
        try{
//            List<ActorReferencia> allActorReferencia = super.findAll();
            List<CatalogoGen> catalogoList =  new ArrayList<>();
            catalogoList.add(catalogo.find(68));
            catalogoList.add(catalogo.find(76));
            catalogoList.add(catalogo.find(77));

            Query q = em.createNamedQuery("ActorReferencia.findAllInCatalogo");
            q.setParameter("idCgList", catalogoList) ;        
            List<ActorReferencia> allActorReferencia = q.getResultList();
            
            for(ActorReferencia actRef: allActorReferencia ){
                double currentLongitude = Double.parseDouble(actRef.getLongitudAr());
                double currentLatitude = Double.parseDouble(actRef.getLatitudAr());
                double logitudResult = Math.abs( Math.abs(currentLongitude) - Math.abs(longitude) );
                double latitudResult = Math.abs( Math.abs(currentLatitude) - Math.abs(latitude) );
                System.err.println( "  lat: " + logitudResult +"  lat: " + latitudResult );
                if (  logitudResult < distance &&  
                        latitudResult < distance){
                    returnActorReferencia.add(actRef);
                }
            }
        }catch(Exception ex){
            System.err.println("error: " + ex);
        }
        return returnActorReferencia;
//        return super.find(id);
    }
    

    @GET
    @Path("actor/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActorReferencia> findByActorId( @PathParam("id") Integer id) {
        Query q = em.createNamedQuery("ActorReferencia.findIdAct");
        q.setParameter("idAct", id) ;        
        List<ActorReferencia> actorsRef =  q.getResultList();
        return actorsRef;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActorReferencia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
