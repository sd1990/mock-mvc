package org.songdan.mock.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO类 信息类
 * Created by PC on 2016/6/4.
 */
@XmlRootElement(name = "pizza")
public class Message {

    @NotEmpty
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Message) {
            Message other = (Message) obj;
            return name.equals(other.name) && content.equals(other.content);
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 33;
        hash = name.hashCode() + hash;
        hash = content.hashCode() + hash;
        return hash;
    }
}
