package sample;

import ooad.*;
import javax.persistence.*;
import java.util.*;

public class LikeData {
    
	private ArrayList<Like> likeList = new ArrayList<Like>();
    private List<PointDetail> pointDetailList;
    private ArrayList<String> likeIDList = new ArrayList<String>();

	private static LikeData likeData = new LikeData();
	
	private LikeData(){    }

    public static LikeData getLikeData(){
        return likeData;
    }
	
	public void activeLike(int idFood){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/PointDetail.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PointDetail p = new PointDetail();
        p.setIdAccount(Integer.parseInt(TempData.getTempData().getIdAccount()));
        p.setIdFood(idFood+1);
        Like like = likeList.get(idFood);
        String value = like.getValue();
        if(value=="L"){
            like.setValue("U");
            p.setValue("U");
            like.setSumValue(like.getSumValue()-1);
        }else {
            like.setValue("L");
            p.setValue("L");
            like.setSumValue(like.getSumValue()+1);
        }
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public ArrayList<String> getLikeIDList() {
        return likeIDList;
    }

	public ArrayList<Like> getLikeList() {
        return likeList;
    }

	public void refreshLike(){
        int idAccount;
        int foodSize = FoodData.getFoodData().getFoodShowsList().size();
        int[] likeAcc = new int[foodSize];
        int[] likeSum = new int[foodSize];
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./src/ODB/PointDetail.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<PointDetail> queryPointDetail =
                em.createQuery("SELECT a FROM ooad.PointDetail a", PointDetail.class);
        pointDetailList = queryPointDetail.getResultList();
        em.close();
        emf.close();
        idAccount = Integer.parseInt(TempData.getTempData().getIdAccount());
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
        likeList.clear();
        likeIDList.clear();
        for (int i = 1;i<=foodSize;i++){
            Like like = new Like();
            like.setId(Long.valueOf(i));
            like.setIdAcc(idAccount);
            like.setIdFood(i);
            if(likeAcc[i-1]==0){
                like.setValue("U");
            }else {
                like.setValue("L");
                likeIDList.add(String.format("%d",i));
            }
            like.setSumValue(likeSum[i-1]);
            likeList.add(like);
        }
    }

}
