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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//
//        for(int i = 1 ;i<=100;i++){
//            Account account = new Account();
//            em.persist(account);
//            account.setUsername(String.format("Robot%d",i));
//            account.setPassword("1234");
//        }
//
//        em.getTransaction().commit();

        TypedQuery<Account> queryAccount =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        List<Account> accountList = queryAccount.getResultList();
        em.close();
        emf.close();

        emf = Persistence.createEntityManagerFactory("./src/ODB/PointDetail.odb");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        for(Account account : accountList){
            int idAccount = account.getId().intValue();
            for(int i = 1;i<=76;i++){
                int mode = (int)((Math.random()*500)%5);
                if(mode==0){
                    PointDetail p = new PointDetail();
                    em.persist(p);
                    p.setIdAccount(idAccount);
                    p.setIdFood(i);
                    p.setValue("L");
                    System.out.println(String.format("%d\t%d\t%d",idAccount,i,mode));
                }
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}   

