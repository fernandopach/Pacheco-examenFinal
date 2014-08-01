/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author T107
 */
public class ProbarHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
Session sesion=  HibernateUtilidades.getSessionFactory().openSession();
// primer paso: Empezar una sesion

//sesion.getTransaction().begin();
//sesion.save(new Usuario(1, "Juan Carlos",40000f));
//sesion.update(new Usuario(1,"pwedro", 400000f)); 
/*
 Query q= sesion.createQuery("from Usuario");
 
 ArrayList<Usuario> usuarios=(ArrayList<Usuario>)   q.list();
 for(Usuario usu:usuarios){
     System.out.println(usu); 
 }

 Criteria c=sesion.createCriteria(Usuario.class);
 
 ArrayList<Usuario> usuarios2=(ArrayList<Usuario>)   c.list();
 for(Usuario usu:usuarios2){
     System.out.println(usu); 
 }        c.list();
 */
//tres 
sesion.getTransaction().commit();
System.out.println("Se inserto adecuadamente");
sesion.close();
        
        
        
    }
    
}
