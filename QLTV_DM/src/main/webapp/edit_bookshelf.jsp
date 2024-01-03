<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page import="model.bean.BookShelf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa kệ sách</title>
</head>
<body class="bg-dark">
    <section class="content">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <% if (request.getAttribute("bookshelf") != null) { %>
                        <form action="EditBookShelf" method="post" class="col-md-5 bg-light p-3 my-3 rounded">
                            <h1 class="text-uppercase h3 py-3">Chỉnh sửa Kệ Sách</h1>
                           <input type="hidden" name="idBookShelf" value="${bookshelf.idBookShelf}">

                            <div class="form-group">
                                <label for="nameBookShelf">Nhập tên mới</label>
                                <input type="text" name="nameBookShelf" id="nameBookShelf" class="form-control"
                                    value="${bookshelf.nameBookShelf}">
                            </div>

                            <div class="form-group py-3">
                                <div class="d-grid gap-2">
                                    <input type="submit" value="Save" class="btn btn-primary mt-1">
                                </div>

                                <div class="d-grid gap-2">
                                    <input type="button" value="Cancel" class="btn btn-secondary mt-1"
                                        onclick="location.href='/QLTV/ManageBookShelf'">
                                </div>
                            </div>
                        </form>
                    <% } else { %>
                        <p>Kệ sách không tồn tại!</p>
                    <% } %>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
