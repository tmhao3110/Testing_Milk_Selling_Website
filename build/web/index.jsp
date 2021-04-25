<%-- 
    Document   : index
    Created on : Jun 18, 2020, 5:53:14 PM
    Author     : Chu Ai Duc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
        <link href="style/style.css" rel="stylesheet" type="text/css">
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
            <div>
                <img src="Images/banner_1.JPG" width="500px">
                <span style="width: 45%; float: right; font-size: larger">Sữa bò tươi là một trong những sản phẩm sữa có nguồn nguyên liệu tự nhiên, nguyên chất ngày càng được người tiêu dùng Việt Nam ưa chuộng. Bởi loại sữa này có hương vị thơm ngon tự nhiên và giữ được nhiều thành phần dinh dưỡng vốn có trong sữa tươi.

                    Sữa bò tươi nguyên chất mang lại những lợi ích tuyệt vời cho sức khỏe vì thế từ năm 2006, tại các nước phát triển, đặc biệt là Châu Âu, việc sử dụng sữa bò này đã rất phổ biến. Tại Việt Nam, tính đến năm 2015, các sản phẩm từ sữa được sản xuất từ nguyên liệu sữa bò đã chiếm tới 92%. Và đây cũng là loại sữa cũng dần trở thành thức uống quen thuộc được nhiều người dân tin dùng, sử dụng cho bản thân và gia đình.</span>
            </div>
            <footer>CHUDUC-WINESTORE © 2020. All rights reserved.</footer>
        </div>
    </body>
</html>
