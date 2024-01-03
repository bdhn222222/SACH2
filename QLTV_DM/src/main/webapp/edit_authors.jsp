<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa thông tin tác giả</title>
</head>
<body class="bg-dark">
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <% if (request.getAttribute("authors") != null) { %>
                        <form action="EditAuthors" method="post" class="col-md-5 bg-light p-3 my-3 rounded">
                            <h1 class="tex-uppercase h3 py-3">Chỉnh sửa Tác Giả</h1>
                            <input type="hidden" name="idAuthors" value="${authors.idAuthors}">
                            <div class="form-group">
                                <label for="nameAuthors">Nhập tên mới</label>
                                <input type="text" name="nameAuthors" id="nameAuthors" class="form-control"
                                    value="${authors.nameAuthors}">
                            </div>

                            <div class="form-group py-3">
                                <div class="d-grid gap-2">
                                    <input type="submit" value="Lưu" class="btn btn-primary mt-1">
                                </div>

                                <div class="d-grid gap-2">
                                    <input type="button" value="Hủy" class="btn btn-secondary mt-1"
                                        onclick="location.href='/QLTV/ManageAuthors'">
                                </div>
                            </div>
                        </form>
                    <% } else { %>
                        <p>Category not found!</p>
                    <% } %>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
