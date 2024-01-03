<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Member
</title>
</head>
<body class="bg-dark">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="AddReader" method="post" class="bg-black text-light col-md-5 bg-light p-3 my-3">
                        <h1 class=" tex-uppercase h3">Add New Member</h1>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                            <label for="nameReader">Name</label>
                            <input type="text" name="nameReader" id="nameReader" class="form-control bg-dark" style="color:white;">
                        </div>

                        <div class="form-group">
                            <label for="cccd">Identity</label>
                            <input type="text" name="identity" id="identity" class="form-control bg-dark" style="color:white;">
                        </div>
                        
                        <div class="form-group">
                            <label for="telReader">Telephone</label>
                            <input type="text" name="telReader" id="telReader" class="form-control bg-dark" style="color:white;">
                        </div>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                        	<div class="d-grid gap-2">
	                            <input type="submit" value="Save" class=" btn btn-primary mt-1">
	                        </div>
	
	                        <div class="d-grid gap-2">
	                            <input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='/QLTV/ManangeReader'">
	                        </div>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>