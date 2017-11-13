package sample;

import ooad.Component;

import javax.persistence.*;
import java.util.*;

public class Test {
    private ArrayList<String> uniqueIngredient;
    private ArrayList<String> matchIngredient;
    private List<Component> componentList;
    private static Test instance = new Test();
    private Test() {
        uniqueIngredient = new ArrayList<String>();
        matchIngredient = new ArrayList<String>();
        matchIngredient.clear();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Component.odb");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Component> query =
                em.createQuery("SELECT a FROM Component a", Component.class);
        componentList = query.getResultList();
        em.close();
        emf.close();
        ArrayList<String> countIng = new ArrayList<String>();
        int now;
        int prev = -1;
        int count = 0;
        boolean unique;
        for (Component component : componentList) {
            now = component.getId();
            if(now!=prev)
            {
                countIng.add(""+count);
                count = 1;
                prev = now;
            }else{
                count++;
            }
            unique = true;
            String tmp = component.getComponent();
            for(String ingTmp : uniqueIngredient)
            {
                if(ingTmp.compareTo(tmp)==0)
                {
                    unique = false;
                    break;
                }
            }
            if(unique){
                uniqueIngredient.add(tmp);
            }
        }
        Collections.sort(uniqueIngredient);
        countIng.remove(0);
//        for (String i : countIng){
//            System.out.println(i);
//        }
    }
    public static Test getInstance(){
        return instance;
    }
    public ArrayList<String> getUniqueIngredient(){
        return uniqueIngredient;
    }
    public ArrayList<String> getMatchIngredient(String sub){
        matchIngredient.clear();
        for(String tmp : uniqueIngredient)
        {
            if(tmp.indexOf(sub)==0) {
                matchIngredient.add(tmp);
            }
        }
        return matchIngredient;
    }
    public List<Component> getComponentList()
    {
        return componentList;
    }
}
