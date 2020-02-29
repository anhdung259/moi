/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import dung.models.BookDao;
import dung.models.RoomDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pham Anh Dung
 */
public class BookBeans implements Serializable {

    String username, roomId, dateCheckIn, dateCheckOut, dateBook, numberPhone, email;
    int totalCost, noPeople;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(String dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public String getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(String dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public String getDateBook() {
        return dateBook;
    }

    public void setDateBook(String dateBook) {
        this.dateBook = dateBook;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }

    public boolean bookRoom() throws Exception {
        BookDao dao = new BookDao();
        return dao.bookRoom(username, roomId, dateCheckIn, dateCheckOut, dateBook, totalCost);
    }
   public boolean bookReport() throws Exception {
        BookDao dao = new BookDao();
        return dao.bookReport(username, roomId, dateCheckIn, dateCheckOut, dateBook, totalCost);
    }
    public List<BookDto> findBookRoom() throws Exception {
        BookDao dao = new BookDao();
        return dao.findBookRoom(username);
    }
      public List<BookDto> report() throws Exception {
        BookDao dao = new BookDao();
        return dao.Report();
    }
       public boolean delete() throws Exception {
        BookDao dao = new BookDao();
        return dao.delete(roomId);
    }
            public boolean updateCannel() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.updateCannel(roomId,username);
    }
                      public boolean updateBookStatus() throws Exception {
        RoomDao dao = new RoomDao();
        return dao.updateBookStatus(roomId, username);
    }
}
