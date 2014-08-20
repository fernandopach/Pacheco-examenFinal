/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author T-10A
 */
@Controller
@RequestMapping("/")
public class ControladorNombre {
    
 /*
    Creamos el metodo para insertar el alumno
  */   
    
    @RequestMapping(value="/nombre/{precio}/{unidades}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable String nombre, @PathVariable float precio, @PathVariable int unidades){
           DAONombreImpl d= new DAONombreImpl();
           d.agregarAlumno(new nombre(precio, unidades));
           return "Nombre guardado con exito";
    }
    
    @RequestMapping(value="/nombre", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAONombreImpl d=new DAONombreImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosAlumnos());
    }
}









