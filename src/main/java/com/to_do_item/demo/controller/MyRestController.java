package com.to_do_item.demo.controller;

import com.to_do_item.demo.model.ItemRequest;
import com.to_do_item.demo.model.ItemResponse;
import com.to_do_item.demo.model.To_Do_Item;
import com.to_do_item.demo.repo.RepositoryDemo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
class MyRestController {
    int idCounter = 0;
    RepositoryDemo repositoryDemo = new RepositoryDemo();

    @RequestMapping(path = "/getAllItems", method = RequestMethod.GET,
                produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        List<ItemResponse> itemResponseList = new ArrayList<>();
        for(To_Do_Item to_do_item: repositoryDemo.getTo_do_itemList()) {
            itemResponseList.add(
                    new ItemResponse(
                            to_do_item.getId(),
                            to_do_item.getTitle(),
                            to_do_item.getDescription(),
                            to_do_item.getDate().getTime()
                    )
            );
        }

        return new ResponseEntity<>(itemResponseList,
                HttpStatus.OK
        );
    }

    @RequestMapping(path = "/getItem/{id}", method = RequestMethod.GET,
                produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    public ResponseEntity<ItemResponse> getItem(@Valid @PathVariable Integer id) {
        To_Do_Item to_do_item = repositoryDemo.getItem(id);
        if(to_do_item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ItemResponse(
                to_do_item.getId(),
                to_do_item.getTitle(),
                to_do_item.getDescription(),
                to_do_item.getDate().getTime()),
                HttpStatus.OK
        );
    }

    @RequestMapping(path="", method = RequestMethod.POST,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    public ResponseEntity<ItemResponse> createNewItem(@RequestBody ItemRequest request) {
        try {
            if(request.getTo_do_item().getTitle() == null ||
                    request.getTo_do_item().getDescription() == null ||
                    request.getTo_do_item().getDate() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            To_Do_Item thisItem = repositoryDemo.addNewItem(idCounter++, request.getTo_do_item());

            return new ResponseEntity<>(new ItemResponse(
                    thisItem.getId(),
                    thisItem.getTitle(),
                    thisItem.getDescription(),
                    thisItem.getDate().getTime()),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path="/patchForItem/{id}", method = RequestMethod.PATCH,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    public ResponseEntity<ItemResponse> patchForItem(@PathVariable Integer id,
                                                     @RequestBody ItemRequest request) {
        try {
            if(request.getTo_do_item().getTitle() == null ||
                    request.getTo_do_item().getDescription() == null ||
                    request.getTo_do_item().getDate() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            To_Do_Item thisItem = repositoryDemo.patchItem(id, request.getTo_do_item());


            return new ResponseEntity<>(new ItemResponse(
                    thisItem.getId(),
                    thisItem.getTitle(),
                    thisItem.getDescription(),
                    thisItem.getDate().getTime()),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
