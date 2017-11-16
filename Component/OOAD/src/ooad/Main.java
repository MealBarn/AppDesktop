/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import javax.persistence.*;
import java.util.*;
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
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80//PicturePath.odb;user=admin;password=admin");
       int i=1;
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("RecipePath.odb");
        EntityManager em = emf.createEntityManager();
             em.getTransaction().begin();
                  
                  for(i=1;i<77;i++){
                PicturePath p = new PicturePath();  
                  em.persist(p);
                  p.setIdFood(i);
                  p.setPathPicture("./Mealbarn/"+i+".png");
                 
                }
                 //em.clear();
        em.getTransaction().commit();
//        TypedQuery<PicturePath> query =
//            em.createQuery("SELECT p FROM PicturePath p", PicturePath.class);
//        List<PicturePath> results = query.getResultList();
//        for (Component p : results) {
//            System.out.println(p);
//        }
//        Object[] objects = results.toArray();
//        String a=objects[0].toString();
//        System.out.print(objects[0]);
//        
    
//        Query query = em.createQuery(
//        "SELECT c FROM Component c WHERE c.idprimary = 1");
//        Component c = (Component)query.getSingleResult();
//        
//        
//         System.out.println(c);
//         String a;
//         a=c.toString();
//         System.out.println(a);
         
        
        em.close();
        emf.close();
         
    }
    
}
