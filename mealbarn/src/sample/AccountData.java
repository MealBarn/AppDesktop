package sample;

import ooad.Account;
import javax.persistence.*;
import java.util.*;

public class AccountData {
    private List<Account> accountList;
    private static AccountData accountData = new AccountData();
    private AccountData(){
        openFile();
    }

    public static AccountData getAccountData() {return accountData;}
	
	public void addAccount(String user,String pass){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account account = new Account();
        em.persist(account);
        account.setUsername(user);
        account.setPassword(pass);
        em.getTransaction().commit();
        TypedQuery<Account> queryAccount =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        accountList = queryAccount.getResultList();
        em.close();
        emf.close();
    }
	
	public boolean canLogin(String user,String password){
        TempData tempData = TempData.getTempData();
        for(Account account : accountList){
            if(account.getUsername().compareTo(user)==0){
                if(account.getPassword().compareTo(password)==0){
                    tempData.setIdAccount(account.getId().toString());
                    tempData.setAccount(account.getUsername());
                    if(tempData.isRemember()) {
                        tempData.setAccountFill(account.getUsername());
                        tempData.setPassword(account.getPassword());
                    }else {
                        tempData.setAccountFill(null);
                        tempData.setPassword(null);
                    }
                    LikeData.getLikeData().refreshLike();
                    return true;
                }else return false;
            }else continue;
        }
        return false;
    }
	
	public boolean isDuplicateUser(String user){
        for (Account account : accountList){
            if(account.getUsername().compareTo(user)==0){
                return true;
            }
        }
        return false;
    }
	
    private void openFile(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Account> queryAccount =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        accountList = queryAccount.getResultList();
        em.close();
        emf.close();
    }
    
}
