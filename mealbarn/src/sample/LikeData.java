package sample;

import ooad.*;

import javax.persistence.*;
import java.util.*;

public class LikeData {
    private ArrayList<Like> likeList = new ArrayList<>();
    private static LikeData likeData = new LikeData();
    private LikeData(){    }
    private List<PointDetail> pointDetailList;

    public static LikeData getLikeData(){
        return likeData;
    }

    int idAccount;
    ArrayList<FoodShow> foodList = FoodData.getFoodData().getFoodShowsList();
    int[] likeSum = new int[foodList.size()];
    int[] likeAcc = new int[foodList.size()];

    private void openFile(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/PointDetail.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<PointDetail> queryPointDetail =
                em.createQuery("SELECT a FROM ooad.PointDetail a", PointDetail.class);
        pointDetailList = queryPointDetail.getResultList();
        em.close();
        emf.close();
        idAccount = Integer.parseInt(TempData.getTempData().getIdAccount());
        likeSum = new int[foodList.size()];
        likeAcc = new int[foodList.size()];
        for(PointDetail pointDetail : pointDetailList){
            int idFood=pointDetail.getIdFood()-1;
            if(pointDetail.getValue().compareTo("L")==0){
                likeSum[idFood]= likeSum[idFood]+1;
                if(pointDetail.getIdAccount()==idAccount){
                    likeAcc[idFood] = 1;
                }
            }else{
                if(pointDetail.getValue().compareTo("U")==0) {
                    likeSum[idFood]= likeSum[idFood]-1;
                    if (pointDetail.getIdAccount() == idAccount) {
                        likeAcc[idFood] = 0;
                    }
                }
            }
        }
    }

    private void setData(){
        likeList.clear();
        for (int i = 1;i<=foodList.size();i++){
            Like like = new Like();
            like.setId(Long.valueOf(i));
            like.setIdAcc(idAccount);
            like.setIdFood(i);
            if(likeAcc[i-1]==0){
                like.setValue(null);
            }else {
                like.setValue("L");
            }
            like.setSumValue(likeSum[i-1]);
            likeList.add(like);
        }
    }

    public ArrayList<Like> getLikeList() {
        return likeList;
    }

    public void refreshLike(){
        openFile();
        setData();
//        for (Like like : likeList){
//            System.out.println(like);
//
//        }
    }

    private void editLike(int idFood,String mode){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/PointDetail.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PointDetail p = new PointDetail();
        em.persist(p);
        p.setIdAccount(Integer.parseInt(TempData.getTempData().getIdAccount()));
        p.setIdFood(idFood);
        if(mode.compareTo("L")==0) {
            p.setValue("L");
        }else {
            p.setValue("U");
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void activeLike(int idFood){
        Like like = likeList.get(idFood);
        String value = like.getValue();
        if(value=="L"){
            like.setValue(null);
            like.setSumValue(like.getSumValue()-1);
            editLike(idFood+1,"U");
        }else {
            like.setValue("L");
            like.setSumValue(like.getSumValue()+1);
            editLike(idFood+1,"L");
        }
    }


}
