<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/17/2023
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>chitiet</title>
    <style>
        table,th,tr,td {
            border: black solid 1px;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>Chi tiết sản phẩm</h1>
<a href="/products">Quay trở lại danh sách</a>
<br>
<table>
    <tr>
        <th style="width: 150px">Tên</th>
        <th style="width: 100px">Chi tiết</th>
    </tr>
    <tr>
        <td>Mã sản phẩm</td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>Tên sản phẩm</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Giá sản phẩm</td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>Mô tả sản phẩm</td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>Nhà sản xuất</td>
        <td>${product.factory}</td>
    </tr>
</table>
</body>
</html>
