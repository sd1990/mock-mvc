package org.songdan.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * BeanFactory后置处理方法
 * Created by PC on 2016/9/21.
 */
public class UsernameBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("bean factory post processor modify userBean's properties username");
        BeanDefinition userBean = beanFactory.getBeanDefinition("userBean");
        MutablePropertyValues propertyValues = userBean.getPropertyValues();
        propertyValues.addPropertyValue("username","songdan");
    }
}
