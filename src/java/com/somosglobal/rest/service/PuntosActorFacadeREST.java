/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.rest.service;

import com.somosglobal.entities.PuntosActor;
import com.somosglobal.entities.TransaccionesActor;
import java.math.BigDecimal;
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
@Path("com.somosglobal.rest.puntosactor")
public class PuntosActorFacadeREST extends AbstractFacade<PuntosActor> {

    @PersistenceContext(unitName = "SomosGlobalPU")
    private EntityManager em;

    @Inject
    TransaccionesActorFacadeREST transaccionesActor;
    public PuntosActorFacadeREST() {
        super(PuntosActor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PuntosActor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, PuntosActor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{numeroDoc}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PuntosActor find(@PathParam("numeroDoc") String numeroDoc) {
//        return super.find(id);
        PuntosActor puntosAct = null;
        Query q = null;
        q = em.createNamedQuery("PuntosActor.findByNumDocumentoActor");
        q.setParameter("numDocumentoActor", numeroDoc);
        try{
            puntosAct = (PuntosActor) q.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return puntosAct;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PuntosActor> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PuntosActor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("transfer/{numDocumentoActor}/{numDocumentoActor2}/{valor}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String trasnferPoint(@PathParam("numDocumentoActor") String numDocumentoActor, @PathParam("numDocumentoActor2") String numDocumentoActor2, @PathParam("valor") Integer valor) {
        PuntosActor puntosDesde = null;
        PuntosActor puntosHacia = null;
        Query q = null;
        q = em.createNamedQuery("PuntosActor.findByNumDocumentoActor");
        q.setParameter("numDocumentoActor", numDocumentoActor);
        Query q2 = null;
        q2 = em.createNamedQuery("PuntosActor.findByNumDocumentoActor");
        q2.setParameter("numDocumentoActor", numDocumentoActor2);
        try{
            puntosDesde = (PuntosActor) q.getSingleResult();
            puntosHacia = (PuntosActor) q2.getSingleResult();
            if ( puntosDesde.getTotalPuntos() >= valor ){
                puntosDesde.setTotalPuntos( puntosDesde.getTotalPuntos()-valor );
                puntosHacia.setTotalPuntos( puntosHacia.getTotalPuntos()+valor );
                
                super.edit(puntosDesde);
                super.edit(puntosHacia);
                transaccion(puntosDesde, puntosHacia, valor);
                return "true";
            }
            
        }
        catch(Exception ex){
            System.err.println("Posible null");
            ex.printStackTrace();
        }
        return "false";
        
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
    
    
    
    public void transaccion(PuntosActor actor, PuntosActor actorBeneficiario, Integer valor){
        TransaccionesActor transAct = new TransaccionesActor();
        transAct.setIdConsumidor(actor.getIdActor());
        transAct.setNumDocumentoActor(actor.getNumDocumentoActor());
        transAct.setIdBeneficiario( actorBeneficiario.getIdActor() );
        transAct.setNumDocumentoBeneficiario(actorBeneficiario.getNumDocumentoActor());
        transAct.setValorCompra(BigDecimal.ZERO);
        transAct.setPuntosTransaccion( valor );
        transAct.setPuntosGanados(valor);
        transAct.setDescripcionCompra("Transferencia puntos entre clientes");
        transAct.setFechaTransaccion(new Date());
        transaccionesActor.create(transAct);
//        private Integer id;
//        private String numDocumentoActor;
//        private String numDocumentoBeneficiario;
//        private Integer puntosTransaccion;
//        private Integer puntosGanados;
//        private Date fechaTransaccion;
//        private BigDecimal valorCompra;
//        private BigDecimal porcentajeDescuento;
//        private String descripcionCompra;
//        private Actor idConsumidor;
//        private Actor idBeneficiario;
//        private Actor idLocal;

    }
}
