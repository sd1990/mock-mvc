package org.songdan.mock.controller;

import mockit.Tested;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testSayHello() throws Exception {
//        mockMvc.perform(get("/custom/sayHello.do")).andDo(print()).andExpect(status().isOk());
        mockMvc.perform(get("/custom/sayHello.do")).andExpect(status().isOk());
    }

    @Test
    public void testSayHello2() throws Exception {
        mockMvc.perform(get("/custom/sayHello2.do")).andExpect(status().isOk());
    }

    @Test
    public void testTestPathVariable() throws Exception {
        mockMvc.perform(get("/custom/123456789.do")).andExpect(status().isOk());
    }

}