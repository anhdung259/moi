/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import java.io.Serializable;

/**
 *
 * @author Pham Anh Dung
 */
public class UserDto implements Serializable{
    String username,password,email,role,fullname,address,numberPhone;

    public UserDto(String username, String password, String email, String role, String fullname, String address, String numberPhone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.fullname = fullname;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    public UserDto(String username, String password, String email, String fullname, String address, String numberPhone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    public UserDto(String email, String numberPhone) {
        this.email = email;
        this.numberPhone = numberPhone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
