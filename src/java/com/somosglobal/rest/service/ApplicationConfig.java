/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.rest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Paflo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.somosglobal.rest.service.ActorFacadeREST.class);
        resources.add(com.somosglobal.rest.service.ActorReferenciaFacadeREST.class);
        resources.add(com.somosglobal.rest.service.BarrioFacadeREST.class);
        resources.add(com.somosglobal.rest.service.CatalogoGenFacadeREST.class);
        resources.add(com.somosglobal.rest.service.CategoriaFacadeREST.class);
        resources.add(com.somosglobal.rest.service.CiudadFacadeREST.class);
        resources.add(com.somosglobal.rest.service.LocalPromocionFacadeREST.class);
        resources.add(com.somosglobal.rest.service.LocalVentaFacadeREST.class);
        resources.add(com.somosglobal.rest.service.LocalidadFacadeREST.class);
        resources.add(com.somosglobal.rest.service.MenuFacadeREST.class);
        resources.add(com.somosglobal.rest.service.PerfilFacadeREST.class);
        resources.add(com.somosglobal.rest.service.PersonaFacadeREST.class);
        resources.add(com.somosglobal.rest.service.ProvinciaFacadeREST.class);
        resources.add(com.somosglobal.rest.service.UbicacionFacadeREST.class);
        resources.add(com.somosglobal.rest.service.UsuarioFacadeREST.class);
    }
    
}
