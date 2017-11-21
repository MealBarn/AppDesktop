package sample;

import ooad.*;

import javax.persistence.*;
import java.util.*;

public class FoodData {

    private List<Component> componentList;
    private List<Food> foodsList;
    private List<ImageSize> imageSizeList;
    private ArrayList<FoodShow> foodShowsList   =   new ArrayList<FoodShow>();
    private ArrayList<String> allComponent      =   new ArrayList<String>();
    private ArrayList<String> alacarteIDList    =   new ArrayList<String>();
    private ArrayList<String> appetizerIDList   =   new ArrayList<String>();
    private ArrayList<String> dessertIDList     =   new ArrayList<String>();
    private ArrayList<String> drinkIDList       =   new ArrayList<String>();
    private ArrayList<String> mainCourseIDList  =   new ArrayList<String>();
    private ArrayList<String> soupIDList        =   new ArrayList<String>();
    private ArrayList<String> showIDList        =   new ArrayList<String>();
    private int idFood;
    private String mode;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

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
    private static FoodData foodData = new FoodData();

    public List<ImageSize> getImageSizeList() {
        return imageSizeList;
    }

    private FoodData()
    {
        openFile();
        initFoodData();
        assortFood();
    }

    private void initFoodData(){
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
            FoodShow foodShow = new FoodShow(id, name, amount);
            foodShowsList.add(foodShow);
        }
    }

    private void openFile(){
        EntityManagerFactory emf;
        EntityManager em;
//        emf = Persistence.createEntityManagerFactory("objectdb://192.168.43.229:80/Food.odb;user=admin;password=admin");
        emf = Persistence.createEntityManagerFactory("./src/ODB/Food.odb");
        em = emf.createEntityManager();
        TypedQuery<Food> queryFood =
                em.createQuery("SELECT a FROM ooad.Food a", Food.class);
        foodsList = queryFood.getResultList();
        em.close();
        emf.close();
        /////////////////////////////////////////////////////////////////
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
        componentList = queryComponent.getResultList();
        em.close();
        emf.close();
    }

    private void assortFood(){
        for (Food food : foodsList) {
            Long id = food.getId();
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

    public static FoodData getFoodData(){return foodData;}

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

    public ArrayList<String> getAllComponent(){ return allComponent; }

    public ArrayList<FoodShow> getFoodShowsList() { return foodShowsList; }

    public List<Component> getComponentList() { return componentList; }

    public void clearPerfectFood(){
        for (FoodShow foodShow : foodShowsList){
            foodShow.clearPerfect();
        }
    }
}
