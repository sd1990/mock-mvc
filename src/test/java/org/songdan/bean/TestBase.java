package org.songdan.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by PC on 2016/9/21.
 */
public class TestBase {

    private final ApplicationContext context;

    public TestBase() {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    protected ApplicationContext getContext() {
        return context;
    }
}
