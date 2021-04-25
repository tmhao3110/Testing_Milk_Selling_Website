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
import javax.servlet.http.Part;
import model.SanPham;
import model.SanPhamModel;
import model.UploadModel;

/**
 *
 * @author Chu Ai Duc
 */
public class UpdateServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String masp=request.getParameter("txtMASP");
        String tensp=request.getParameter("txtTENSP");
        int giasp=Integer.parseInt(request.getParameter("txtGIA"));
        Part filehinh=request.getPart("txtHINH");
        String hinhsp=filehinh.getSubmittedFileName();
        String[] madanhmuc=request.getParameterValues("txtMADANHMUC");
        int madanhmuc1=Integer.parseInt(madanhmuc[0]);
        SanPhamModel newmodel=new SanPhamModel();
        String page="";
        String thongbao="";
        if(hinhsp.equals("")){
            hinhsp=request.getParameter("txthinhcu");
        }else{
            String uploadRootPath=request.getServletContext().getRealPath("/Images");
            boolean chk=new UploadModel().uploadFile(hinhsp, filehinh, uploadRootPath);
            if(!chk){
                request.setAttribute("thongbao", "Upload Image Fail");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        }
        SanPham newsp=new SanPham(masp,tensp,giasp,hinhsp,madanhmuc1);
        int check=newmodel.updateSP(newsp);
        if(check!=-1){
            if(check!=0){
                page="viewsp.jsp";
                thongbao="Update Thanh Cong!";
            }else{
                request.setAttribute("thongtin", newsp.getMaSP()+newsp.getTenSP()+newsp.getGiaSP()+newsp.getHinhSP()+newsp.getMaDM()+check);
                page="ThongBao.jsp";
                thongbao="Update that bai!";
            }
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher(page).forward(request, response);
        }else{
            request.setAttribute("thongbao", "Ket noi database that bai");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
