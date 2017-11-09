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

        String nameFile = "Food.odb";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(nameFile);
        EntityManager em = emf.createEntityManager();
            
         em.close();
        emf.close();
         
    }

    /*For displaying list Food*/
    public static void printAll(EntityManager em)
    {
              TypedQuery<Food> query = em.createQuery("SELECT p FROM Food p", Food.class);
        List<Food> results = query.getResultList();
        for (Food p : results) {
            System.out.println(p);
        }
    }
    
    /*For displaying selected Food detail*/
    public static void printSelect(EntityManager em)
    {
                Query query = em.createQuery("SELECT c FROM Food c WHERE c.id = 1");
        Food c = (Food)query.getSingleResult();
       System.out.print(c);
    }
    
    /*For inserting object in objectDataBase Note!! obeject was identified identity number 
    for example if you delect one object and create new one, ID was generated automatic.e.g. NO.35 was deleted,Next object will
    be generated number is NO.36*/
    public static void insertDBFood(EntityManager em,String nameFood,String nameType, String recipe)
    {
        /*Connect to database*/
               em.getTransaction().begin();        

                    Food p = new Food();
                    em.persist(p);
                    
//                      p.setUsername("Suzy");
                  
//                    p.setPassword("12345678");           
                    p.setName(nameFood);
                    p.setType(nameType);                   
                    p.setRecipe(recipe);
                    
        em.getTransaction().commit();
        /*Close connect*/
           

    }
    /*Same as insertDBFood*/
    public static void insertDBAccount(EntityManager em,String username,String password)
    {
        /*Connect to database*/
          em.getTransaction().begin();        

                    Account p = new Account();
                    em.persist(p);
                    
                    p.setUsername(username);
                    p.setPassword(password);           
 
                    
        em.getTransaction().commit();
        /*Close connect*/
    }
}   

