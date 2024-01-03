<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Category</title>
</head>
<body>
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <% if (request.getAttribute("category") != null) { %>
                        <form action="EditCategory" method="post" class="col-md-5 bg-light p-3 my-3 rounded">
                            <h1 class="tex-uppercase h3 py-3">Edit Category</h1>
                            <input type="hidden" name="idCategory" value="${category.idCategory}">
                            <div class="form-group">
                                <label for="nameCategory">Edit New Category's Name</label>
                                <input type="text" name="nameCategory" id="nameCategory" class="form-control"
                                    value="${category.nameCategory}">
                            </div>

                            <div class="form-group py-3">
                                <div class="d-grid gap-2">
                                    <input type="submit" value="Lưu" class="btn btn-primary mt-1">
                                </div>

                                <div class="d-grid gap-2">
                                    <input type="button" value="Hủy" class="btn btn-secondary mt-1"
                                        onclick="location.href='/QLTV/ManageCategory'">
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