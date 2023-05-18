<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/18/2023
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>created</title>
    <style>
        label {
            margin-right: 20px;
        }
    </style>
</head>
<body>
<h1>Chi tiết sản phẩm</h1>
<c:if test='${message != null}'>
    <p style="color: green">${message}</p>
</c:if>
<a href="/products">Quay trở lại trang chủ</a>
<form method="post">
    <label for="id">ProductID:</label>
    <input name="product_id" id="id">
    <br>
    <label for="name">Name:</label>
    <input name="product_name" id="name">
    <br>
    <label for="price">Price:</label>
    <input name="product_price" id="price">
    <br>
    <label for="description">Description:</label>
    <input name="product_desc" id="description">
    <br>
    <label for="manufactory">Manufactory:</label>
    <input name="product_factory" id="manufactory">
    <br>
    <input type="submit" value="Add">
</form>

</body>
</html>
