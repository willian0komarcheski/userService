package com.example.libs.model;

import com.example.libs.annotations.entity.ColumnName;
import com.example.libs.annotations.entity.TableName;

@TableName(name = "User")
public class UserModel {
    
    @ColumnName(name = "Uid", primaryKey = true)
    private Long Id;

    @ColumnName(name = "username")
    private String Username;
    
    @ColumnName(name = "password")
    private String Password;

    public UserModel() {}

    public UserModel(Long id, String username, String password) {
        this.Id = id;
        this.Username = username;
        this.Password = password;
    }

    public Long getId() { return this.Id; }

    public void setId(Long id) { this.Id = id; }

    public String getUsername() { return this.Username; }

    public void setUsername(String username) { this.Username = username; }

    public String getPassword() { return this.Password; }

    public void setPassword(String password) { this.Password = password; }
}
