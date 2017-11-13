package sample;

import ooad.Account;
import ooad.Component;
import ooad.Food;
import ooad.FoodShow;

import javax.persistence.*;
import java.util.*;

public class Data {
    private ArrayList<String> allComponent;
    private ArrayList<String> matchComponent;
    private ArrayList<String> accountStr;
    private ArrayList<String> foodStr;
    private List<Component> componentList;
    private List<Food> foodsList;
    private ArrayList<FoodShow> foodShowsList;
    private List<Account> accountList;
    private static Data data = new Data();
    private Data()
    {
        accountStr = new ArrayList<String>();
        allComponent = new ArrayList<String>();
        matchComponent = new ArrayList<String>();
        foodShowsList = new ArrayList<FoodShow>();
        foodStr = new ArrayList<String>();
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        em = emf.createEntityManager();
        TypedQuery<Account> queryAccount =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        accountList = queryAccount.getResultList();
        em.close();
        emf.close();
        //////////////////////////////////////////////////////////////////
        emf = Persistence.createEntityManagerFactory("./src/ODB/Food.odb");
        em = emf.createEntityManager();
        TypedQuery<Food> queryFood =
                em.createQuery("SELECT a FROM Food a", Food.class);
        foodsList = queryFood.getResultList();
        em.close();
        emf.close();
        /////////////////////////////////////////////////////////////////
        emf = Persistence.createEntityManagerFactory("./src/ODB/Component.odb");
        em = emf.createEntityManager();
        TypedQuery<Component> queryComponent =
                em.createQuery("SELECT a FROM Component a", Component.class);
        componentList = queryComponent.getResultList();
        em.close();
        emf.close();
        /////////////////////////////////////////////////////////////////
        for(Account account : accountList){
            accountStr.add(account.toString());
        }
        /////////////////////////////////////////////////////////////////
        ArrayList<String> amountComponent = new ArrayList<String>();
        int nowId;
        int prevId = -1;
        int count = 0;
        boolean unique;
        for (Component component : componentList) {
            nowId = component.getId();
            if(nowId!=prevId)
            {
                amountComponent.add(""+count);
                count = 1;
                prevId = nowId;
            }else{
                count++;
            }
            unique = true;
            String componentTmp = component.getComponent();
            for(String componetSamp : allComponent)
            {
                if(componetSamp.compareTo(componentTmp)==0)
                {
                    unique = false;
                    break;
                }
            }
            if(unique){
                allComponent.add(componentTmp);
            }
        }
        amountComponent.add(""+count);
        Collections.sort(allComponent);
        amountComponent.remove(0);
        /////////////////////////////////////////////////////////////////
        for (int i = 0;i<foodsList.size();i++) {
            Food food = foodsList.get(i);
            int amount = Integer.parseInt(amountComponent.get(i));
            Long id = food.getId();
            String name = food.getName();
            String perfect = "0";
            FoodShow foodShow = new FoodShow(id,name,amount);
            foodShowsList.add(foodShow);
            String details = String.format("%d %s %s %s", id, name, amount, perfect);
            foodStr.add(details);
            /////////////////////////////////////////////////////////////////
        }

    }
    public static Data getData(){return data;}

    public ArrayList<String> getAccountStr() { return accountStr; }
    public ArrayList<String> getAllComponent(){ return allComponent; }
    public ArrayList<String> getFoodStr() { return foodStr; }
    public ArrayList<FoodShow> getFoodShowsList() { return foodShowsList; }
    public List<Component> getComponentList() { return componentList; }
    public List<Food> getFoodsList() { return foodsList; }
    public List<Account> getAccountList() { return accountList; }
    public ArrayList<String> getMatchComponent(String inputComp) {
        matchComponent.clear();
        for (String component : allComponent){
            if (component.indexOf(inputComp)==0){
                matchComponent.add(component);
            }

        }
        return matchComponent;
    }
}
