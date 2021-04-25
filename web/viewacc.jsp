<%-- 
    Document   : viewacc.jsp
    Created on : Jun 18, 2020, 6:09:01 PM
    Author     : Chu Ai Duc
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
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
            <form action="AccountServlet2?yeucau=xoanhieu" method="post">
                <table class="table table-hover">
                    <tr>
                        <th>Chọn</th>
                        <th>Tên Tài khoản</th>
                        <th>Mật khẩu</th>
                        <th colspan="2">Action</th>


                    </tr>
                    <%
                        ArrayList list = (ArrayList) session.getAttribute("danhsachTK");
                        for (int i = 0; i < list.size(); i++) {
                            Account acc = (Account) list.get(i);

                    %>
                    <tr>
                        <td><input type="checkbox" name="chon" value="<%=acc.getUsername()%>"></td>
                        <td><%=acc.getUsername()%></td>
                        <td><%=acc.getPassword()%></td>
                        <td>
                            <h3><a id="btnUpdate<%=acc.getUsername()%>" href="AccountServlet2?yeucau=getinfo&txtusername=<%=acc.getUsername()%>"><input type="button" value="Update" class="btn btn-primary" style="background-color: green"></a></h3>

                        </td>
                        <td>
                            <h3><a id="btnDelete<%=acc.getUsername()%>" href="AccountServlet2?yeucau=delete&txtusername=<%=acc.getUsername()%>"><input type="button" value="Delete" class="btn btn-primary" style="background-color: crimson"></a></h3>
                        </td>

                    </tr>
                    <%}%>
                    <tr>
                        <td><input type="submit" value="Xóa nhiều" class="btn btn-primary" style="background-color: crimson"/></td>
                        <td><a id="btnInsert" href="InsertAcc.jsp"><input type="button" value="Insert" class="btn btn-primary" style="background-color: lightseagreen"></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
                    <input id="info" type="hidden" value="${thongbao}">
            </form>
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>
    </body>
</html>
