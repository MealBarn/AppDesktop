package sample;

import ooad.Account;
import ooad.Component;
import ooad.Food;
import ooad.FoodShow;

import javax.persistence.*;
import java.util.*;

public class Data {
    private ArrayList<String> allComponent;
    private ArrayList<String> accountStr;
    private List<Component> componentList;
    private List<Food> foodsList;
    private ArrayList<FoodShow> foodShowsList;
    private List<Account> accountList;
    private ArrayList<String> alacarteIDList;
    private ArrayList<String> appetizerIDList;
    private ArrayList<String> dessertIDList;
    private ArrayList<String> drinkIDList;
    private ArrayList<String> mainCourseIDList;
    private Integer[] recipeIng;
    private Integer[] recipeDir;

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    private ArrayList<String> soupIDList;
    private int idFood;

    public void setShowIDList(ArrayList<String> showIDList) {
        this.showIDList = showIDList;
    }

    public void setFoodShowsList(ArrayList<FoodShow> foodShowsList) {
        this.foodShowsList = foodShowsList;
    }

    public void setShowIDList() {
        showIDList.clear();
        for (FoodShow food : foodShowsList){
            if(food.getPerfect()>0){
                showIDList.add(food.getId().toString());
            }
        }
    }


    private ArrayList<String> showIDList;
    private ArrayList<String> selectIDList;
    private static Data data = new Data();

    public Integer[] getRecipeIng() {
        return recipeIng;
    }

    public Integer[] getRecipeDir() {
        return recipeDir;
    }

    private Data()
    {
        accountStr = new ArrayList<String>();
        allComponent = new ArrayList<String>();
        foodShowsList = new ArrayList<FoodShow>();
        alacarteIDList = new ArrayList<String>();
        appetizerIDList = new ArrayList<String>();
        dessertIDList = new ArrayList<String>();
        drinkIDList = new ArrayList<String>();
        mainCourseIDList = new ArrayList<String>();
        soupIDList = new ArrayList<String>();
        showIDList = new ArrayList<String>();
        EntityManagerFactory emf;
        EntityManager em;
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Account.odb;user=admin;password=admin");
        emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        em = emf.createEntityManager();
        TypedQuery<Account> queryAccount =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        accountList = queryAccount.getResultList();
        em.close();
        emf.close();
        //////////////////////////////////////////////////////////////////
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Account.odb;user=admin;password=admin");
        emf = Persistence.createEntityManagerFactory("./src/ODB/Food.odb");
        em = emf.createEntityManager();
        TypedQuery<Food> queryFood =
                em.createQuery("SELECT a FROM Food a", Food.class);
        foodsList = queryFood.getResultList();
        em.close();
        emf.close();
        /////////////////////////////////////////////////////////////////
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Account.odb;user=admin;password=admin");
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
        recipeIng = new Integer[]{2,3,1,1,2,2,1,2,2,1,2,1,2,1,1,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,2,2,1,2,2,2,2,1,2,2,3};
        recipeDir = new Integer[]{1,5,1,2,1,2,2,1,1,1,1,1,2,1,3,5,1,2,2,4,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,3,1,1,1,2,3,1,2,3,4};
//        System.out.println(recipeIng.length);
//        System.out.println(recipeDir.length);
//        for (int i = 0;i<recipeIng.length;i++){
//            System.out.println(String.format("%d\t%d\t%d",i+1,recipeIng[i],recipeDir[i]));
//        }
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
            String type = food.getType();
            if(type.compareTo("appetizer")==0){
                appetizerIDList.add(id.toString());
            }else
            if(type.compareTo("dessert")==0){
                dessertIDList.add(id.toString());
            }else
            if(type.compareTo("drink")==0){
                drinkIDList.add(id.toString());
            }else
            if(type.compareTo("main course")==0){
                mainCourseIDList.add(id.toString());
            }else
            if(type.compareTo("soup")==0){
                soupIDList.add(id.toString());
            }else
            if(type.compareTo("a la carte")==0){
                alacarteIDList.add(id.toString());
            }
        }
    }

    public static Data getData(){return data;}

    public void sortPerfect(){
        int n = showIDList.size();
        boolean isSwitch;
        do{
            isSwitch = false;
            int idNow;
            int idPrev;
            float perfectNow;
            float perfectPrev;
            for(int i = 1 ;i<n;i++)
            {
                idNow = Integer.parseInt(showIDList.get(i));
                idPrev= Integer.parseInt(showIDList.get(i-1));
                perfectNow = foodShowsList.get(idNow-1).getPerfect();
                perfectPrev = foodShowsList.get(idPrev-1).getPerfect();
                if(perfectPrev<perfectNow){
                    Collections.swap(showIDList,i,i-1);
                    isSwitch =true;
                }
            }
            n=n-1;
        }while (isSwitch);
    }

    public ArrayList<String> getAccountStr() { return accountStr; }

    public ArrayList<String> getAlacateIDList() {
        return alacarteIDList;
    }

    public ArrayList<String> getAppetizerIDList() {
        return appetizerIDList;
    }

    public ArrayList<String> getDessertIDList() {
        return dessertIDList;
    }

    public ArrayList<String> getDrinkIDList() {
        return drinkIDList;
    }

    public ArrayList<String> getMainCourseIDList() {
        return mainCourseIDList;
    }

    public ArrayList<String> getSoupIDList() {
        return soupIDList;
    }

    public ArrayList<String> getShowIDList() {
        return showIDList;
    }

    public ArrayList<String> getSelectIDList() {
        return selectIDList;
    }

    public ArrayList<String> getAllComponent(){ return allComponent; }

//    public ArrayList<String> getFoodStr() { return foodStr; }

    public ArrayList<FoodShow> getFoodShowsList() { return foodShowsList; }

    public List<Component> getComponentList() { return componentList; }

    public List<Food> getFoodsList() { return foodsList; }

    public List<Account> getAccountList() { return accountList; }

    public void clearPerfectFood(){
        for (FoodShow foodShow : foodShowsList){
            foodShow.clearPerfect();
        }
    }
}
