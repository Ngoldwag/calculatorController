package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CalculatorControllerIntegrationTest {
    private MockMvc mockMvc;

    private WebApplicationContext webAppContext;

    @Before
    public void setUp() {
        mockMvc= webAppContextSetup(webAppContext)
                .build();
    }

    @Test
    public void addEndPointShouldWorkAsExpected() throws Exception {
        String path = "/api/add/23/2";
        MvcResult mvcResult = mockMvc.perform(get(path))
                .andExpect(status().isOk())
                .andReturn();
        String actualResult = mvcResult.getResponse().getContentAsString();
        int actual = Integer.parseInt(actualResult);
        int expected = 25;
        assertEquals(expected, actual);

    }
    @Test
    public void MultiplyEndPointShouldWorkAsExpected() throws Exception {
        String path = "/api/multiply/23/2";
        MvcResult mvcResult = mockMvc.perform(get(path))
                .andExpect(status().isOk())
                .andReturn();
        String actualResult = mvcResult.getResponse().getContentAsString();
        int actual = Integer.parseInt(actualResult);
        int expected = 46;
        assertEquals(expected, actual);

    }

    @Test(expected = Exception.class)
    public void divideEndPointShouldReturn501() throws Exception {
        String path = "/api/divide/22/2";
        MvcResult mvcResult = mockMvc.perform(get(path))
                .andExpect(status().isNotImplemented())
                .andReturn();
        String actualResult = mvcResult.getResponse().getContentAsString();
//        int actual = Integer.parseInt(actualResult);
        assertThrows(Exception.class, () -> actualResult.length());


    }
}
//buid out multiple or divide...full thing thru