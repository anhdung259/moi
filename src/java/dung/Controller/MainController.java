/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pham Anh Dung
 */
public class MainController extends HttpServlet {

    private final static String ERROR = "error.jsp";
    private final static String LOGIN = "LoginController";
    private final static String LOGOUT = "LogoutController";
    private final static String SEARCH = "SearchController";
    private final static String SEARCHROOM = "SearchRoomController";
    private final static String DELETE = "DeleteController";
    private final static String EDIT = "EditController";
    private final static String UPDATE = "UpdateController";
    private final static String REGISTER = "RegisterController";
    private final static String BOOK = "BookController";
    private final static String ADDROOM = "AddRoomController";
    private final static String CANCEL = "CannelController";
    private final static String UPROFILE = "UpdateProfileController";
    private final static String CART = "AddToCartController";
    private final static String REMOVECART = "DeletecartController";
    private final static String DELETEUSER = "DeleteUserController";
    private final static String CODE = "CodeController";

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
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String Role = (String) session.getAttribute("ROLE");
            if (Role == null) {
                Role = "";
            }
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Register")) {
                url = REGISTER;
            } else if (action.equals("Search") && Role.equals("admin")) {
                url = SEARCH;
            } else if (action.equals("Delete") && Role.equals("admin")) {
                url = DELETE;
            } else if (action.equals("Edit") && Role.equals("admin")) {
                url = EDIT;
            } else if (action.equals("Update") && Role.equals("admin")) {
                url = UPDATE;
            } else if (action.equals("LogOut")) {
                url = LOGOUT;
            } else if (action.equals("Search Room") && Role.equals("user")) {
                url = SEARCHROOM;
            } else if (action.equals("Add To Cart") && Role.equals("user")) {
                url = CART;
            } else if (action.equals("Book Now") && Role.equals("user")) {
                url = BOOK;
            } else if (action.equals("Add Room") ) {
                url = ADDROOM;
            } else if (action.equals("Cancel") && Role.equals("user")) {
                url = CANCEL;
            } else if (action.equals("Update Profile") && Role.equals("user")) {
                url = UPROFILE;
            } else if (action.equals("Remove") && Role.equals("user")) {
                url = REMOVECART;
            } else if (action.equals("Delete User") && Role.equals("admin")) {
                url = DELETEUSER;
            } else if (action.equals("Apply discount code") && Role.equals("user")) {
                url = CODE;
            } else {
                request.setAttribute("ERROR", "  Your action is invalid");
            }
        } catch (Exception e) {
            log("Error at maincontroller" + e.getMessage());
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
