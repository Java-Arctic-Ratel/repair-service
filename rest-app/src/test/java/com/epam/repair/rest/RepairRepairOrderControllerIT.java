package com.epam.repair.rest;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.RepairOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RepairRepairOrderControllerIT extends AbstractControllerIT {
    private Integer REPAIR_ORDER_ID_1 = 1;
    private Integer REPAIR_ORDER_ID_2 = 2;
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

        JSONAssert.assertEquals(loadTestFile("json/orderFindById1.json"),
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

        RepairOrder addRepairOrder = objectMapper
                .readValue(resultActions.andReturn().getResponse().getContentAsString(), RepairOrder.class);

        assertNotNull(repairOrderService.findById(addRepairOrder.getRepairOrderId()));
        JSONAssert.assertEquals(objectMapper.writeValueAsString(repairOrderService.findById(addRepairOrder.getRepairOrderId())),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void update() throws Exception {
        RepairOrder repairOrderUpdate = repairOrderService
                .add(objectMapper.readValue(loadTestFile("json/newOrder.json"), RepairOrder.class));

        RepairOrder repairOrder = repairOrderService.findById(REPAIR_ORDER_ID_2);
        repairOrderUpdate.setClient(repairOrder.getClient());

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
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/order/{repairOrderId}", REPAIR_ORDER_ID_1))
                .andExpect(status().isOk());

        assertThrows(RuntimeException.class, () -> repairOrderService.findById(REPAIR_ORDER_ID_1));
    }

    @Test
    public void findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter1?page=0&size=2")
                .param("firstName", "1")
                .param("lastName", "1")
                .param("clientPhoneNumber", "")
                .param("brandName", "")
                .param("modelName", "")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderFilterId1.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void findByRepairOrderStartDateBetween() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter2?page=0&size=2")
                .param("startDate", "2019-10-10")
                .param("endDate", "2019-10-13")
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
    public void findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter3?page=0&size=2")
                .param("firstName", "1")
                .param("lastName", "1")
                .param("clientPhoneNumber", "")
                .param("brandName", "")
                .param("modelName", "")
                .param("startDate", "2019-10-10")
                .param("endDate", "2019-10-13")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderFilterId1.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter4?page=0&size=2")
                .param("firstName", "1")
                .param("lastName", "1")
                .param("clientPhoneNumber", "")
                .param("brandName", "")
                .param("modelName", "")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderFilterId1.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void filterByStartDateJPQL() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter5?page=0&size=2")
                .param("startDate", "2019-10-10")
                .param("endDate", "2019-10-13")
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
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter6?page=0&size=2")
                .param("firstName", "1")
                .param("lastName", "1")
                .param("clientPhoneNumber", "")
                .param("brandName", "")
                .param("modelName", "")
                .param("startDate", "2019-10-10")
                .param("endDate", "2019-10-13")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderFilterId1.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter7?page=0&size=2")
                .param("firstName", "1")
                .param("lastName", "1")
                .param("clientPhoneNumber", "")
                .param("brandName", "")
                .param("modelName", "")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderFilterId1.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }

    @Test
    public void filterByStartDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter8?page=0&size=2")
                .param("startDate", "2019-10-10")
                .param("endDate", "2019-10-13")
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
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/order/filter9?page=0&size=2")
                .param("firstName", "1")
                .param("lastName", "1")
                .param("clientPhoneNumber", "")
                .param("brandName", "")
                .param("modelName", "")
                .param("startDate", "2019-10-10")
                .param("endDate", "2019-10-13")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", is(PAGE_0)))
                .andExpect(jsonPath("$.size", is(SIZE_2)));

        JSONAssert.assertEquals(loadTestFile("json/orderFilterId1.json"),
                resultActions.andReturn().getResponse().getContentAsString(), true);
    }
}