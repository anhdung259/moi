/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import dung.models.UsersDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pham Anh Dung
 */
public class UsersBeans implements Serializable {

    String username, password, email, role, fullname, address, phoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String checkLogin() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.checkLogin(username, password);
    }

    public boolean insert() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.insertUser(username, password, email, fullname, address, phoneNo);
    }

    public UserDto findByKey() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.findbyPrimaryKey(username);
    }

    public UserDto profileUser() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.profile(username);
    }

    public boolean UpdateProfile() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.updateProfile(username, password, email, fullname, address, phoneNo);
    }
    public List<UserDto> listUser()throws Exception{
        UsersDao dao = new UsersDao();
        return dao.listUser();
    }
      public boolean deleteUser() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.deleteUser(username);
    }
     public boolean addCode() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.addCode(username);
    } 
      public boolean checkCode() throws Exception {
        UsersDao dao = new UsersDao();
        return dao.checkCode(username);
    } 
}
