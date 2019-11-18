package com.epam.repair.rest;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.RepairOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import javax.transaction.Transactional;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RepairRepairOrderControllerIT {
    private Integer REPAIR_ORDER_ID_1 = 1;
    private Integer REPAIR_ORDER_ID_3 = 3;
    private Integer PAGE_0 = 0;
    private Integer SIZE_2 = 2;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findAll() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/order?page=0&size=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderDTO.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void findById() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/{repairOrderId}", REPAIR_ORDER_ID_1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        JSONAssert.assertEquals(loadTestFile("json/orderFindById.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void add() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/order")
                .content(loadTestFile("json/newOrder.json"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        assertNotNull(repairOrderService.findById(REPAIR_ORDER_ID_3));
        JSONAssert.assertEquals(objectMapper.writeValueAsString(repairOrderService.findById(REPAIR_ORDER_ID_3)),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void update() throws Exception {
        RepairOrder newRepairOrder = objectMapper
                .readValue(loadTestFile("json/newOrder.json"), RepairOrder.class);

        RepairOrder repairOrderUpdate = repairOrderService.findById(REPAIR_ORDER_ID_1);
        repairOrderUpdate.setClient(newRepairOrder.getClient());

        String jsonOrderUpdate = objectMapper.writeValueAsString(repairOrderUpdate);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonOrderUpdate))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception {
        RepairOrder newRepairOrder = objectMapper
                .readValue(loadTestFile("json/newOrder.json"), RepairOrder.class);

        RepairOrder addRepairOrder = repairOrderService.add(newRepairOrder);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/order/{repairOrderId}", addRepairOrder.getRepairOrderId()))
                .andExpect(status().isOk());

        assertThrows(RuntimeException.class, () -> repairOrderService.findById(REPAIR_ORDER_ID_3));
    }
}