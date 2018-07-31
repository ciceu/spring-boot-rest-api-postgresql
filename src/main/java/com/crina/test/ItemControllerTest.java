package com.crina.test;
import com.crina.controller.ItemRestController;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.crina.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemRestController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private ItemRestController itemRestController;

    @Test
    public void findAllItems() throws Exception {
        Item item = new Item ("Task 2", "new");

        List<Item> items = new ArrayList<Item>();
        items.add(item);

        given(itemRestController.getAllItems()).willReturn(items);

        mvc.perform(get("/items").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is(item.getName())));
    }

    @Test
    public void findItemById() throws Exception {

        Item item = new Item ("Task 2", "new");

        given(itemRestController.getItemById(item.getId())).willReturn(item);
        mvc.perform(get("/" + item.getId()).contentType(MediaType.APPLICATION_JSON)).equals(item);
    }

    @Test
    public void addItem() throws Exception{
        Item item = new Item ("Task 2", "new");

        given(itemRestController.addItem(item)).willReturn(item);
        mvc.perform(post("/items/addItem").contentType(MediaType.APPLICATION_JSON)).equals(item);

    }

}

