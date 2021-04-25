<%-- 
    Document   : update
    Created on : Jun 18, 2020, 6:47:52 PM
    Author     : Chu Ai Duc
--%>

<%@page import="model.SanPham"%>
<%@page import="model.DanhMucModel"%>
<%@page import="model.DanhMuc"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
        <link href="style/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="fb-root"></div>

        <div class="container">
            <header class="banner">
                <img id="slider" src="Images/banner0.jpg">
                <input name="sliderput" type="radio" onClick="document.getElementById('slider').src = 'Images/banner0.jpg';">
                <input name="sliderput" type="radio" onClick="document.getElementById('slider').src = 'Images/banner1.jpg';">
                <input name="sliderput" type="radio" onClick="document.getElementById('slider').src = 'Images/banner2.jpg';">
            </header>
            <nav class="menu1">
                <ul>
                    <li><a href="index.jsp">Trang chủ</a></li>
                    <li><a href="loginql.jsp">QL Tài khoản</a></li>
                    <li><a href="clientsp.jsp">Mua hàng</a></li>
                    <li><a href="GioHangServlet?yeucau=mogiohang">Giỏ hàng</a></li>
                    <li><a href="loginsp.jsp">QL Sản phẩm (Admin)</a></li>
                    <li><a href="#">Liên hệ</a>
                        <ul>
                            <li><a href="#">Mobile</a></li>
                            <li><a href="#">Email</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <%
                ArrayList<DanhMuc> list = new DanhMucModel().getList();
            %>
            <%
                SanPham newsp = (SanPham) session.getAttribute("SPinfo");
            %>
            <form action="UpdateServlet" method="post" enctype="multipart/form-data">
                <table class="table table-hover">
                    <tr>
                        <td>MASP</td>
                        <td><input type="text" name="txtMASP" value="<%=newsp.getMaSP()%>" readonly="true"></td>
                    </tr>
                    <tr>
                        <td>TENSP</td>
                        <td><input type="text" name="txtTENSP" value="<%=newsp.getTenSP()%>"></td>
                    </tr>
                    <tr>
                        <td>GIASP</td>
                        <td><input type="text" name="txtGIA" value="<%=newsp.getGiaSP()%>"></td>
                    </tr>
                    <tr>
                        <td><img src="Images/<%=newsp.getHinhSP()%>" height="100px" width="100px"></td>
                        <td><span name="txthinhcu"><%=newsp.getHinhSP()%></span></td>
                    </tr>
                    <tr>
                        <td>HINHSP</td>
                        <td><input type="file" name="txtHINH" value=""></td>
                    </tr>
                    <tr>
                        <td>MA DANH MUC</td>
                        <td>
                            <select name="txtMADANHMUC">
                                <c:forEach var="d" items="<%=list%>">
                                    <option value="${d.getMaDM()}">${d.getTenDM()}</option>
                                </c:forEach>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input id="btnSubmit" type="submit" value="Update"></td>
                    </tr>
                </table>
            </form>
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>
    </body>
</html>
