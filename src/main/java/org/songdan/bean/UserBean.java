package org.songdan.bean;

/**
 * 用来测试Spring Bean 创建的Demo
 * Created by PC on 2016/9/21.
 */
public class UserBean {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("before set properties username is :"+this.username);
        this.username = username;
        System.out.println("after set properties username is :"+this.username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username:"+username + " password : "+ password;
    }
}
