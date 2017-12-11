package ooad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String name; 
    private String nametag;
    private String type;

    Food(){}
    
    Food(String typeName){
        this.type=typeName;
    }

    Food(String nameFood, String nametag){
        this.name=nameFood;
        this.nametag=nametag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNametag() {
        return nametag;
    }

    public void setNametag(String recipe) {
        this.nametag = recipe;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
