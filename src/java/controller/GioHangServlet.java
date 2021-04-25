/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GioHangModel;
import model.HoaDonModel;
import model.Item;
import model.chitietHoaDon;
import model.chitietHoaDonModel;

/**
 *
 * @author Chu Ai Duc
 */
public class GioHangServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    GioHangModel GHModel=new GioHangModel();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String page="";
        String thongbao="";
        String yeucau=request.getParameter("yeucau");
        String masp=request.getParameter("txtmasp");
        if(yeucau.equals("muasp")){
            GHModel.addtoCart(masp);
            request.setAttribute("giohang", GHModel.getListItems());
            request.setAttribute("tongtien", GHModel.tongtien());
            page="GioHang.jsp";
            request.getRequestDispatcher(page).forward(request, response);
        }
        if(yeucau.equals("xoagiohang")){
            GHModel.clearAll();
            request.setAttribute("thongbao", "Bạn không có mặt hàng nào trong giỏ hàng");
            page="ThongBao.jsp";
            request.getRequestDispatcher(page).forward(request, response);
        }
        if(yeucau.equals("xoasanpham")){
            GHModel.xoaSP(masp);
            if(GHModel.tongtien()!=0){
                request.setAttribute("giohang", GHModel.getListItems());
                request.setAttribute("tongtien", GHModel.tongtien());
                page="GioHang.jsp";
                request.getRequestDispatcher(page).forward(request, response);
            }else{
                request.setAttribute("thongbao", "Bạn không có mặt hàng nào trong giỏ hàng");
                page="ThongBao.jsp";
                request.getRequestDispatcher(page).forward(request, response);
            }
            
        }
        if(yeucau.equals("thanhtoan")){
            if(GHModel.getListItems().isEmpty()){
                page="ThongBao.jsp";
                thongbao="Ban khong co mat hang nao";
                request.setAttribute("thongbao", thongbao);
                request.getRequestDispatcher(page).forward(request, response);
                return;
            }
            
            
            HoaDonModel HDModel=new HoaDonModel();
            HDModel.insertHD();
            int MaHDNew=HDModel.getMaHDlastest();
            
            chitietHoaDonModel CTModel=new chitietHoaDonModel();
            ArrayList<Item> giohang=GHModel.getListItems();
            for(Item i:giohang){
                chitietHoaDon newct=new chitietHoaDon(MaHDNew,i.getSP().getMaSP(),i.getSoLuong());
                CTModel.insertCTHD(newct);
            }
            
            GHModel.clearAll();
            page="ThongBao.jsp";
            thongbao="Dat hang thanh cong, ma Hoa Don la: "+ MaHDNew ;
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
        }
        if(yeucau.equals("mogiohang")){
            if(GHModel.tongtien()!=0){
                request.setAttribute("giohang", GHModel.getListItems());
                request.setAttribute("tongtien", GHModel.tongtien());
                page="GioHang.jsp";
                request.getRequestDispatcher(page).forward(request, response);
            }else{
                request.setAttribute("thongbao", "Bạn không có mặt hàng nào trong giỏ hàng");
                page="ThongBao.jsp";
                request.getRequestDispatcher(page).forward(request, response);
            }
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
