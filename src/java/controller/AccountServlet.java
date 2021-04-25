/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.AccountModel;

/**
 *
 * @author Chu Ai Duc
 */
public class AccountServlet extends HttpServlet {
    Account current=null;
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
        String page = "";
        String thongbao = "";
        String yeucau=request.getParameter("yeucau");
        HttpSession session=request.getSession();
        String username = request.getParameter("txtusername");
        String password = request.getParameter("txtpassword");
        Account newacc = new Account(username, password);
        
        AccountModel newmodel = new AccountModel();
        int check = newmodel.checkLogin(newacc);
        if (check != -1) {
            if (check == 1) {
                if(yeucau.equals("qlacc")){
                    page = "viewacc.jsp";
                    thongbao="Login Successfully!";
                    session.setAttribute("danhsachTK", new AccountModel().getList());
                }
                if(yeucau.equals("qlsp")){
                    page="viewsp.jsp";
                    thongbao="Login Successfully!";
                }
                
                
            } else if (check == 2) {
                page = "ThongBao.jsp";
                thongbao = "Incorrect Password!";
            } else if (check == 3) {
                page = "ThongBao.jsp";
                thongbao = "Invalid Username!";
            }
        } else {
            page = "ThongBao.jsp";
            thongbao = "Connect to Database Fail!";
        }
        request.setAttribute("thongbao", thongbao);
        request.getRequestDispatcher(page).forward(request, response);
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
