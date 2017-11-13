package ooad;

import sample.Data;

import javax.persistence.*;
import java.util.*;

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
        Data ob = Data.getData();
        //List<Food> f = ob.getFoodsList();
        //System.out.println(f.get(25).toString());
//        Test ob = Test.getInstance();
//        List<Component> componentList = ob.getComponentList();
//        for (Component component : componentList){
//            System.out.println(component.getIdprimary());
//        }

        //Scanner input = new Scanner (System.in);
        //Test ob = Test.getInstance();
//        TestAcc ob = TestAcc.getInstance();
//        ArrayList<String> acc = ob.getAccount();
//        for (String user : acc){
//            System.out.println(user);
//        }
//        String user = "Suzy";
//        String pass = "1234678";
//        String uTest = String.format("%s %s",user,pass);
//        System.out.println("This User :" + uTest);
//        System.out.println(acc.contains(uTest));

        //ArrayList<String> ingre = new ArrayList<String>();
        //ArrayList<String> uni = ob.getUniqueIngredient();
        //ArrayList<String> match = ob.getMatchIngredient("กร");


        //for (String a : match) {
          //  System.out.println(a);
            //ingre.add(a.getComponent());
        //}

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Component.odb");
//        EntityManager em = emf.createEntityManager();
//
//        TypedQuery<Component> query =
//            em.createQuery("SELECT a FROM Component a", Component.class);
//        List<ooad.Component> results = query.getResultList();
//        for (Component a : results) {
//            //System.out.println(a.toString());
//            ingre.add(a.getComponent());
//        }
//        Component gg = results.get(5);
//        em.close();
//        emf.close();
//
//        System.out.println(results.contains(gg));
//        System.out.println(gg.toString());
//
//        ArrayList<String> ingretmp = new ArrayList<String>();
//        ingretmp.clear();
//        boolean sum;
//        for (String t : ingre){
//            sum = false;
//            for(String tm : ingretmp)
//            {
//                if(tm.compareTo(t)==0) {
//                    sum = true;
//                    break;
//                }
//            }
//            if(!sum){
//            ingretmp.add(t);
//            }
//        }
//        Collections.sort(ingretmp);
//        String test = "มะ";
//        for(String tm : ingretmp)
//        {
//            if(tm.indexOf(test)!=-1) {
//               // System.out.println(tm);
//            }
//        }
//       // System.out.println(ingre.size());
//       // System.out.println(ingretmp.size());

        //System.out.println(results2.get(1));
    }
}   

