<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thông tin hội viên</title>
</head>
<body>
	<section class="content my-3">
		<div id="wrapper">
		    <div class="container">
		        <div class="row justify-content-around">
		        <% if (request.getAttribute("reader") != null) { %>
		            <form action="EditReader" method="post"class="col-md-5 bg-light p-3 my-3">
		            	<h1 class=" tex-uppercase h3 py-3">Edit Member's Information</h1>
							<div class="form-group">
							    <label for="nameReader">Change Reader's Name</label>
							     <input type="hidden" name="idReader" value="${reader.idReader}">
							    <input type="text" name="nameReader" id="nameReader" class="form-control" value="${reader.nameReader}">
							</div>		
							<div class="form-group">
							    <label for="identity">Change Identity</label>
							    <input type="text" name="identity" id="identity" class="form-control" value="${reader.identity}">
							</div>
							
							<div class="form-group">
							    <label for="telReader">Change TelePhone</label>
							    <input type="text" name="telReader" id="telReader" class="form-control" value="${reader.telReader}">
							</div>
						                    
						    <div class="form-group py-3">
						    	<div class="d-grid gap-2">
						        	<input type="submit" value="Save" class=" btn btn-primary mt-1" >
						     	</div>
						
						     	<div class="d-grid gap-2">
						         	<input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='/QLTV/ManageReader'">
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