package org.songdan.mock.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestDemoControllerTest {

    private MockMvc mockmvc;

    @InjectMocks
    private RestDemoController restDemoController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockmvc = MockMvcBuilders.standaloneSetup(restDemoController).build();
    }

    @Test
    public void testGetMessageJson() throws Exception {
        mockmvc.perform(get("/rest/hello/songdan.json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"songdan\",\"content\":\"hello , songdan\"}"));
    }
    @Test
    public void testGetMessageXml() throws Exception {
        mockmvc.perform(get("/rest/hello/songdan.xml"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().xml("<pizza><name>songdan</name><content>hello , songdan</content></pizza>"));
    }
}