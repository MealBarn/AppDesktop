package sample;

<<<<<<< Updated upstream
import ooad.*;
=======
import ooad.Account;
import ooad.Component;
import ooad.Food;
import ooad.FoodShow;
>>>>>>> Stashed changes

import javax.persistence.*;
import java.util.*;

public class Data {
    private ArrayList<String> allComponent;
<<<<<<< Updated upstream
    private ArrayList<String> accountStr;
=======
    private ArrayList<String> matchComponent;
    private ArrayList<String> accountStr;
    private ArrayList<String> foodStr;
>>>>>>> Stashed changes
    private List<Component> componentList;
    private List<Food> foodsList;
    private ArrayList<FoodShow> foodShowsList;
    private List<Account> accountList;
<<<<<<< Updated upstream
    private List<ImageSize> imageSizeList;
=======
>>>>>>> Stashed changes
    private ArrayList<String> alacarteIDList;
    private ArrayList<String> appetizerIDList;
    private ArrayList<String> dessertIDList;
    private ArrayList<String> drinkIDList;
    private ArrayList<String> mainCourseIDList;
<<<<<<< Updated upstream

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    private ArrayList<String> soupIDList;
    private int idFood;
=======
    private ArrayList<String> soupIDList;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream

    public List<ImageSize> getImageSizeList() {
        return imageSizeList;
    }

=======
>>>>>>> Stashed changes
    private Data()
    {
        accountStr = new ArrayList<String>();
        allComponent = new ArrayList<String>();
<<<<<<< Updated upstream

=======
        matchComponent = new ArrayList<String>();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Account.odb;user=admin;password=admin");
=======
>>>>>>> Stashed changes
        emf = Persistence.createEntityManagerFactory("./src/ODB/Account.odb");
        em = emf.createEntityManager();
        TypedQuery<Account> queryAccount =
                em.createQuery("SELECT a FROM ooad.Account a", Account.class);
        accountList = queryAccount.getResultList();
        em.close();
        emf.close();
        //////////////////////////////////////////////////////////////////
<<<<<<< Updated upstream
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Account.odb;user=admin;password=admin");
        emf = Persistence.createEntityManagerFactory("./src/ODB/Food.odb");
        em = emf.createEntityManager();
        TypedQuery<Food> queryFood =
                em.createQuery("SELECT a FROM ooad.Food a", Food.class);
=======
        emf = Persistence.createEntityManagerFactory("./src/ODB/Food.odb");
        em = emf.createEntityManager();
        TypedQuery<Food> queryFood =
                em.createQuery("SELECT a FROM Food a", Food.class);
>>>>>>> Stashed changes
        foodsList = queryFood.getResultList();
        em.close();
        emf.close();
        /////////////////////////////////////////////////////////////////
<<<<<<< Updated upstream
        emf = Persistence.createEntityManagerFactory("./src/ODB/ImageSize.odb");
        em = emf.createEntityManager();
        TypedQuery<ImageSize> querySize =
                em.createQuery("SELECT a FROM ooad.ImageSize a", ImageSize.class);
        imageSizeList = querySize.getResultList();
        em.close();
        emf.close();
        /////////////////////////////////////////////////////////////////
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Account.odb;user=admin;password=admin");
        emf = Persistence.createEntityManagerFactory("./src/ODB/Component.odb");
        em = emf.createEntityManager();
        TypedQuery<Component> queryComponent =
                em.createQuery("SELECT a FROM ooad.Component a", Component.class);
=======
        emf = Persistence.createEntityManagerFactory("./src/ODB/Component.odb");
        em = emf.createEntityManager();
        TypedQuery<Component> queryComponent =
                em.createQuery("SELECT a FROM Component a", Component.class);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
            if(nowId!=prevId)
            {
                amountComponent.add(""+count);
                count = 1;
                prevId = nowId;
            }else{
                count++;
            }
            unique = true;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        System.out.println("--------------");
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        printFood();
    }

    public void printFood(){
        int id;
        for (String foodId : showIDList){
            id = Integer.parseInt(foodId)-1;
            System.out.println((id+1)+"\t"+foodShowsList.get(id).getPerfect());
        }
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
//    public ArrayList<String> getFoodStr() { return foodStr; }
=======
    public ArrayList<String> getFoodStr() { return foodStr; }
>>>>>>> Stashed changes

    public ArrayList<FoodShow> getFoodShowsList() { return foodShowsList; }

    public List<Component> getComponentList() { return componentList; }

    public List<Food> getFoodsList() { return foodsList; }

    public List<Account> getAccountList() { return accountList; }

<<<<<<< Updated upstream
=======
    public ArrayList<String> getMatchComponent(String inputComp) {
        matchComponent.clear();
        for (String component : allComponent){
            if (component.indexOf(inputComp)==0){
                matchComponent.add(component);
            }

        }
        return matchComponent;
    }
>>>>>>> Stashed changes
    public void clearPerfectFood(){
        for (FoodShow foodShow : foodShowsList){
            foodShow.clearPerfect();
        }
    }
}
