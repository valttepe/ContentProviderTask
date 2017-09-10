package com.example.valtteri.contentprovidertask;

/**
 * Created by Valtteri on 10/09/2017.
 */

public class President {

    String name;
    String years;
    String description;

    public President(String name, String years, String description){
        this.name = name;
        this.years = years;
        this.description = description;
    }

    public String toString (){
        return name + " " + years;
    }

    public String getDescription () {
        return description;
    }
}
