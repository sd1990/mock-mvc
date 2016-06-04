package org.songdan.mock.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO类 信息类
 * Created by PC on 2016/6/4.
 */
@XmlRootElement(name = "pizza")
public class Message {


    private String name;


    private String content;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
