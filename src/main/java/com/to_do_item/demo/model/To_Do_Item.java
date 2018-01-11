package com.to_do_item.demo.model;


import java.util.Date;


public class To_Do_Item {

    private Integer id;
    private String title;
    private String description;
    private Date date;


    public To_Do_Item(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public To_Do_Item(Integer id, String title, String description, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
