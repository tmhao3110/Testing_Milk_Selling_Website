<%-- 
    Document   : UpdateAcc
    Created on : Jun 19, 2020, 8:45:05 AM
    Author     : Chu Ai Duc
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <%  Account newacc = (Account) session.getAttribute("thongtinacc");%>
            <form action="AccountServlet2?yeucau=update" method="post">
                <table class="table table-hover">
                    <tr>
                        <td>USERNAME</td>
                        <td><input type="text" name="txtusername" value="<%=newacc.getUsername()%>" readonly="true"></td>
                    </tr>
                    <tr>
                        <td>PASSWORD</td>
                        <td><input type="password" name="txtpassword" value="<%=newacc.getPassword()%>"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input id="btnSubmit" type="submit" value="Submit Update" class="btn btn-primary"></td>
                    </tr>
                </table>
            </form>
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>

    </body>
</html>
