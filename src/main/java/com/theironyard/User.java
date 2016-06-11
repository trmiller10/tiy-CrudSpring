package com.theironyard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Taylor on 6/11/16.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @Column
    private String name;
    @Column
    private String password;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
