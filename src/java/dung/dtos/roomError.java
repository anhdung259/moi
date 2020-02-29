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
public class roomError implements Serializable{
     private String roomidErr,roomidExist, typeErr, statusErr, image, noPeopleErr,costsErr;

    public String getRoomidExist() {
        return roomidExist;
    }

    public void setRoomidExist(String roomidExist) {
        this.roomidExist = roomidExist;
    }
     

    public String getRoomidErr() {
        return roomidErr;
    }

    public void setRoomidErr(String roomidErr) {
        this.roomidErr = roomidErr;
    }

    public String getTypeErr() {
        return typeErr;
    }

    public void setTypeErr(String typeErr) {
        this.typeErr = typeErr;
    }

    public String getStatusErr() {
        return statusErr;
    }

    public void setStatusErr(String statusErr) {
        this.statusErr = statusErr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNoPeopleErr() {
        return noPeopleErr;
    }

    public void setNoPeopleErr(String noPeopleErr) {
        this.noPeopleErr = noPeopleErr;
    }

    public String getCostsErr() {
        return costsErr;
    }

    public void setCostsErr(String costsErr) {
        this.costsErr = costsErr;
    }


}
