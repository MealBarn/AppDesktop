package sample;

import ooad.Account;

import javax.persistence.*;
import java.util.*;

public class TestAcc {
    private ArrayList<String> account;
    private static TestAcc instance = new TestAcc();
    private  TestAcc(){
        account = new ArrayList<String>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Account> query =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        List<Account> results = query.getResultList();
        for(Account now : results){
            account.add(now.toString());
        }
        em.close();
        emf.close();
    }
    public ArrayList<String> getAccount(){
        return account;
    }
    public static TestAcc getInstance(){
        return instance;
    }
}
