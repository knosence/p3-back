package com.skillstrom.projectthree.warehouseapi.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(ItemController.class)
public class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findById_Successful() throws Exception {
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("Test Item");
        item.setItemDescription("Test Description");
        item.setItemSize(34);

        Mockito.when(itemService.findById(1)).thenReturn(item);

        mockMvc.perform(MockMvcRequestBuilders.get("/item/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(item)));

        verify(itemService, times(1)).findById(1);
    }

    @Test
    void createItem_Successful() throws Exception {
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("Test Item");
        item.setItemDescription("Test Description");
        item.setItemSize(34);


        Mockito.when(itemService.create(item)).thenReturn(item);

        mockMvc.perform(MockMvcRequestBuilders.post("/item")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(item)));

        verify(itemService, times(1)).create(item);

    }

    @Test
    void updateItem_Successful() throws Exception {
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("Test Item");
        item.setItemDescription("Test Description");
        item.setItemSize(34);

        Mockito.when(itemService.update(item, 1)).thenReturn(item);

        mockMvc.perform(MockMvcRequestBuilders.put("/item/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(item)));

        verify(itemService, times(1)).update(item, 1);

    }

    @Test
    void deleteItemById_Successful() throws Exception {
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("Test Item");
        item.setItemDescription("Test Description");
        item.setItemSize(34);

        Mockito.when(itemService.findById(1)).thenReturn(item);
        mockMvc.perform(MockMvcRequestBuilders.delete("/item/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(itemService, times(1)).deleteById(1);

    }

    @Test
    void deleteItem_Successful() throws Exception {
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("Test Item");
        item.setItemDescription("Test Description");
        item.setItemSize(34);

        Mockito.when(itemService.findById(1)).thenReturn(item);

        mockMvc.perform(MockMvcRequestBuilders.delete("/item")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(itemService, times(1)).delete(item);
    }

}
