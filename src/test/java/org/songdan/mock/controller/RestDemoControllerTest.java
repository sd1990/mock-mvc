package org.songdan.mock.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.songdan.mock.model.Message;
import org.songdan.mock.service.IMessageService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestDemoControllerTest {

    private MockMvc mockmvc;

    @InjectMocks
    private RestDemoController restDemoController;

    @Mock
    private Validator validator;

    @Mock
    private IMessageService messageService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockmvc = MockMvcBuilders.standaloneSetup(restDemoController).build();
        when(validator.supports(any(Class.class))).thenReturn(true);
    }

    @Test
    public void testGetMessage() throws Exception {
        Message message = new Message();
        message.setName("songdan");
        message.setContent("hello , songdan");
        mockmvc.perform(get("/rest/hello/songdan.do")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"songdan\",\"content\":\"hello , songdan\"}"))
                .andReturn();
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

    @Test
    public void testPostMessageJson() throws Exception {
        mockmvc.perform(post("/rest/post.json").param("name","songdan"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"songdan\",\"content\":\"hello , songdan\"}"));
    }
    @Test
    public void testPostMessageJsonWithValidate() throws Exception {
//        when(validator.validate(anyObject(),any(Errors.class)))
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Errors errors = (Errors) invocationOnMock.getArguments()[1];
                errors.rejectValue("name","can't be empty");
                return null;
            }
        }).when(validator).validate(anyObject(), any(Errors.class));
//        doNothing().when(validator).validate(anyObject(),any(Errors.class));
        mockmvc.perform(post("/rest/post.json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"songdan\",\"content\":\"hello , songdan\"}"));
    }

    @Test
    public void testSaveMessage() throws Exception {
        Message message = new Message();
        message.setName("songdan");
        message.setContent("hello,songdan");
        when(messageService.saveMessage(message)).thenAnswer(new Answer<Message>() {

            @Override
            public Message answer(InvocationOnMock invocation) throws Throwable {
                Message message = (Message) invocation.getArguments()[0];
                message.setContent(message.getContent()+" after save");
                return message;
            }
        });
        mockmvc.perform(post("/rest/save/message.json").param("name","songdan").param("content","hello,songdan"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"songdan\",\"content\":\"hello,songdan after save after service\"}"));
    }




























}