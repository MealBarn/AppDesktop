package sample;

import ooad.Food;
import ooad.FoodShow;
import ooad.Like;

import java.util.*;

public class LikeData {
    private ArrayList<Like> likeList = new ArrayList<>();
    private static LikeData likeData = new LikeData();
    private LikeData(){}

    public static LikeData getLikeData(){
        return likeData;
    }

    private void openFile(){
    }

    private void setData(){
        likeList.clear();
        int idAccount = Integer.parseInt(TempData.getTempData().getIdAccount());
        ArrayList<FoodShow> foodList = FoodData.getFoodData().getFoodShowsList();
        for (int i = 0;i<foodList.size();i++){
            Like like = new Like();
            like.setId(Long.valueOf(i));
            like.setIdAcc(idAccount);
            like.setIdFood(i+1);
            if(((Math.random()*100)%2)>1){
                like.setValue(null);
            }else {
                like.setValue("L");
            }
            like.setSumValue((int)(Math.random()*100));
            likeList.add(like);
        }
    }

    public ArrayList<Like> getLikeList() {
        return likeList;
    }

    public void refreshLike(){
        setData();
//        for (Like like : likeList){
//            System.out.println(like);
//
//        }
    }

    public void activeLike(int idFood){
        Like like = likeList.get(idFood);
        String value = like.getValue();
        if(value=="L"){
            like.setValue(null);
            like.setSumValue(like.getSumValue()-1);
        }else {
            like.setValue("L");
            like.setSumValue(like.getSumValue()+1);
        }
        System.out.println(likeList.get(idFood).toString());
    }


}
