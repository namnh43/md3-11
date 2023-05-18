<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/17/2023
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sach sản phẩm</title>
    <style>
        #add_link {
            margin-right: 30px;
        }

        table, tr, th, td {
            border: solid 1px black;
            border-collapse: collapse;
        }
        .editable {
            position: relative;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/products?action=create" id="add_link">Thêm mới sản phẩm</a>
<form action="/products" method="get">
    <input type="text" name="name" placeholder="name">
    <input type="hidden" name="action" value="search">
    <input type="submit">
</form>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Mã Sản phẩm</th>
        <th>Tên</th>
        <th>Giá Sản phẩm</th>
        <th>Sửa</th>
        <th>Xóa</th>
    </tr>

    <c:forEach items='${list}' var="product" step="1" varStatus="loop">
        <form class="form_class" action="/products" method="post">
            <tr>
                <td><input name="product_id" value="${loop.getIndex()}"
                           type="hidden">${loop.getIndex() + 1}</td>
                <td><a href="/products?action=view&id=${loop.getIndex()}">${product.id}</a></td>
                <td>${product.name}</td>
                <td>
                    <input name="product_price" value="${product.price}" type="hidden">
                    <div class="editable">${product.price}</div>
                </td>
                <td class="update_parent">
                    <button class="update" name="action" value="edit" disabled>update</button>
                </td>
                <td>
                    <button name="action" value="delete">delete</button>
                </td>
            </tr>
        </form>
    </c:forEach>

</table>

</body>
<script>
    $(document).ready(function () {
        $(".form_class").on("submit", function (event) {
            if (confirm("Are you sure?")) {
            } else {
                event.preventDefault();
            }
        });
        //
        $('.editable').on('click', function() {
            var that = $(this);
            if (that.find('input').length > 0) {
                return;
            }
            var currentText = that.text();

            var $input = $('<input>').val(currentText)
                .css({
                    'position': 'absolute',
                    top: '0px',
                    left: '0px',
                    width: that.width(),
                    height: that.height(),
                    opacity: 0.9,
                    padding: '10px'
                });

            $(this).append($input);

            // Handle outside click
            $(document).click(function(event) {
                if(!$(event.target).closest('.editable').length) {
                    if ($input.val()) {
                        that.text($input.val());
                        that.siblings().val($input.val())
                        that.parent().siblings('.update_parent').children(".update").prop('disabled',false);
                        console.log(that.parent().siblings('.update_parent').children(".update").text());
                        //send request to servlet
                    }
                    that.find('input').remove();
                }
            });
        });
    });
</script>
</html>
