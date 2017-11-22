package com.example.kevin.recetas;

import java.io.Serializable;

/**
 * Created by kevin on 11/11/17.
 */

public class Receta implements Serializable {

    private String title;
    private Integer img;
    private String todo;

    public Receta(String title, Integer img, String todo) {
        this.title = title;
        this.img = img;
        this.todo = todo;
    }

    public String getTitle() {
        return title;
    }

    public Integer getImg() {
        return img;
    }

    public String getTodo() {
        return todo;
    }
}
