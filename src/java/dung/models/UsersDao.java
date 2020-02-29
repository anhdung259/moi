/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.models;

import dung.dtos.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Anh Dung
 */
public class UsersDao {

    Connection conn;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public void closeConnection() throws Exception {
        if (conn != null) {
            conn.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public String checkLogin(String Username, String Password) throws Exception {
        String role = "failed";
        try {
            String sql = "Select Role from Users where Username =? and Password=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            preStm.setString(2, Password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean insertUser(String username, String Password, String Email, String Fullname, String Address, String PhoneNo) throws Exception {
        try {
            String sql = "Insert into Users(Username,Password,Email,Role,Fullname,Address,NumberPhone) Values(?,?,?,?,?,?,?)";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, Password);
            preStm.setString(3, Email);
            preStm.setString(4, "user");
            preStm.setString(5, Fullname);
            preStm.setString(6, Address);
            preStm.setString(7, PhoneNo);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public UserDto findbyPrimaryKey(String id) throws Exception {
        UserDto dto = null;
        String Email, NumberPhone;
        try {
            String sql = "Select Email,NumberPhone from Users where Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                Email = rs.getString("Email");
                NumberPhone = rs.getString("NumberPhone");
                dto = new UserDto(Email, NumberPhone);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public UserDto profile(String username) throws Exception {
        UserDto dto = null;
        String Password, Email, Fullname, Address, NumberPhone;
        try {
            String sql = "Select Password,Email,Fullname,Address,NumberPhone from Users where Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {

                Password = rs.getString("Password");
                Email = rs.getString("Email");
                Fullname = rs.getString("Fullname");
                Address = rs.getString("Address");
                NumberPhone = rs.getString("NumberPhone");
                dto = new UserDto(username, Password, Email, Fullname, Address, NumberPhone);

            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateProfile(String username, String Password, String Email, String Fullname, String Address, String PhoneNo) throws Exception {
        try {
            String sql = "Update Users set Password=?,Email=?,Fullname=?,Address=?,NumberPhone=? where Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Password);
            preStm.setString(2, Email);
            preStm.setString(3, Fullname);
            preStm.setString(4, Address);
            preStm.setString(5, PhoneNo);
            preStm.setString(6, username);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<UserDto> listUser() throws Exception {
        UserDto dto = null;
        List<UserDto> list = null;
        String Username, Password, Email, Fullname, Address, NumberPhone;
        try {
            String sql = "Select Username,Password,Email,Fullname,Address,NumberPhone from Users where Role= 'user'";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            list = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                Username = rs.getString("Username");
                Password = rs.getString("Password");
                Email = rs.getString("Email");
                Fullname = rs.getString("Fullname");
                Address = rs.getString("Address");
                NumberPhone = rs.getString("NumberPhone");
                dto = new UserDto(Username, Password, Email, Fullname, Address, NumberPhone);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean deleteUser(String id) throws Exception {
        try {
            conn = DB.getConnection();
            String sql = "Delete from Users where Username=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean addCode(String username) throws Exception {
        try {
            String sql = "Update Users set CodeStatus=1 where Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean checkCode(String username) throws Exception {
        boolean codestatus = false;
        try {
            String sql = "Select CodeStatus from Users where Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                codestatus=rs.getBoolean("CodeStatus");

            }
        } finally {
            closeConnection();
        }
        return codestatus;
    }
}
