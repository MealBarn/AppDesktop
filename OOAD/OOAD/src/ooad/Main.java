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


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Account.odb");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();        

                    Account p = new Account();
                    em.persist(p);
                    
                      p.setUsername("Suzy");
                  
                    p.setPassword("12345678");
                   
    
                   
//                    p.setName("ราดหน้าหมูหมัก");
//                  
//                    p.setType("a la carte");
//                   
//                    p.setRecipe("");
                    
        em.getTransaction().commit();
//        TypedQuery<Food> query =
//            em.createQuery("SELECT p FROM Food p", Food.class);
//        List<Food> results = query.getResultList();
//        for (Food p : results) {
//            System.out.println(p);
//        }
//        Query query1 = em.createQuery("SELECT c FROM Food c WHERE c.id = 1");
//        Food c = (Food)query.getSingleResult();
//        System.out.print(c);

            
         em.close();
        emf.close();
         
    }
}   

