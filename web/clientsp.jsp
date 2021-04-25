<%-- 
    Document   : clientsp
    Created on : Jun 18, 2020, 6:52:46 PM
    Author     : Chu Ai Duc
--%>

<%@page import="model.SanPhamModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                ArrayList<SanPham> list1 = new SanPhamModel().getList();
            %>
            <div style="width: 1000px; margin: 0 auto">
                <c:forEach var="p" items="<%=list1%>">
                    <div style="width: 23%; float: left;  border: 1px black solid; border-radius: 3px; margin: 5px">
                        <table class="table table-hover">
                            <tr>
                                <td>Mã: <span style="color:crimson; font-weight: bold">${p.getMaSP()}</span></td>
                            </tr>
                            <tr>
                                <td><span style="color:blue; font-weight: bold">${p.getTenSP()}</span></td>
                            </tr>
                            <tr>
                                <td><img src="Images/${p.getHinhSP()}" height="200px" width="200px"></td>
                            </tr>
                            <tr>
                                <td style="color: green">Giá: <span style="color:crimson; font-weight: bold">${p.getGiaSP()}</span></td>
                            </tr>
                            <tr>
                                <td><a href="GioHangServlet?yeucau=muasp&txtmasp=${p.getMaSP()}" class="btn btn-primary" style="background-color: green">Buy Now</a></td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>

            </div>
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>
    </body>
</html>
