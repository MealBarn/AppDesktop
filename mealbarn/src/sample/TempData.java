package sample;

import ooad.FoodShow;
import ooad.Like;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    private int page;

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountFill() {
        return accountFill;
    }

    public void setAccountFill(String accountFill) {
        this.accountFill = accountFill;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String account;
    private String accountFill;
    private String password;
    private String idAccount;
    private boolean isRemember= true;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
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

    private ArrayList<String> sortLike(ArrayList<String > iDListTemp){
        ArrayList<Like> likeList = LikeData.getLikeData().getLikeList();
        int n = iDListTemp.size();
        boolean isSwitch;
        do{
            isSwitch = false;
            int idNow;
            int idPrev;
            int likeNow;
            int likePrev;
            for(int i = 1 ;i<n;i++)
            {
                idNow = Integer.parseInt(iDListTemp.get(i));
                idPrev= Integer.parseInt(iDListTemp.get(i-1));
                likeNow = likeList.get(idNow-1).getSumValue();
                likePrev = likeList.get(idPrev-1).getSumValue();
                if(likePrev<likeNow){
                    Collections.swap(iDListTemp,i,i-1);
                    isSwitch =true;
                }
            }
            n=n-1;
        }while (isSwitch);
        return iDListTemp;
    }

    public void setShowIDList(ArrayList<String> showIDList) {
        this.showIDList = sortLike(showIDList);
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
