package edu.eci.cvds.servlet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import javax.faces.bean.ApplicationScoped;

@Component
@ManagedBean(name="userBean")
@ApplicationScoped

public class UserBean {
    private String name;
    public UserBean(){
    }

    public void setName(String newName){
        this.name = newName;
        System.out.println(name);
    }
}
