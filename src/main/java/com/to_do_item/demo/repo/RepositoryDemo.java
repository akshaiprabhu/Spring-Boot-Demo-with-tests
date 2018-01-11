package com.to_do_item.demo.repo;

import com.to_do_item.demo.model.To_Do_Item;

import java.util.ArrayList;
import java.util.List;

public class RepositoryDemo {
    private List<To_Do_Item> to_do_itemList;

    public RepositoryDemo() {
        to_do_itemList = new ArrayList<>();
    }

    public To_Do_Item addNewItem(Integer id, To_Do_Item to_do_item) {
        to_do_item.setId(id);
        for(To_Do_Item item: to_do_itemList){
            if(item.getId().equals(id)) {
                return null;
            }
        }
        to_do_itemList.add(to_do_item);
        return to_do_item;
    }

    public To_Do_Item getItem(Integer id) {
        for(To_Do_Item item: to_do_itemList){
            if(item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public To_Do_Item patchItem(Integer id, To_Do_Item to_do_item) {
        for(To_Do_Item item: to_do_itemList) {
            if(item.getId().equals(id)) {
                item.setTitle(to_do_item.getTitle());
                item.setDescription(to_do_item.getDescription());
                item.setDate(to_do_item.getDate());
                return item;
            }
        }
        return null;

    }
    public List<To_Do_Item> getTo_do_itemList() {
        return to_do_itemList;
    }

    public void setTo_do_itemList(List<To_Do_Item> to_do_itemList){
        this.to_do_itemList = to_do_itemList;
    }
}
