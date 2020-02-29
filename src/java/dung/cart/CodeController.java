/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.cart;

import dung.dtos.RoomBeans;
import dung.dtos.RoomDto;
import dung.dtos.UsersBeans;
import dung.models.Cart;
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
public class CodeController extends HttpServlet {

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
            boolean flag = false;

            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("USER");
            Cart shoppingCart = (Cart) session.getAttribute("CART");
            String code = request.getParameter("txtCode");
            String id = request.getParameter("id");
            UsersBeans beans = new UsersBeans();
            beans.setUsername(user);

            if (shoppingCart == null) {
                shoppingCart = new Cart();
            }
            int cost = 0;
            int pay = 0;

            if (beans.checkCode()) {
                request.setAttribute("EXIST", "You have used this code");
            } else {

                for (RoomDto dto : shoppingCart.getItems().values()) {
                    if (code.equals("VIETNAMVODICH") || code.equals("VNVD")) {
                        cost = (int) (dto.getCosts() * 0.5);
                        pay = cost * dto.getNumDate();
                        flag = true;

                    } else {
                        cost = dto.getCosts();
                        pay = dto.getCosts() * dto.getNumDate();
                        request.setAttribute("FAIL", "Discount code is not exist ");
                    }
                }
                shoppingCart.updateCost(id, cost);
                shoppingCart.updatePay(id, pay);

            }
            session.setAttribute("CART", shoppingCart);
            if (flag == true) {
                beans.addCode();
                request.setAttribute("CODE", "Successfully applied discount code ");
            }
        } catch (Exception e) {
            log("Error at CODE:" + e.getMessage());
        }
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
