package com.example.userService.model;

import com.example.libs.annotations.entity.*;

@TableName(name = "users")
public class UserModel {
    
    @ColumnName(name = "id", primaryKey = true)
    private int Id;
    
    @ColumnName(name = "name")
    private String Name;

    @ColumnName(name = "password")
    private String Password;

    public UserModel() {}

    public UserModel(String name, String password) {
        this.Name = name;
        this.Password = password;
    }

    public int getId() { return this.Id; }

    public void setId(int id) { this.Id = id; }

    public String getName() { return this.Name; }

    public void setName(String name) { this.Name = name; }

    public String getPassword() { return this.Password; }

    public void setPassword(String password) { this.Password = password; }
}
