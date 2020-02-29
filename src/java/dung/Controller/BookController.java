/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.BookBeans;
import dung.dtos.RoomBeans;
import dung.dtos.RoomDto;
import dung.models.Cart;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pham Anh Dung
 */
public class BookController extends HttpServlet {

    private static final String SUCCESS = "user.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS;
        boolean flag = false;
        BookBeans beans = new BookBeans();
        RoomBeans roombean = new RoomBeans();
        HttpSession session = request.getSession();
        String Username = (String) session.getAttribute("USER");
        Cart shoppingCart = (Cart) session.getAttribute("CART");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String DateBook = dtf.format(now);
        try {

            for (RoomDto dto : shoppingCart.getItems().values()) {
                int pay = dto.getPay();
                String DateCheckIn = dto.getDateIn();
                String DateCheckOut = dto.getDateOut();
                String roomId = dto.getRoomid();
                beans.setUsername(Username);
                beans.setRoomId(roomId);
                beans.setDateBook(DateBook);
                beans.setDateCheckOut(DateCheckOut);
                beans.setDateCheckIn(DateCheckIn);
                beans.setTotalCost(pay);
                roombean.setRoomid(roomId);
                roombean.setDateIn(DateCheckIn);
                roombean.setDateOut(DateCheckOut);
                if ( roombean.updateBook() && beans.bookReport() && beans.updateBookStatus()&& beans.bookRoom()) {
                    flag = true;
                }
               
            }
            if (flag == true) {
                url = SUCCESS;
                shoppingCart.clear();
                request.setAttribute("OK", "Congratulations on your successful booking");
            }
            if(flag=false){
                
            }
            //convert datebook current to type dateTime in sql

            //convert date checkin, checkout current to type date in sql
//            SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd ");
        } catch (Exception e) {
            log("Error at book controller" + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                request.setAttribute("FAIL", "You have already booked this room, if you want to book or Cancel in My Booking to make a reservation");
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
