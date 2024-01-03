<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.bean.BookShelf" %>
<%@ page import="model.bean.Category" %>
<%@ page import="model.bean.Authors" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>
	 <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
    <c:if test="${not empty book}">
        <c:set var="bookShelfList" value="${bookShelfList}" />
        <c:set var="authorsList" value="${authorsList}" />
        <c:set var="categoryList" value="${categoryList}" />
    
        <form action="EditBook" method="post" enctype="multipart/form-data" class="col-md-5 bg-light p-3 my-3 rounded">
        <h1 class="tex-uppercase h3 py-3">Edit Book</h1>
            <input type="hidden" name="idBook" value="${book.idBook}" />
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="nameBook" value="${book.nameBook}" /></td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td>
                        <select name="category">
                            <c:forEach var="category" items="${categoryList}">
                                <option value="${category.idCategory}" <c:if test="${category.idCategory == book.category.idCategory}">selected</c:if>>
                                    ${category.nameCategory}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Bookshelf:</td>
                    <td>
                        <select name="bookShelf">
                            <c:forEach var="bookShelf" items="${bookShelfList}">
                                <option value="${bookShelf.idBookShelf}" <c:if test="${bookShelf.idBookShelf == book.bookShelf.idBookShelf}">selected</c:if>>
                                    ${bookShelf.nameBookShelf}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Authors:</td>
                    <td>
                        <select name="authors">
                            <c:forEach var="authors" items="${authorsList}">
                                <option value="${authors.idAuthors}" <c:if test="${authors.idAuthors == book.authors.idAuthors}">selected</c:if>>
                                    ${authors.nameAuthors}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="text" name="amount" value="${book.amount}" /></td>
                </tr>
                <div class="form-group">
					<label for="exampleInputFile">Thay ảnh bìa (Nếu cần)</label>
					<div class="input-group">
					<div class="custom-file">
						<input type="hidden" name="image_str"
								value="${book.getImage()}" /> <input type="file"
								accept="image/png, image/jpeg" class="custom-file-input"
								id="customFile" name="image"> <label
								class="custom-file-label" for="customFile"
								style="color: #a6b0ba;">Nhấn đây để chọn file</label>
						</div>
					</div>
				</div>
                
                <tr>
                    <td colspan="2"><input type="submit" value="Save" class="btn btn-secondary mt-1" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="Hủy" class="btn btn-secondary mt-1"
                                        onclick="location.href='/QLTV/ManageBook'">
                                        </tr>
            </table>
        </form>
    </c:if>
</body>
</html>s