package com.epam.repair.rest_app;

import com.epam.repair.rest_app.controller.AddressRestController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressRestControllerIntegrationTest {

    @Autowired
    private AddressRestController addressRestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/address")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].addressId").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]city.cityId").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]street.streetId").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].houseNumber").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].apartmentNumber").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].addressId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]city.cityId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]city.cityName", Matchers.is("Brest")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]street.streetId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]street.streetName", Matchers.is("pereulok Brestskikh Diviziy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].houseNumber", Matchers.is("17")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].apartmentNumber", Matchers.is("41")));
         }

}
