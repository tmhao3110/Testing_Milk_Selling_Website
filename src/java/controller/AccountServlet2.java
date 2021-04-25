/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AccountServlet2 extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("txtusername");
        String password = request.getParameter("txtpassword");
        String yeucau = request.getParameter("yeucau");
        String page = "";
        String thongbao = "";
        HttpSession session = request.getSession();
        String USERNAME_PATTERN
                = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        Account newacc = new Account(username, password);
        AccountModel newmodel = new AccountModel();
        if (yeucau.equals("insert")) {
            if (!username.matches(USERNAME_PATTERN)) {
                thongbao="Invalid Username";
                page="ThongBao.jsp";
            } else {
                int check = newmodel.insertAccount(newacc);
                if (check != -1) {
                    if (check != 0) {
                        session.setAttribute("danhsachTK", new AccountModel().getList());
                        page = "viewacc.jsp";
                    } else {
                        thongbao = "insert thất bại";
                        page = "ThongBao.jsp";
                    }
                } else {
                    thongbao = "Kết nối database thất bại";
                    page = "ThongBao.jsp";
                }
            }
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
        }
        if (yeucau.equals("getinfo")) {
            Account acc = newmodel.getAcc(username);
            if (acc != null) {
                session.setAttribute("thongtinacc", acc);
                page = "UpdateAcc.jsp";
            } else {
                thongbao = "Ket noi that bai";
                page = "ThongBao.jsp";
            }
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
        }
        if (yeucau.equals("update")) {
            int check = newmodel.updateAccount(newacc);
            if (check != -1) {
                if (check != 0) {
                    session.setAttribute("danhsachTK", new AccountModel().getList());
                    page = "viewacc.jsp";
                } else {
                    thongbao = "Update thất bại";
                    page = "ThongBao.jsp";
                }
            } else {
                thongbao = "Ket noi that bai";
                page = "ThongBao.jsp";
            }
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
        }
        if (yeucau.equals("delete")) {
            Account acc = newmodel.getAcc(username);
            int check = newmodel.deleteAccount(acc);
            if (check != -1) {
                if (check != 0) {
                    session.setAttribute("danhsachTK", new AccountModel().getList());
                    page = "viewacc.jsp";
                } else {
                    thongbao = "Delete thất bại";
                    page = "ThongBao.jsp";
                }
            } else {
                thongbao = "Ket noi that bai";
                page = "ThongBao.jsp";
            }
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
        }
        if (yeucau.equals("xoanhieu")) {
            int check = 1;
            String[] listuser = request.getParameterValues("chon");
            if (listuser == null) {
                request.setAttribute("thongbao", "Chua chon du lieu");
                page = "ThongBao.jsp";
                request.getRequestDispatcher(page).forward(request, response);
                return;
            }
            for (String listuser1 : listuser) {
                Account acc = new Account(listuser1, "");
                check = newmodel.deleteAccount(acc);
            }
            if (check == 0) {
                thongbao = "Xoa khong het";
                page = "ThongBao.jsp";
            } else {
                session.setAttribute("danhsachTK", new AccountModel().getList());
                page = "viewacc.jsp";
                thongbao = "OK xoa thanh cong";
            }
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
