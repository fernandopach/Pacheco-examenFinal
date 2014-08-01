/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")
public class ControladorUsuario {

    @RequestMapping(value="/usuario/{nombre}/{sueldo}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String metodo(@PathVariable String nombre, @PathVariable float sueldo){
        /*
        Esto esta mal, alerta de lo que no se debe hacer, esta clase que le puse de nombre Guarda NO USA UNA SESION A PRUEBA DE THREASD NI NADA
        ES SOLO UN EJEMPLO DE  CONTROLADOR, LE PASAMOS UN PARAMETRO NOMBRE Y LA LO GUADA, TU LABOR ES HACER QUE FUNCIONE 
        A PRUEBA DE TREADS JIJIJI
        */
 DAOUsuarioImpl du=new DAOUsuarioImpl();
 du.agregarProducto(new Usuario(nombre, sueldo)); 
 
        return nombre +" ya se ha guardado, este esta pesimo, no es thead safe, no maneja nada de TheradsLocal ni nada, CORRIGELOOOOO!!!";
    }
    
    @RequestMapping(value="/usuario", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception{
        /*
        Esto esta mal, alerta de lo que no se debe hacer, esta clase que le puse de nombre Guarda NO USA UNA SESION A PRUEBA DE THREASD NI NADA
        ES SOLO UN EJEMPLO DE  CONTROLADOR, LE PASAMOS UN PARAMETRO NOMBRE Y LA LO GUADA, TU LABOR ES HACER QUE FUNCIONE 
        A PRUEBA DE TREADS JIJIJI
        */
  DAOUsuarioImpl g=new DAOUsuarioImpl();
  Map<String,ArrayList<Usuario>> singletonMap =Collections.singletonMap("usuarios", g.buscarTodosClientes());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodosClientes());
    }
    
    
    /*Metodo post para guardar un usuario con todos sus campos*/
    @RequestMapping(value="/usuario", method=RequestMethod.POST, headers={"Accept=Application/json"})
    public @ResponseBody String guardarUsuario(@RequestBody String json)throws Exception{
     System.out.println("Se guardara el usuario"+json);
     
     Map<String,String> map = new HashMap<String,String>();
	ObjectMapper mapper = new ObjectMapper();
 
	
 
		//convert JSON string to Map
		map = mapper.readValue(json, 
		    new TypeReference<HashMap<String,String>>(){});
 
		System.out.println(map);
             String nombre= map.get("nombre");
             float sueldo=Float.parseFloat(map.get("sueldo"));
             //A GUARDARSE!!!
             DAOUsuarioImpl du=new DAOUsuarioImpl();
            du.agregarProducto(new Usuario(nombre, sueldo)); 
             
            // int edad=Integer.parseInt(map.get("edad"));
             System.out.println("Este es el usuario a guardarse:"+nombre +" Y el sueldo es"+sueldo);
             
              Usuario usuario=new Usuario("juan carlitos",41.0f);
        Map<String, Usuario> singletonMap=Collections.singletonMap("usuarios",usuario);
		ObjectMapper mapper2=new ObjectMapper();
		return mapper2.writeValueAsString(singletonMap);
 
    }
    
}
