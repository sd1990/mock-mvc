package org.songdan.mock.org.songdan.bean;

import org.junit.Assert;
import org.junit.Test;
import org.songdan.bean.TestBase;
import org.songdan.bean.UserBean;
import org.springframework.context.ApplicationContext;

/**
 * Created by PC on 2016/9/21.
 */
public class BeanFactoryPostProcessorTest extends TestBase {

    @Test
    public void test() {
        ApplicationContext context = getContext();
        UserBean userBean = (UserBean) context.getBean("userBean");
        Assert.assertSame("songdan",userBean.getUsername());
    }

}
