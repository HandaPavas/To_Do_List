package com.example.root.to_do_list;

import java.util.ArrayList;

/**
 * Created by root on 11/4/16.
 */
public class Title {

    String title,description,date;

    public Title(String title,String description, String date){
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}
