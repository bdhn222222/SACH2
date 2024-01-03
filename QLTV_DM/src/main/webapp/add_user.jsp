<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Add User</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="AddUser" method="post" class="bg-black text-light col-md-5 bg-light p-3 my-3" >
                        <h1 class=" tex-uppercase h3">Add new user to the library</h1>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                            <label for="Username">The User's name</label>
                            <input type="hidden" name="idUser" value="${User.idUser}">
                            <input type="text" name="username" id="username" class="form-control bg-dark text-light">
                            <label for="Password">The User's password</label>
                            <input type="text" name="password" id="password" class="form-control bg-dark text-light">
                        </div>
                        
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                        	<div class="d-grid gap-2">
	                            <input type="submit" value="Add" class=" btn btn-primary mt-1" >
	                        </div>
	
	                        <div class="d-grid gap-2">
	                            <input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='/QLTV/ManageUser'">
	                        </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>