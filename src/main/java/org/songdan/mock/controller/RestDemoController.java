package org.songdan.mock.controller;

import org.songdan.mock.model.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PC on 2016/6/4.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestDemoController {

    @RequestMapping("hello/{name}")
    public Message getMessage(@PathVariable String name) {
        Message message = new Message();
        message.setName(name);
        message.setContent("hello , "+name);
        return message;
    }

}
