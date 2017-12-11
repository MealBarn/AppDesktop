package ooad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long idprimary;
    private Integer id; 
    private String component;
    
    Component(){    }

    public Long getIdprimary() {
        return idprimary;
    }

    public void setIdprimary(Long id) {
        this.idprimary = id;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id= id;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}
