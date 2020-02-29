/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.models;

import dung.dtos.BookDto;
import dung.dtos.RoomDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Anh Dung
 */
public class BookDao {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

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

    public boolean bookRoom(String Username, String RoomId, String DateCheckIn, String DateCheckOut,
            String DateBook, int TotalCost) throws Exception {
        try {
            String sql = "Insert into BookingView(Username,RoomId,DateCheckIn,DateCheckOut,DateBook,TotalCost) "
                    + "values (?,?,?,?,?,?)";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            preStm.setString(2, RoomId);
            preStm.setString(3, DateCheckIn);
            preStm.setString(4, DateCheckOut);
            preStm.setString(5, DateBook);
            preStm.setInt(6, TotalCost);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<BookDto> findBookRoom(String Username) throws Exception {
        List<BookDto> list = null;
        BookDto dto = null;
        String RoomId, DateCheckIn, DateCheckOut, DateBook;
        int TotalCost;
        try {
            list = new ArrayList<>();
            String sql = "Select RoomId,DateCheckIn,DateCheckOut,DateBook,TotalCost from BookingView where Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            rs = preStm.executeQuery();
            while (rs.next()) {
                RoomId = rs.getString("RoomId");
                DateCheckIn = rs.getString("DateCheckIn");
                DateCheckOut = rs.getString("DateCheckOut");
                DateBook = rs.getString("DateBook");
                TotalCost = rs.getInt("TotalCost");
                dto = new BookDto(Username, RoomId, DateCheckIn, DateCheckOut, DateBook, TotalCost);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BookDto> Report() throws Exception {
        List<BookDto> list = null;
        BookDto dto = null;
        String RoomId, DateCheckIn, DateCheckOut, DateBook, Username, Status;
        int TotalCost;
        try {
            list = new ArrayList<>();
            String sql = "Select Username,RoomId,DateCheckIn,DateCheckOut,DateBook,TotalCost,Status from BookReport";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                Username = rs.getString("Username");
                RoomId = rs.getString("RoomId");
                DateCheckIn = rs.getString("DateCheckIn");
                DateCheckOut = rs.getString("DateCheckOut");
                DateBook = rs.getString("DateBook");
                TotalCost = rs.getInt("TotalCost");
                Status = rs.getString("Status");
                dto = new BookDto(Username, RoomId, DateCheckIn, DateCheckOut, DateBook, Status, TotalCost);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean delete(String roomid) throws Exception {
        try {
            String sql = "Delete from Bookingview where RoomId=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roomid);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean bookReport(String Username, String RoomId, String DateCheckIn, String DateCheckOut,
            String DateBook, int TotalCost) throws Exception {
        try {
            String sql = "Insert into BookReport(Username,RoomId,DateCheckIn,DateCheckOut,DateBook,TotalCost) "
                    + "values (?,?,?,?,?,?)";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            preStm.setString(2, RoomId);
            preStm.setString(3, DateCheckIn);
            preStm.setString(4, DateCheckOut);
            preStm.setString(5, DateBook);
            preStm.setInt(6, TotalCost);

            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean checkBook(String Username, String RoomId) throws Exception {
        try {
            String sql = "select * from Rooms where Username=? and RoomId=? ";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            preStm.setString(2, RoomId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
