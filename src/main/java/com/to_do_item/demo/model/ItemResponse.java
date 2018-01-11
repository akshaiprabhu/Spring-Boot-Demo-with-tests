package com.to_do_item.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ItemResponse {

    public final To_Do_Item to_do_item;

    @JsonCreator
    public ItemResponse(@JsonProperty("id") Integer id,
                        @JsonProperty("title") String title,
                        @JsonProperty("description") String description,
                        @JsonProperty("date") Long date) {
        to_do_item = new To_Do_Item(id, title, description, new Date(date));
    }
}
