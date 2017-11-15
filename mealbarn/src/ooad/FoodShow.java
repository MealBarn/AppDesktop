package ooad;

public class FoodShow {
    private Long id;
    private String name;
    private int amount;
    private float perfect;
    FoodShow(){ }
    public FoodShow(Long foodID,String foodName, int foodAmount){
        this.id = foodID;
        this.name = foodName;
        this.amount = foodAmount;
        perfect = 0;
    }

    public void setPerfect(float newPerfect){
        this.perfect = newPerfect;
    }

    public void clearPerfect(){
        this.perfect = 0;
    }

    public void addPerfect(){
        float tmp = perfect+=(100/amount);
        this.perfect = tmp;
    }

    public Long getId(){ return id;}

    public String getName() { return name; }

    public int getAmount() {return amount;}

    public float getPerfect() { return perfect;}

    public String toString(){return String.format("%d %s %s %s",this.id,this.name,this.amount,this.perfect);}
}
