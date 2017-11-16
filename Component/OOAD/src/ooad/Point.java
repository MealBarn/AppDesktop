/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import static java.nio.charset.StandardCharsets.*;

/**
 *
 * @author Panisa
 */
@Entity
public class Point implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long idprimary;
   // private Integer id; 
    private Integer point=0;
    
//    Point(Integer IdentityNumber){
//        this.id=IdentityNumber;
//        //this.name=nameFood;
//    }

    public Long getIdprimary() {
        return idprimary;
    }

    public void setIdprimary(Long id) {
        this.idprimary = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point++;
    }

     @Override
    public String toString() {
        return String.format("(%d, %d)", this.idprimary, this.point);
    }
    
    
    
    
}
