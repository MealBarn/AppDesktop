package ooad;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PointDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private int idAccount;
    private int idFood;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String value;

    public PointDetail(){}

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PointDetail{" +
                "id=" + id +
                ", idAccount=" + idAccount +
                ", idFood=" + idFood +
                ", value='" + value + '\'' +
                '}';
    }
}
