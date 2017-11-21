package sample;

import ooad.Account;

import javax.persistence.*;
import java.util.*;

public class AccountData {
    private List<Account> accountList;
    private ArrayList<String> accountStr;
    private static AccountData accountData = new AccountData();
    private AccountData(){
        openFile();
        updateAccount();
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

    public void updateAccount() {
        accountStr = new ArrayList<String>();
        for(Account account : accountList){
            accountStr.add(account.toString());
        }
    }

    public boolean canLogin(String userId,String password){
        String user = String.format("%s %s",userId,password);
        return accountStr.contains(user);
    }

    public boolean isDuplicateUser(String user){
        for (Account account : accountList){
            if(account.getUsername().compareTo(user)==0){
                return true;
            }
        }
        return false;
    }

    public void addAccount(String user,String pass){
        Long id = accountList.get(accountList.size()-1).getId()+1;
        updateAccount();
    }

    public static AccountData getAccountData() {return accountData;}
}