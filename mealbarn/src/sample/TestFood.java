package sample;

import ooad.Food;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TestFood {

    private static TestFood instance = new TestFood();
    private TestFood() {
        //uniqueIngredient = new ArrayList<String>();
        //matchIngredient = new ArrayList<String>();
        //matchIngredient.clear();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/Component.odb");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Food> query =
                em.createQuery("SELECT a FROM Food a", Food.class);
        List<Food> results = query.getResultList();
        em.close();
        emf.close();

    }
    public static TestFood getInstance(){
        return instance;
    }

}
