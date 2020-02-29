/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.BookBeans;
import dung.dtos.RoomBeans;
import dung.dtos.RoomDto;
import dung.dtos.roomError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pham Anh Dung
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "update.jsp";
    private static final String SUCCESS = "SearchController";

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
        String roomid = request.getParameter("txtRoomId");
        String type = request.getParameter("cbType");
        String NoPeople = request.getParameter("txtNoPeople");
        String Image = request.getParameter("txtImage");
        String ImageUpdate = request.getParameter("txtImages");
        String costs = request.getParameter("txtCosts");

        roomError erroObj = new roomError();
        boolean valid = true;
        String url = INVALID;
//        if (roomid.matches("[0-9]{3}") == false) {
//            erroObj.setRoomidErr("roomid is number,ex:XXX");
//            valid = false;
//        }
        if (NoPeople.matches("[0-9]{1,5}") == false) {
            erroObj.setNoPeopleErr("No.People is number");
            valid = false;
        }
        if (costs.matches("[0-9]{1,5}") == false) {
            erroObj.setCostsErr("costs is number");
            valid = false;
        }
        try {

            if (valid) {
                RoomBeans beans = new RoomBeans();
                beans.setRoomid(roomid);
                beans.setNoPeople(Integer.parseInt(NoPeople));
                beans.setType(type);
                if (ImageUpdate.isEmpty()) {
                    beans.setImage(Image);
                } else {
                    beans.setImage(ImageUpdate);
                }
                beans.setCosts(Integer.parseInt(costs));
                if (beans.update()) {
                    url = SUCCESS;
                } else {
                    url = ERROR;
                }
            } else {
                request.setAttribute("INVALID", erroObj);
                RoomDto dto = new RoomDto(roomid, type,Image);
                request.setAttribute("DTO", dto);
            }

        } catch (Exception e) {
            log("Error at update controller:" + e.getMessage());

//            RoomDto dto = new RoomDto(roomid, type, status, Image, nopeople, cost);
//            request.setAttribute("DTO", dto);
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
