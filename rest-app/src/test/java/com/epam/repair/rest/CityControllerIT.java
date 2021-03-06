package com.epam.repair.rest;

import com.epam.repair.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class CityControllerIT extends AbstractControllerIT{
    private Integer PAGE_0 = 0;
    private Integer SIZE_2 = 2;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {

        TestUtils testUtils = new TestUtils();
        String expected = testUtils.loadTestFile("json/city.json");

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/city?page=0&size=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        String actual = resultActions.andReturn().getResponse().getContentAsString();

        JSONAssert.assertEquals(expected, actual, true);
    }
}