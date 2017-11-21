package sample;

import ooad.FoodShow;

import java.util.*;

public class TempData {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int idFood;
    private String mode;
    private int page;
    private ArrayList<String> showIDList = new ArrayList<String>();
    private static TempData tempData = new TempData();
    private TempData(){
        foodShowsList = FoodData.getFoodData().getFoodShowsList();
    }
    List<FoodShow> foodShowsList;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public ArrayList<String> getShowIDList() {
        return showIDList;
    }

    public void setShowIDList() {
        showIDList.clear();

        for (FoodShow food : foodShowsList){
            if(food.getPerfect()>0){
                showIDList.add(food.getId().toString());
            }
        }
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

    public static TempData getTempData() {
        return tempData;
    }
}
