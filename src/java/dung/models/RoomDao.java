/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.models;

import dung.dtos.RoomDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Anh Dung
 */
public class RoomDao {

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

    public List<RoomDto> findByRoomId(String id) throws Exception {

        String roomid = null, type = null, image = null;
        int noPeople;
        int costs;
        List<RoomDto> list = null;
        RoomDto dto = null;
        try {
            String sql = "Select roomId,Type,NoPeople,costs,image from Rooms where RoomId Like ?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + id + "%");
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                roomid = rs.getString("roomId");
                type = rs.getString("Type");
                noPeople = rs.getInt("NoPeople");
                costs = rs.getInt("costs");
                image = rs.getString("image");
                dto = new RoomDto(roomid, type, image, noPeople, costs);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean delete(String id) throws Exception {
        try {
            String sql = "Delete from Rooms where RoomId=?";
            conn = DB.getConnection();
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

    public RoomDto findbyId(String id) throws Exception {
        String roomid = null, type = null, image = null;
        int noPeople;
        int costs;
        RoomDto dto = null;
        try {
            String sql = "Select roomId,Type,NoPeople,costs,image from Rooms where RoomId= ?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                roomid = rs.getString("roomId");
                type = rs.getString("Type");
                noPeople = rs.getInt("NoPeople");
                costs = rs.getInt("costs");
                image = rs.getString("image");
                dto = new RoomDto(roomid, type, image, noPeople, costs);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(String roomid, String type, int Nopeople, int costs, String image) throws Exception {
        try {
            String sql = "Update Rooms set Type=?,NoPeople=?,costs=?,image=? where roomId= ?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, type);
            preStm.setInt(2, Nopeople);
            preStm.setFloat(3, costs);
            preStm.setString(4, image);
            preStm.setString(5, roomid);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<RoomDto> searchRoom(String typeS, int noPeopleS, String dateIn, String DateOut) throws Exception {
        List<RoomDto> list = null;
        RoomDto dto = null;
        String roomid = null, type = null, image = null;
        int noPeople, costs;
        try {
            String sql = "select RoomId,Type,NoPeople,costs,image from Rooms where Type = ? and NoPeople >= ? and ((DateCheckIn < ? and DateCheckOut< ? )or( DateCheckIn> ? and DateCheckOut> ?))";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, typeS);
            preStm.setInt(2, noPeopleS);
            preStm.setString(3, dateIn);
            preStm.setString(4, dateIn);
            preStm.setString(5, DateOut);
            preStm.setString(6, DateOut);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                roomid = rs.getString("roomId");
                type = rs.getString("Type");
                noPeople = rs.getInt("NoPeople");
                costs = rs.getInt("costs");
                image = rs.getString("image");
                dto = new RoomDto(roomid, type, image, noPeople, costs);
                list.add(dto);
            }

        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateBook(String roomid, String dateIn, String DateOut) throws Exception {
        try {
            String sql = "Update Rooms set DateCheckIn=?,DateCheckOut=? where roomId= ?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dateIn);
            preStm.setString(2, DateOut);
            preStm.setString(3, roomid);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean updateCannel(String roomid, String username) throws Exception {
        try {
            String sql = "Update BookReport set Status=? where RoomId= ? and Username=?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Cancel");
            preStm.setString(2, roomid);
            preStm.setString(3, username);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean updateBookStatus(String roomid, String username) throws Exception {
        try {
            String sql = "Update BookReport set Status=? where RoomId= ?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Booked");
            preStm.setString(2, roomid);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean addNewRoom(String roomid, String type, int Nopeople, int costs, String image, String dateAdd) throws Exception {
        try {
            String sql = "Insert into Rooms(RoomId,Type,NoPeople,costs,image,DateCheckIn,DateCheckOut) values(?,?,?,?,?,?,?)";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, roomid);
            preStm.setString(2, type);
            preStm.setFloat(3, Nopeople);
            preStm.setInt(4, costs);
            preStm.setString(5, image);
            preStm.setString(6, dateAdd);
            preStm.setString(7, dateAdd);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean updateDate(String dateIn, String DateOut) throws Exception {
        try {
            String sql = "Update Rooms set DateCheckIn=? DateCheckOut=? where roomId= ?";
            conn = DB.getConnection();
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, dateIn);
            preStm.setString(2, DateOut);
            int n = preStm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
