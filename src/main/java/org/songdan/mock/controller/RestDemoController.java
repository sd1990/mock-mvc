package org.songdan.mock.controller;

import org.songdan.mock.model.Message;
import org.songdan.mock.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PC on 2016/6/4.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestDemoController {

    @Autowired
    private Validator validator;

    @Autowired
    private IMessageService messageService;

    @InitBinder
    void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(validator);
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public Message getMessage(@PathVariable String name) {
        Message message = new Message();
        message.setName(name);
        message.setContent("hello , "+name);
        return message;
    }

    @RequestMapping(value = "post",method = RequestMethod.POST)
    public Message postMessage(@Validated Message message,BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException(result.getFieldErrors().toString());
        }
        Message newMessage = new Message();
        String name = message.getName();
        newMessage.setName(name);
        newMessage.setContent("hello , " + name);
        return newMessage;
    }


    @RequestMapping(value = "save/message",method = RequestMethod.POST)
    public Message saveMessage(Message message) {
        Message message1 = messageService.saveMessage(message);
        message1.setContent(message1.getContent()+" after service");
        return message1;
    }


}
