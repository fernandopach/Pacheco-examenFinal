/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import static com.campitos.spring.web.DAO.close;
import static com.campitos.spring.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author T-10A
 */
public class DAONombreImpl extends DAO {
    
 public void agregarAlumno(Alumno alumno) {
    begin();
    getSession().save(alumno);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Alumno> buscarTodosAlumnos() {
        begin();
        Query q = getSession().createQuery("from Alumno");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Alumno> alumnos = (ArrayList<Alumno>)q.list();
        commit();
        close();
         
return alumnos; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarAlumno(Alumno p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un cliente por medio de su Id
         * @param id Este parametro es el Id del cliente que se quiere buscar
         * @return El tipo de retorno es el cliente buscado
         */
  public Alumno buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Alumno where id = :id");
        q.setInteger("id",id);
        Alumno p = (Alumno)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  }
