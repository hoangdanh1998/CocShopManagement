/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.user;

import java.io.Serializable;

/**
 *
 * @author Hoang Danh
 */
public class UserDTO implements Serializable{
    private String username, password, fullname, role, address, phone;

    public UserDTO() {
    }
    
    public UserDTO(String username, String fullname, String role, String address, String phone) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.address = address;
        this.phone = phone;
    }
    
    public UserDTO(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }
    
    
    public UserDTO(String username, String password, String fullname, String role, String address, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.address = address;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
