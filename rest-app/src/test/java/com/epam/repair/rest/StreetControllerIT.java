package com.epam.repair.rest;

import com.epam.repair.rest.controller.StreetController;
import com.epam.repair.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StreetControllerIT {

    @Autowired
    private StreetController streetController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {

        TestUtils testUtils = new TestUtils();
        String expected = testUtils.loadTestFile("json/street.json");

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/street")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        String actual = resultActions.andReturn().getResponse().getContentAsString();

        JSONAssert.assertEquals(expected, actual, true);
    }
}
