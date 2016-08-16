/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.rest.service;

import com.somosglobal.entities.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
@Path("com.somosglobal.rest.categoria")
public class CategoriaFacadeREST extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "SomosGlobalPU")
    private EntityManager em;

    public CategoriaFacadeREST() {
        super(Categoria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Categoria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Categoria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Categoria find(@PathParam("id") String id) {
//        return super.find(id);
//    }
    @GET
    @Path("subcategory/{nivel}/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findAllSubCategory(@PathParam("nivel") String nivel, @PathParam("id") String id) {
        Query q = null;
        int subStringLimit = 0;
        if (nivel.equals("1")){
            q = em.createNamedQuery("Categoria.findSubCategoriaNivel1");
            subStringLimit = 2;
        }
        if (nivel.equals("2")){
            q = em.createNamedQuery("Categoria.findSubCategoriaNivel2");
            subStringLimit = 4;
        }
        if (nivel.equals("0")){
            q = em.createNamedQuery("Categoria.findSubCategoriaNivel2");
            subStringLimit = 2;
        }
        List<Categoria> cat2 = q.getResultList(); 
        List<Categoria> cat = new ArrayList<>();
        for(Categoria c: cat2 ){
//            System.out.print("id: "+ c.getCatId() );
            if (c.getCatId().substring(0,subStringLimit).equals(id)){
                System.out.println("added: "+ c.getCatId() );
                cat.add(c);
            }
        }
        
        return cat;
    }
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findAll() {
        Query q = em.createNamedQuery("Categoria.findCategoriaPadre");
        List<Categoria> cat = q.getResultList();
        for(Categoria c: cat){
            System.out.println("id: "+ c.getCatId() );
                    
        }
        
        return cat;
//        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
