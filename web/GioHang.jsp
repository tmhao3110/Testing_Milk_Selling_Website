<%-- 
    Document   : GioHang
    Created on : Jun 19, 2020, 7:59:37 AM
    Author     : Chu Ai Duc
--%>

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
            <table class="table table-hover">
                <tr>
                    <td>Mã sản phẩm</td>
                    <td>Tên sản phẩm</td>
                    <td>Hình sản phẩm</td>
                    <td>Giá</td>
                    <td>Số lượng</td>
                    <td>Thành tiền</td>
                    <td>Action</td>
                </tr>
                <c:forEach var="item" items="${giohang}">
                    <tr>
                        <td>${item.getSP().getMaSP()}</td>
                        <td>${item.getSP().getTenSP()}</td>
                        <td><img src="Images/${item.getSP().getHinhSP()}" height="100px" width="100px"></td>
                        <td>${item.getSP().getGiaSP()}</td>
                        <td>${item.getSoLuong()}</td>
                        <td>${item.getSP().getGiaSP() * item.getSoLuong()}</td>
                        <td><a href="GioHangServlet?yeucau=xoasanpham&txtmasp=${item.getSP().getMaSP()}">Remove</a></td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Tổng tiền:</td>
                        <td>${tongtien}</td>
                        <td></td>
                    </tr>
            </table>
            <a href="clientsp.jsp"><input type="button" value="Tiếp tục mua hàng" class="btn btn-primary"></a>
            <a href="GioHangServlet?yeucau=xoagiohang"><input type="button" value="Xóa giỏ hàng" class="btn btn-primary" style="background-color: red;"></a>
            <a href="GioHangServlet?yeucau=thanhtoan"><input type="button" value="Thanh toán" class="btn btn-primary" style="background-color: green;"></a>
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>
    </body>
</html>
