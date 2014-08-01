/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")
public class ControladorNomina {
    
    @RequestMapping(value="/nomina/{saldo}/{id}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable float saldo, @PathVariable int id ){
        String mensajito="nada";
        try{
            

 
  DAONominaImpl nom=new DAONominaImpl();
  nom.agregarProducto(new Nomina(new Date(), saldo, new Usuario(id))); 
           mensajito= "Nomina guardado con exito";
        }catch(Exception  e){
            mensajito=e.getMessage();
        }
        return mensajito;
    }
    
     
    @RequestMapping(value="/nomina", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception{
        /*
        Esto esta mal, alerta de lo que no se debe hacer, esta clase que le puse de nombre Guarda NO USA UNA SESION A PRUEBA DE THREASD NI NADA
        ES SOLO UN EJEMPLO DE  CONTROLADOR, LE PASAMOS UN PARAMETRO NOMBRE Y LA LO GUADA, TU LABOR ES HACER QUE FUNCIONE 
        A PRUEBA DE TREADS JIJIJI
        */
  DAONominaImpl g=new DAONominaImpl();

  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodosClientes());
    }
}
