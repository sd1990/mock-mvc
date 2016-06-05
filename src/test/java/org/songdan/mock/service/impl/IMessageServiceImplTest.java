package org.songdan.mock.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.songdan.mock.dao.IMessageDAO;
import org.songdan.mock.model.Message;
import org.songdan.mock.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;

public class IMessageServiceImplTest {


    @InjectMocks
    private IMessageService messageService = new IMessageServiceImpl();

    @Mock
    private IMessageDAO messageDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveMessage() {
        Message message = new Message();
        message.setName("songdan");
        message.setContent("hello songdan");
        Mockito.when(messageDAO.saveMessage(message)).thenReturn(1);
        Message saveMessage = messageService.saveMessage(message);
        Assert.assertEquals("hello songdan after save", saveMessage.getContent());
    }
}