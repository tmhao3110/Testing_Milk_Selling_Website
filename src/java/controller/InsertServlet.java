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
import javax.servlet.http.Part;
import model.SanPham;
import model.SanPhamModel;
import model.UploadModel;

/**
 *
 * @author Chu Ai Duc
 */
public class InsertServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String masp = request.getParameter("txtMASP");
        String tensp = request.getParameter("txtTENSP");
        int giasp = Integer.parseInt(request.getParameter("txtGIA"));
        Part filehinh = request.getPart("txtHINH");
        String hinhsp = filehinh.getSubmittedFileName();
        String[] madanhmuc = request.getParameterValues("txtMADANHMUC");
        int madanhmuc1 = Integer.parseInt(madanhmuc[0]);
        String yeucau = request.getParameter("yeucau");
        SanPhamModel newmodel = new SanPhamModel();
        String thongbao = "";
        String page = "";
        if (yeucau.equals("insert")) {
            SanPham newsp = new SanPham(masp, tensp, giasp, hinhsp, madanhmuc1);
            String uploadRootPath = request.getServletContext().getRealPath("/Images");
            boolean chk = new UploadModel().uploadFile(hinhsp, filehinh, uploadRootPath);
            if (!chk) {
                page = "ThongBao.jsp";
                thongbao = "Upload hinh fail";
                request.setAttribute("thongbao", thongbao);
                request.getRequestDispatcher(page).forward(request, response);
                return;
            }
            int check = newmodel.insertSP(newsp);
            if (check != -1) {
                if (check != 0) {
                    thongbao = "Thanh cong";
                    page = "viewsp.jsp";
                } else {
                    thongbao = "That bai";
                    page = "ThongBao.jsp";
                }
            } else {
                thongbao = "Ket noi database fail";
                page = "ThongBao.jsp";
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
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
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
