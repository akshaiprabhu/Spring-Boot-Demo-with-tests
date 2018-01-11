package com.to_do_item.demo.controller;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MyRestControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new MyRestController()).build();
    }

    @Test
    public void getAllItemsTest() throws Exception {
        mockMvc.perform(
                get("/api/getAllItems"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getItemFailTest() throws Exception {
        mockMvc.perform(
                get("/api/getItems/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchForItemFailTest() throws Exception {
        mockMvc.perform(
                get("/api/patchForItem/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

