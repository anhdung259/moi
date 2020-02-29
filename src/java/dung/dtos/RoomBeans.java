/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import dung.models.RoomDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pham Anh Dung
 */
public class RoomBeans implements Serializable {

    private String roomid, type, status, image,dateIn,dateOut,dateAdd;
    private int noPeople,costs,NumDate;

    public int getNumDate() {
        return NumDate;
    }

    public void setNumDate(int NumDate) {
        this.NumDate = NumDate;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }


    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }



    public List<RoomDto> findByRoom() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.findByRoomId(roomid);
    }

    public boolean delete() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.delete(roomid);
    }

    public RoomDto findbyid() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.findbyId(roomid);
    }

    public boolean update() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.update(roomid, type,noPeople, costs, image);
    }
     public List<RoomDto> searchRoom() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.searchRoom(type, noPeople,dateIn, dateOut);
    }
       public boolean updateBook() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.updateBook(roomid,dateIn, dateOut);
    }
 
       public boolean addNewRoom() throws Exception{
           RoomDao dao = new RoomDao();
           return dao.addNewRoom(roomid, type,noPeople, costs, image,dateIn);
       }
 
}
