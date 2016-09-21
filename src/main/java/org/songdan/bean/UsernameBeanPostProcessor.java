package org.songdan.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 作用于UsernBean的BeanPostProcessor
 * Created by PC on 2016/9/21.
 */
public class UsernameBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserBean) {
            System.out.println("invoke before init-method and after constructor");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserBean) {
            System.out.println("invoke after init-method");
            UserBean userBean = (UserBean) bean;
            userBean.setUsername("modify by BeanPostProcessor");
        }
        return bean;
    }
}
