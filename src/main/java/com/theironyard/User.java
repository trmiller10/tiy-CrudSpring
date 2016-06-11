package com.theironyard;

import javax.persistence.*;

/**
 * Created by Taylor on 6/11/16.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @Column
    private String userName;
    @Column
    private String password;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
