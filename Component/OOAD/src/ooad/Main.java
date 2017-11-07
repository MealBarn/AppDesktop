/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import javax.persistence.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Panisa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner input = new Scanner (System.in);
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("Component.odb");
        //EntityManager em = emf.createEntityManager();
        
        //em.getTransaction().begin();
        //          Component p = new Component();
         //         em.persist(p);
         //         p.setId(76);
         //         p.setComponent("ผงฟู");
                 //em.clear();
        //em.getTransaction().commit();
        
        
        
        //em.close();
       //emf.close();
       
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Point.odb");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
                 for (int i=1;i<77;i++){
                     Point p= new Point();
                     em.persist(p);
                     //
                 }
        em.getTransaction().commit();
        
        
        
        em.close();
        emf.close();
         
    }
    
}
