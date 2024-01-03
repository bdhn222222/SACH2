<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm kệ sách</title>
</head>
<body class="bg-dark">
	<section class="content">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="AddBookShelf" method="post"  class="bg-black text-light col-md-5 bg-light p-3 my-3">
                        <h1 class=" tex-uppercase h3 py-3">Thêm kệ sách</h1>
                        <div class="form-group">
                            <label for="nameBookShelf">Nhập tên kệ sách</label>
                            <input type="text" name="nameBookShelf" id="nameBookShelf" class="form-control bg-dark" style="color:white;">
                        </div>

                        <div class="form-group py-3">
                        	<div class="d-grid gap-2">
	                            <input type="submit" value="Lưu" class=" btn btn-primary mt-1">
	                        </div>
	
	                        <div class="d-grid gap-2">
	                            <input type="button" value="Hủy" class="btn btn-secondary mt-1" onclick="location.href='/QLTV/ManageBookShelf'">
	                        </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>