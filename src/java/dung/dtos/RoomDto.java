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
public class RoomDto implements Serializable {

    private String roomid, type, status, image, dateIn, dateOut;
    private int noPeople, costs, numDate, pay;

    public RoomDto() {
    }

    public int getNumDate() {
        return numDate;
    }

    public void setNumDate(int numDate) {
        this.numDate = numDate;
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

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public RoomDto(String roomid, String type, String image, int noPeople, int costs) {
        this.roomid = roomid;
        this.type = type;
        this.image = image;
        this.noPeople = noPeople;
        this.costs = costs;
    }

    public RoomDto(String roomid, String type, String image, int NumDate, int noPeople, int costs) {
        this.roomid = roomid;
        this.type = type;
        this.image = image;
        this.numDate = NumDate;
        this.noPeople = noPeople;
        this.costs = costs;
    }

    public RoomDto(String roomid, String type, String image, String dateIn, String dateOut, int costs, int numDate, int pay) {
        this.roomid = roomid;
        this.type = type;
        this.image = image;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.costs = costs;
        this.numDate = numDate;
        this.pay = pay;
    }

    public RoomDto(String roomid, String type, String image) {
        this.roomid = roomid;
        this.type = type;
        this.image = image;
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

}
