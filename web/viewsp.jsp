<%-- 
    Document   : viewsp
    Created on : Jun 18, 2020, 6:35:09 PM
    Author     : Chu Ai Duc
--%>

<%@page import="model.SanPhamModel"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
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
            <form action="SanPhamServlet?yeucau=xoanhieu" method="post">
                <table class="table table-hover">
                    <tr>
                        <th>Chon</th>
                        <th>MaSP</th>
                        <th>TenSP</th>
                        <th>GiaSP</th>
                        <th>HinhSP</th>
                        <th>MaDanhMuc</th>
                        <th></th>
                        <th></th>

                    </tr>
                    <%
                        ArrayList<SanPham> list1 = new SanPhamModel().getList();
                    %>
                    <c:forEach var="p" items="<%=list1%>">
                        <tr>
                            <td><input type="checkbox" name="chon" value="${p.getMaSP()}"></td>
                            <td>${p.getMaSP()}</td>
                            <td>${p.getTenSP()}</td>
                            <td>${p.getGiaSP()}</td>
                            <td><img src="Images/${p.getHinhSP()}" height="100px" width="100px"></td>
                            <td>${p.getMaDM()}</td>
                            <th><a id="btnDelete${p.getMaSP()}" href="DeleteServlet?txtMaSP=${p.getMaSP()}" class="btn btn-primary" style="background-color: lightcoral">Delete</a></th>
                            <th><a id="btnUpdate${p.getMaSP()}" href="SanPhamServlet?yeucau=laythongtin&txtMaSP=${p.getMaSP()}" class="btn btn-primary" style="background-color: lightseagreen">Update</a></th>

                        </tr>
                    </c:forEach>
                    <tr>
                        <td> <a id="btnInsert" href="insert.jsp"><input type="button" value="Insert" class="btn btn-primary" style="background-color: green"></a></td>
                        <td> <input type="submit" value="Delete All" class="btn btn-primary" style="background-color: crimson"/></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>




            </form>
            <input id="info" type="hidden" value="${thongbao}">
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>
    </body>
</html>
