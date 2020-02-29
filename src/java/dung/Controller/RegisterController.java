/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.RegisterError;
import dung.dtos.UsersBeans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pham Anh Dung
 */
public class RegisterController extends HttpServlet {

    private final String ERROR = "error.jsp";
    private final String SUCCESS = "login.jsp";
    private final String INVALID = "register.jsp";

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
        RegisterError errObj = new RegisterError();
        String url = INVALID;

        boolean valid = true;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String passwordcomfirm = request.getParameter("txtPasswordcomfirm");
        String address = request.getParameter("txtAddress");
        String phoneNo = request.getParameter("txtNumberPhone");
        String Email = request.getParameter("txtEmail");
        String fullname = request.getParameter("txtFullname");
        if (username.length() < 6) {
            errObj.setUsernameErr("User can't less 6 chars");
            valid = false;
        }
        if (password.length() < 6) {
            errObj.setPasswordErr("Password can't less 6 chars");
            valid = false;
        }
        if (!passwordcomfirm.contains(password)) {
            errObj.setPasswordcomfirmErr("Password incorrect");
            valid = false;
        }
        if (address.length() == 0) {
            errObj.setAddressErr("Address not blank");
            valid = false;
        }
        if (phoneNo.matches("[0-9]{10}") == false) {
            errObj.setPhonenoErr("NumberPhone is invalid");
            valid = false;
        }
        if (Email.matches("\\w+@\\w+([.]\\w{2,3}){1,2}") == false) {
            errObj.setEmailErr("Email is invalid");
            valid = false;
        }
        if (fullname.length() == 0) {
            errObj.setFullnameErr("Fullname not blank");
            valid = false;
        }
        try {
            if (valid) {
                UsersBeans beans = new UsersBeans();
                beans.setUsername(username);
                beans.setPassword(password);
                beans.setFullname(fullname);
                beans.setEmail(Email);
                beans.setPhoneNo(phoneNo);
                beans.setAddress(address);
                HttpSession session = request.getSession();
                session.setAttribute("USER", username);
                if (beans.insert()) {
                    url = SUCCESS;
                    request.setAttribute("OK", "Register account successfull!!!");
                } else {
                    url = ERROR;
                }

            } else {
                url = INVALID;
                request.setAttribute("INVALID", errObj);
            }

        } catch (Exception e) {

            log("ERROR at RegisterController" + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                errObj.setUsernameDuplicate("Username is exist");
                request.setAttribute("INVALID", errObj);

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
