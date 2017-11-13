/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Panisa
 */
@Entity
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long idprimary;
    private Integer id; 
    private String component;
    
    Component(){
        //this.id=IdentityNumber;
        //this.name=nameFood;
    }

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
    public String toString(){return String.format("%d,%d,%s",this.idprimary,this.id,this.component);}
    
    
    
}
