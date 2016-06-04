package org.songdan.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SpringMVC 普通方法Controller
 * Created by PC on 2016/6/4.
 */
@Controller
@RequestMapping("custom")
public class CustomerController {

    @RequestMapping("sayHello")
    public void sayHello() {
        System.out.println("hello spring mvc 4.2.5");
    }
    @RequestMapping("sayHello2")
    @ResponseBody
    public void sayHello2() {
        System.out.println("hello spring mvc 4.2.5 again");
    }

    @RequestMapping("{variable}")
    @ResponseBody
    public void testPathVariable(@PathVariable("variable") String id) {
        System.out.println(id);
    }

}
