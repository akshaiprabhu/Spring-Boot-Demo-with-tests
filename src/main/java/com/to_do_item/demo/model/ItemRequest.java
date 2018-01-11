package com.to_do_item.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class ItemRequest {

    private To_Do_Item to_do_item;

    @JsonCreator
    public ItemRequest(@JsonProperty("title") String title,
                       @JsonProperty("description") String description,
                       @JsonProperty("date") Long date) {

        to_do_item = new To_Do_Item(title, description, new Date(date));
    }


    public To_Do_Item getTo_do_item() {
        return to_do_item;
    }

    public void setTo_do_item(To_Do_Item to_do_item) {
        this.to_do_item = to_do_item;
    }
}
