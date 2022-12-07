package dto;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

public class Dessert implements Serializable {
    private String dessertName;
    private long dessertId;

    public Dessert(String dessertName, int i) {
        this.dessertId = i;
        this.dessertName = dessertName;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public long getDessertId() {
        return dessertId;
    }

    public void setDessertId(long dessertId) {
        this.dessertId = dessertId;
    }
}
