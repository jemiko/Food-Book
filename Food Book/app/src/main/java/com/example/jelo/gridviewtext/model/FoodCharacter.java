package com.example.jelo.gridviewtext.model;

import java.io.Serializable;

/**
 * Created by jelo on 7/17/2015.
 */
public class FoodCharacter implements Serializable {
    private String name ,discription ,image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FoodCharacter{" +
                "name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public FoodCharacter(String name, String discription, String image) {
        this.name = name;
        this.discription = discription;
        this.image = image;

    }
}
