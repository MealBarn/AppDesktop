package ooad;

import javax.persistence.*;
import java.util.*;
import java.sql.*;
import javax.persistence.Query;

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

        //String nameFile = "objectdb://192.168.43.19:80/PicturePath.odb;user=admin;password=admin";
        String nameFile ="D://58010776//OOAD//objectdb-2.7.2_04//db//Point.odb";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(nameFile);
        EntityManager em = emf.createEntityManager();
       // insertDBAccount(em,"Ham","58011173");
            
//           for(int i=0;i<5;i++)
    //       {
   //        insertDBimgSize(em,3,4);}
    updatePoint(em,(long)5);
    printAll(em);
         em.close();
        emf.close();
         
    }

    /*For displaying list Food*/
    public static void printAll(EntityManager em)
    {
              TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
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
    
       public static void insertDBimgSize(EntityManager em,int imgSize,int dirSize)
    {
        /*Connect to database*/
               em.getTransaction().begin();        

                    ImageSize p = new ImageSize();
                    em.persist(p);
                    p.setImgSize(imgSize);
                    p.setDirSize(dirSize);
          
        em.getTransaction().commit();
        /*Close connect*/
    }
       
    /**
     *
     * @param em
     * @param idprimary
     */
    public static void updatePoint(EntityManager em,Long idprimary)
       {  
           /*Connect to database*/
              em.getTransaction().begin();        
            Query query = em.createQuery("UPDATE Point SET point=point-1 WHERE idprimary="+idprimary);
            int updateCount = query.executeUpdate();
        em.getTransaction().commit();
        /*Close connect*/
       }
}   

