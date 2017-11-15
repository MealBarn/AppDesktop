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

/**
 *
 * @author Panisa
 */
@Entity
public class RecipePath implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idFood;
    private String pathRecipe;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdFood() {
        return idFood;
    }

    public void setIdFood(Long idFood) {
        this.idFood = idFood;
    }

    public String getPathRecipe() {
        return pathRecipe;
    }

    public void setPathRecipe(String pathRecipe) {
        this.pathRecipe = pathRecipe;
    }

    @Override
    public String toString() {
        return "RecipePath{" + "pathRecipe=" + pathRecipe + '}';
    }

    
    
}
