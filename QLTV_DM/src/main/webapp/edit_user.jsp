<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User's Information</title>
</head>
<body class="bg-dark">
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <% if (request.getAttribute("User") != null) { %>
                        <form action="EditUser" method="post" class="col-md-5 bg-light p-3 my-3 rounded">
                            <h1 class="tex-uppercase h3 py-3">Edit User Account</h1>
                            <input type="hidden" name="idUser" value="${User.idUser}">
                            <div class="form-group">
                                <label for="username">Type New User's Name</label>
                                <input type="text" name="username" id="username" class="form-control"
                                    value="${User.username}">

								<label for="password">Type New User's Password</label>
                                <input type="text" name="password" id="password" class="form-control"
                                    value="${User.password}">
                            </div>

                            <div class="form-group py-3">
                                <div class="d-grid gap-2">
                                    <input type="submit" value="Save" class="btn btn-primary mt-1">
                                </div>

                                <div class="d-grid gap-2">
                                    <input type="button" value="Cancel" class="btn btn-secondary mt-1"
                                        onclick="location.href='/QLTV/ManageUser'">
                                </div>
                            </div>
                        </form>
                    <% } else { %>
                        <p>User not found!</p>
                    <% } %>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
