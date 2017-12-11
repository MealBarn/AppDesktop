package ooad;

public class FoodShow {

    private Long id;
    private String name;
    private String nametag;
    private int amount;
    private float perfect;

    FoodShow(){ }

    public FoodShow(Long foodID,String foodName,String foodNametag,int foodAmount){
        this.id = foodID;
        this.name = foodName;
        this.nametag = foodNametag;
        this.amount = foodAmount;
        perfect = 0;
    }

    public void addPerfect(){
        float tmp = perfect+=(100/amount);
        this.perfect = tmp;
    }

    public void clearPerfect(){
        this.perfect = 0;
    }

    public Long getId(){ return id;}

    public String getName() { return name; }

    public String getNametag() { return nametag; }

    public int getAmount() {return amount;}

    public float getPerfect() { return perfect;}

    public void setPerfect(float newPerfect){
        this.perfect = newPerfect;
    }

}
