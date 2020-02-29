/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.RoomBeans;
import dung.dtos.RoomDto;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pham Anh Dung
 */
public class SearchRoomController extends HttpServlet {

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
        try {
            String NoPe = request.getParameter("txtNumPeople");
            int numberMem = Integer.parseInt(NoPe);
            String typeS = request.getParameter("cbTypeS");
            String DateCheckIn = request.getParameter("txtDate");
            String DateCheckOut = request.getParameter("txtTodate");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date dateIn = formatter.parse(DateCheckIn);
            java.util.Date dateOut = formatter.parse(DateCheckOut);

            long getDiff = dateOut.getTime() - dateIn.getTime();
            int diffDays = (int) (getDiff / (24 * 60 * 60 * 1000));
            if(diffDays<=0){
                request.setAttribute("ER", "Please select a valid date ");
            }
            else{
            request.setAttribute("NumDate", diffDays);
            RoomBeans beans = new RoomBeans();
            beans.setType(typeS);
            beans.setNoPeople(numberMem);
            beans.setDateIn(DateCheckIn);
            beans.setDateOut(DateCheckOut);
            List<RoomDto> result = beans.searchRoom();
            request.setAttribute("RESULT", result);
            }
        } catch (Exception e) {
            log("Error at SearchRoom :" + e.getMessage());
        } finally {
            request.getRequestDispatcher("booking.jsp").forward(request, response);
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
